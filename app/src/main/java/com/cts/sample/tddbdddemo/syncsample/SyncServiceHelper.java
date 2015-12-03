package com.cts.sample.tddbdddemo.syncsample;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.cts.sample.tddbdddemo.introscreen.WelcomeScreenActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by shanmg02 on 03/12/15.
 */
public class SyncServiceHelper {

    public static final String TIME = "10:50";

    public static void showNotification(Context context, boolean callNextNotification) {

        Intent mIntent = new Intent(context, WelcomeScreenActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(context, SyncService.NOTIFICATION_ID, mIntent, 0);

        String notificationText = "You got a  new notification";

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setContentTitle("Notification Sample")
                        .setContentIntent(pIntent)
                        .setContentText(notificationText);

        Notification storyNotification = mBuilder.build();

        // hide the notification after its selected
        storyNotification.flags |= Notification.FLAG_AUTO_CANCEL;

        Log.d(SyncService.TAG, "Send the notification now::::" + System.currentTimeMillis());

        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(SyncService.NOTIFICATION_ID, storyNotification);


        if (callNextNotification) {
            executeAlarmToNotification(context);
        }

    }

    public final static int SERVICE_CALL_REQUEST_CODE = 100;

    public static void executeAlarmToNotification(Context context) {


        PendingIntent pendingIntent =
                getPendingIntent(context, SERVICE_CALL_REQUEST_CODE);

        int[] syncTime = getNextNotificationTime();

        boolean nextDayEvent = (syncTime == null);

        if (nextDayEvent) {
            syncTime = getStartEventTime();
        }

        setAlarmToNotification(context, pendingIntent,
                syncTime[0], syncTime[1], nextDayEvent);

    }

    /**
     * This method used to enable the notification and register the alarm service
     * for fetch the data from the server.
     */
    public static int[] getStartEventTime() {

        int[] _notifyTime = new int[2];

        String time = TIME;
        String[] notificationTime = time.split(",");
        String notifyTime = notificationTime[0];
        _notifyTime[0] = Integer.parseInt(notifyTime.split(":")[0]);
        _notifyTime[1] = Integer.parseInt(notifyTime.split(":")[1]);

        return _notifyTime;
    }

    public static int[] getNextNotificationTime() {

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        int[] _notifyTime = new int[2];
        try {
            Date cDate = sdf.parse(sdf.format(new Date(System.currentTimeMillis())));
            System.out.println(cDate);
            String time = TIME;
            String[] notificationTime = time.split(",");
            String notifyTime = null;

            for (String mTime : notificationTime) {
                System.out.println(mTime);
                Date t = sdf.parse(mTime);
                long diff = (t.getTime() - cDate.getTime()) / (60 * 1000) % 60;
                if (diff > 0) {
                    notifyTime = mTime;
                    break;
                }
            }

            if (notifyTime == null) {
                return null;
            }


            _notifyTime[0] = Integer.parseInt(notifyTime.split(":")[0]);
            _notifyTime[1] = Integer.parseInt(notifyTime.split(":")[1]);


        } catch (ParseException e) {
            e.printStackTrace();
        }
        return _notifyTime;

    }

    public static PendingIntent getPendingIntent(Context context, int requestCode) {
        Intent intent = new Intent(context, SyncService.class);
        PendingIntent pendingIntent = PendingIntent.getService(context, requestCode,
                intent, PendingIntent.FLAG_CANCEL_CURRENT);
        return pendingIntent;
    }


    /**
     * This method is used to set the alarm with interval on daily basis to call the API
     *
     * @param context
     * @param pendingIntent
     * @param hour
     * @param minutes
     */
    public static void setAlarmToNotification(Context context, PendingIntent pendingIntent,
                                              int hour, int minutes, boolean nextDayEvent) {
        // Stop the current notification if any
        stopNotificationService(context, pendingIntent);

        System.out.println("**********************Next Sync:" + hour + ":" + minutes);
        Calendar mCal = Calendar.getInstance();

        if (nextDayEvent)
            mCal.add(Calendar.DAY_OF_YEAR, 1);

        mCal.set(Calendar.HOUR_OF_DAY, hour);
        mCal.set(Calendar.MINUTE, minutes);
        mCal.set(Calendar.SECOND, 0);
        mCal.set(Calendar.MILLISECOND, 0);

        AlarmManager mAlarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        mAlarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, mCal.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, pendingIntent);
    }

    /**
     * Used to cancel the current pending intent if user wants to turn off the
     * notification from the settings.
     *
     * @param context
     * @param pendingIntent
     */
    public static void stopNotificationService(Context context, PendingIntent pendingIntent) {
        AlarmManager mAlarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        mAlarmManager.cancel(pendingIntent);
    }
}
