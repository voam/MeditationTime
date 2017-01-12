package com.meditation.metime;

import java.util.Calendar;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class Notification extends Activity{

    Calendar calendar;
    AlarmManager am;
    TimePicker timePicker;
    Button stop_btn;
    Button not_btn;
    PendingIntent pendingIntent;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        timePicker = (TimePicker) findViewById(R.id.timePicker);

        int hour = timePicker.getCurrentHour();
        int minute = timePicker.getCurrentMinute();

        calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);

        not_btn = (Button) findViewById(R.id.notification);
        not_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MyReceiver.class);
                pendingIntent = PendingIntent.getBroadcast(Notification.this, 0,intent, PendingIntent.FLAG_UPDATE_CURRENT);
                am = (AlarmManager) Notification.this.getSystemService(Notification.this.ALARM_SERVICE);
                am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
                //startActivity(intent);
                stop_btn.setEnabled(true);
                not_btn.setEnabled(false);

            }
        });

        stop_btn = (Button) findViewById(R.id.stop_not);
        stop_btn.setEnabled(false);
        stop_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                am.cancel(pendingIntent);
                stop_btn.setEnabled(false);
                not_btn.setEnabled(true);


            }
        });

        // Intent intent1 = new Intent(Notification.this, MyReceiver.class);


    } //end onCreate
}