/**
 *  WaveView
 *
 * Show progress as a rising wave
 *
 *  @version    1.0
 *  @author     Tony O'Rourke (sonicwrx@gmail.com)
 */
package net.rallaesystems.waveview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

public class WaveView extends View {

    private String TAG = getClass().getSimpleName();

    private RefreshProgressRunnable mRefreshProgressRunnable;

    private Paint mPaint;
    private int screen_width = 0;
    private int screen_height = 0;
    private int NUM_WAVES = 1;
    int a = 30; //amplitude (1/2 of total wave height) in pixels
    float max_val = 250f;
    float current_val = 0f; //this gets updated as the state changes
    long start_time = 0L;
    Path path = null;
    int T = 0; //length in pixels from top of one wave to next
    Point cp1; // For drawing bezier, control point 1
    Point cp2;  // For drawing bezier, control point 2
    Point endp; // For drawing bezier, end point
    long wave_duration_ms = 2000L;

    public final int DEFAULT_WAVE_ALPHA = 30;
    public static final int DEFAULT_COLOR = Color.BLACK;

    private long TARGET_REFRESH_RATE_MS = 16;
    //    public WaveView(Context context) {
//        super(context);
//
//    }
    public WaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {

        mPaint = new Paint();
        mPaint.setColor(DEFAULT_COLOR);
        mPaint.setAntiAlias(true);
        mPaint.setAlpha(DEFAULT_WAVE_ALPHA);
        path = new Path();
        start_time = System.currentTimeMillis();
        cp1 = new Point(0,T / 4);
        cp2 = new Point(T / 4,a * 2);
        endp = new Point(T / 2,a * 2);

    }
    @Override
    public void draw(Canvas canvas) {

        //Log.i(TAG, "onDraw");
        super.draw(canvas);
        //canvas.drawLine(10,10, screen_width, screen_height, mPaint);
        canvas.drawPath(path, mPaint);
    }

    private void calcPath() {

        long x_offset = 0;
        long time_diff = System.currentTimeMillis() - start_time;
        // x_offset = (int)time_diff % T;
        x_offset = T * (time_diff % wave_duration_ms) / wave_duration_ms;

        // Log.i(TAG, "T = " + T + " x_offset = " + x_offset);

        int startY = mapY();
        long startX = -1 * x_offset;
        path.reset();
        path.moveTo(startX, startY);

        for(int i = 0; i < NUM_WAVES + 2; i++) {

            cp1.x = T / 4;
            cp1.y = 0;

            cp2.x = T / 4;
            cp2.y = a * 2;


            endp.x = T / 2;
            endp.y = a * 2;

            path.rCubicTo(cp1.x, cp1.y, cp2.x, cp2.y, endp.x, endp.y);

            cp1.x = T / 4;
            cp1.y = 0;

            cp2.x = T / 4;
            cp2.y = a * 2 * -1;

            endp.x = T / 2;
            endp.y = a * 2 * -1;

            path.rCubicTo(cp1.x, cp1.y, cp2.x, cp2.y, endp.x, endp.y);



        }
        path.lineTo(screen_width + x_offset, screen_height);
        path.lineTo( x_offset * -1, screen_height);
        path.close();


        //  Log.i(TAG, "calcPath");

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        super.onSizeChanged(w, h, oldw, oldh);
        screen_width = w;
        screen_height = h;
        T = screen_width / NUM_WAVES;
        // Log.i(TAG, "onSizeChanged: w: " + w + " h: " + h + " T: " + T);
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        if (View.GONE == visibility) {
            removeCallbacks(mRefreshProgressRunnable);
        } else {
            removeCallbacks(mRefreshProgressRunnable);
            mRefreshProgressRunnable = new RefreshProgressRunnable();
            post(mRefreshProgressRunnable);
        }
    }

    public void setCurrentValue(float currentValue) {

        current_val = currentValue;
    }

    public void setMaxValue(float max) {

        max_val = max;
    }

    private int mapY() {

        float result = screen_height - (screen_height * current_val / max_val);
        return (int) result;

    }
    private class RefreshProgressRunnable implements Runnable {
        public void run() {
            synchronized (WaveView.this) {

                long start = System.currentTimeMillis();

                calcPath();

                invalidate();

                long gap = TARGET_REFRESH_RATE_MS - (System.currentTimeMillis() - start);
                postDelayed(this, gap < 0 ? 0 : gap);
            }
        }
    }
}
