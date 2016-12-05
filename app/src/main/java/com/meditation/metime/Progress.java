package com.meditation.metime;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Progress extends AppCompatActivity {

    private int currentDay = 4;
    private SeekBar seekBar1, seekBar2, seekBar3;
    private GraphView graph;
    private LineGraphSeries<DataPoint> thoughtlessSeries, balancedSeries, peacefulSeries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        seekBar3 = (SeekBar) findViewById(R.id.seekBar3);

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


        Button btnSave = (Button) findViewById(R.id.btnSave);
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

}
