/**
 *  MeDitationTime
 *
 *  Progress.class: Controller class for the progress section
 *
 *  @version    1.0
 *  @author     Meditate to Regenerate (meditatetoregenerate.org)
 */

package org.meditatetoregenerate.metime;

import android.content.AsyncQueryHandler;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BaseSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.Series;

import org.meditatetoregenerate.metime.R;
import org.meditatetoregenerate.metime.db.AppDatabase;
import org.meditatetoregenerate.metime.db.AppRepository;
import org.meditatetoregenerate.metime.db.ProgressStat;
import org.meditatetoregenerate.metime.viewModels.ProgressViewModel;

import java.util.List;

import static org.meditatetoregenerate.metime.R.id.information;

public class Progress extends BaseActivityWithDrawer {

    // enables drawer
    @Override
    public boolean shouldEnableDrawer() {
        return true;
    }

    private String TAG2 = getClass().getSimpleName();
    //Slider
    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int[] layouts;

    //Meditation stats
    private PrefManager prefManager;

    //Emotional stats
    private int currentDay = 4;
    private SeekBar seekBar1;
    private SeekBar seekBar2;
    private SeekBar seekBar3;
    private GraphView graph;
    private LineGraphSeries<DataPoint> thoughtlessSeries, balancedSeries, peacefulSeries;

    private ProgressViewModel viewModel;
    private boolean inited = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // sets the progress layout to the BaseActivityWithDrawer
        LayoutInflater.from(this).inflate(R.layout.activity_progress, getFrame());

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);


        // layouts of all slides
        layouts = new int[]{
                R.layout.slide_progress_1,
                R.layout.slide_progress_2};

        // adding bottom dots
        addBottomDots(0);

        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);


        //App Buttons
        ImageButton info_btn = (ImageButton) findViewById(information);
        info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Info_Progress.class);
                startActivity(intent);
            }
        });

        viewModel = ViewModelProviders.of(this).get(ProgressViewModel.class);

        viewModel.getProgressStats().observe(this, stats -> {
            // update UI
            Log.i(TAG2, "observe callback...");

            if (stats != null) {
                Log.i(TAG2, "stats not null: " +  stats.size());
                initEmoStats( stats );

//                for( ProgressStat stat : stats) {
//                    Log.i(TAG2, "Stat: " +  stat.toString());
//                }

            }
            else {
            //    Log.i(TAG2, "stats are null ");
            }

        });
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.element_inactive_progress));
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0) dots[currentPage].setTextColor(getResources().getColor(R.color.element_active_progress));
    }

//    private int getItem(int i) {
//        return viewPager.getCurrentItem() + i;
//    }

    // Viewpager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    // Viewpager adapter
    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Log.i(TAG2,  String.format("MyViewPagerAdapter::instantiateItem %d", position));
            layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);

            if(position == 0) initSystemStats();
            if(position == 1) initEmoStats(viewModel.getProgressStats().getValue() );

            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }


    //-----------------------------------------------------------------------------------------
    // MEDITATION STATS
    //-----------------------------------------------------------------------------------------
    public void initSystemStats(){
        prefManager = new PrefManager(this);

        RelativeLayout streak = (RelativeLayout)findViewById(R.id.streak);
        RelativeLayout totalSessions = (RelativeLayout)findViewById(R.id.totalSessions);
        RelativeLayout avgDuration = (RelativeLayout)findViewById(R.id.avgDuration);

        View streakView = streak.findViewById(R.id.button_text);
        View sessionsView = totalSessions.findViewById(R.id.button_text);
        View durationView = avgDuration.findViewById(R.id.button_text);

        if (null != streakView && streakView instanceof TextView) ((TextView)streakView).setText(Integer.toString(prefManager.getStreak())+" days");
        if (null != sessionsView && sessionsView instanceof TextView) ((TextView)sessionsView).setText(Integer.toString(prefManager.getTotalSessions()));
        if (null != durationView && durationView instanceof TextView) ((TextView)durationView).setText(Integer.toString(prefManager.getAvgDuration())+" min");

    }


    //-----------------------------------------------------------------------------------------
    // EMOTIONAL STATS
    //-----------------------------------------------------------------------------------------
    public void initEmoStats(List<ProgressStat> stats){

        Log.i(TAG2, "initEmoStats");

        if (stats == null) {
            return;
        }
        graph = (GraphView) findViewById(R.id.progressGraph);
        if (graph == null) {
            Log.i(TAG2, "graph is null, returning....");
            return;
        }
        seekBar1 = (SeekBar) findViewById(R.id.seekBarThoughtless);
        seekBar2 = (SeekBar) findViewById(R.id.seekBarPeaceful);
        seekBar3 = (SeekBar) findViewById(R.id.seekBarBalanced);
        int x = 0;

       // if (viewModel.getStatsInitialized()) {
            if (inited) {
       //     inited
                Log.i(TAG2, "already initialized");
            int size = stats.size();
            ProgressStat last = stats.get(size -1);
            thoughtlessSeries.appendData(new DataPoint(size, last.getThoughtless()),true, 30);
            balancedSeries.appendData(new DataPoint(size, last.getBalanced()),true, 30);
            peacefulSeries.appendData(new DataPoint(size, last.getPeaceful()),true, 30);
            return;


        }

            Log.i(TAG2, "not initialized...");
        Log.i(TAG2, "stats.size" + stats.size());
        DataPoint[] thoughtless = GetDataPoints(stats, 0);
        DataPoint[] peaceful = GetDataPoints(stats, 1);
        DataPoint[] balanced = GetDataPoints(stats, 2);
        thoughtlessSeries = new LineGraphSeries<>(thoughtless);
        balancedSeries = new LineGraphSeries<>(balanced);
        peacefulSeries   = new LineGraphSeries<>(peaceful);

        thoughtlessSeries.setColor(Color.rgb(219, 140, 139));
        thoughtlessSeries.setThickness(8);
        thoughtlessSeries.setDrawDataPoints(true);
        thoughtlessSeries.setDataPointsRadius(10);

        balancedSeries.setColor(Color.rgb(94, 155, 93));
        balancedSeries.setThickness(8);
        balancedSeries.setDrawDataPoints(true);
        balancedSeries.setDataPointsRadius(10);

        peacefulSeries.setColor(Color.rgb(74, 134, 232));
        peacefulSeries.setThickness(8);
        peacefulSeries.setDrawDataPoints(true);
        peacefulSeries.setDataPointsRadius(10);

        graph.addSeries(thoughtlessSeries);
        graph.addSeries(balancedSeries);
        graph.addSeries(peacefulSeries);
        graph.getViewport().setScrollable(true);
        graph.getViewport().setXAxisBoundsManual(true);
        //graph.getViewport().setYAxisBoundsManual(true);
        if(currentDay>4){
            graph.getViewport().setMinX(currentDay-4);
            graph.getViewport().setMaxX(currentDay);
        }


        RelativeLayoutButton btnSave = new RelativeLayoutButton(this,R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int thoughtless = seekBar1.getProgress();
                int balanced = seekBar2.getProgress();
                int peaceful = seekBar3.getProgress();

             //   Log.i(TAG2, "saving data....");
                ProgressStat stat = new ProgressStat();
                stat.setDateTime(System.currentTimeMillis() / 1000L);
                stat.setThoughtless(thoughtless);
                stat.setBalanced(balanced);
                stat.setPeaceful(peaceful);
                AppRepository repo = ((MeTimeApp) getApplication()).getRepository();
                repo.insert(stat);
            }
        });
        viewModel.setStatsInitialized(true);
        inited = true;
    }

  private DataPoint[] GetDataPoints(List<ProgressStat> stats, int type) {

    if (stats == null ) {
        return new DataPoint[0];
    }
    int size = stats.size();
    //the graph library requires data as an array of DataPoints;
    DataPoint[] result = new DataPoint[size];

    int x = 0;
    for(ProgressStat s : stats) {
        if (type == 0) {
            result[x] = new DataPoint(x, s.getThoughtless());
        }
        if (type == 1) {
            result[x] = new DataPoint(x, s.getPeaceful());
        }
        if (type == 2) {
            result[x] = new DataPoint(x, s.getBalanced());
        }
        x++;
    }
    return result;
  }

// End class
}
