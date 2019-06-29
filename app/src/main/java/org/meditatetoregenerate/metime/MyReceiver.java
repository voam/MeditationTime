/**
 *  MeDitationTime
 *
 *  MyReceiver.class: Sets up a meditation reminder notification
 *
 *
 *  @version    1.0
 *  @author     Meditate to Regenerate (meditatetoregenerate.org)
 */

package org.meditatetoregenerate.metime;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import androidx.legacy.content.WakefulBroadcastReceiver;

import org.meditatetoregenerate.metime.R;

//wakefulbroadcastreceiver is able to run on the backend so that app cannot kill it.
public class MyReceiver extends WakefulBroadcastReceiver
{

    private static int MID =0;
    public static NotificationManager  notificationManager;

    public void onReceive(Context context, Intent intent) {

        long when = System.currentTimeMillis();
        notificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);

        //intent to mainmenu if notification is pressed
        Intent notificationIntent = new Intent(context, MainMenu.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,
                notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        //set up the alarm voice
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        //set the message of notification
        NotificationCompat.Builder mNotifyBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.icn_meditator_blue)
                .setContentTitle("MeDitationTime")
                .setContentText("It's time to meditate!").setSound(alarmSound)
                .setAutoCancel(true).setWhen(when)
                .setContentIntent(pendingIntent)
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000});
        notificationManager.notify(MID, mNotifyBuilder.build());
        MID++;

    }
}