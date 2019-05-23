/**
 *  MeDitationTime
 *
 *  Progress.class: Controller class for the progress section
 *
 *  @version    1.0
 *  @author     Meditate to Regenerate (meditatetoregenerate.org)
 */

package com.meditation.metime;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import static com.meditation.metime.R.id.information;

public class Progress extends BaseActivityWithDrawer {

    // enables drawer
    @Override
    public boolean shouldEnableDrawer() {
        return true;
    }

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

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

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
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);

            if(position == 0) initSystemStats();
            if(position == 1) initEmoStats();

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
    public void initEmoStats(){
        seekBar1 = (SeekBar) findViewById(R.id.seekBarThoughtless);
        seekBar2 = (SeekBar) findViewById(R.id.seekBarPeaceful);
        seekBar3 = (SeekBar) findViewById(R.id.seekBarBalanced);
        graph = (GraphView) findViewById(R.id.progressGraph);

        thoughtlessSeries = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 3)
        });
        balancedSeries = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 3),
                new DataPoint(1, 2),
                new DataPoint(2, 3),
                new DataPoint(3, 4),
                new DataPoint(4, 5)
        });
        peacefulSeries = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 0),
                new DataPoint(1, 1),
                new DataPoint(2, 4),
                new DataPoint(3, 5),
                new DataPoint(4, 7)
        });

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

                currentDay += 1;

                thoughtlessSeries.appendData(new DataPoint(currentDay, thoughtless),true, 30);
                balancedSeries.appendData(new DataPoint(currentDay, balanced),true, 30);
                peacefulSeries.appendData(new DataPoint(currentDay, peaceful),true, 30);

            }
        });

    }

// End class
}
