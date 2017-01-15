/**
 *  MeDitationTime
 *
 *  Settings.class: Controller class for the settings section
 *
 *  @version    1.0
 *  @author     Meditate to Regenerate (meditatetoregenerate.org)
 */

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

public class Settings extends Activity{

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

        //user setted time
        int hour = timePicker.getCurrentHour();
        int minute = timePicker.getCurrentMinute();

        //store user define time in calendar object
        calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);

        not_btn = (Button) findViewById(R.id.notification);
        not_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //notification button pass the setting to myreceiver class
                Intent intent = new Intent(getApplicationContext(), MyReceiver.class);
                pendingIntent = PendingIntent.getBroadcast(Settings.this, 0,intent, PendingIntent.FLAG_UPDATE_CURRENT);
                //start up the alarm object
                am = (AlarmManager) Settings.this.getSystemService(Settings.this.ALARM_SERVICE);
                //repeat the notification everyday
                am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
                //startActivity(intent);
                stop_btn.setEnabled(true);
                not_btn.setEnabled(false);

            }
        });

        //cancel the notification
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



    } //end onCreate
}