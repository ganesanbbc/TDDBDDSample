package com.cts.sample.tddbdddemo.syncsample;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SyncContext;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.cts.sample.tddbdddemo.introscreen.WelcomeScreenActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.LogManager;

/**
 * Created by shanmg02 on 03/12/15.
 */
public class SyncService extends IntentService {
    public static final String TAG = IntentService.class.getSimpleName();
    public static final int NOTIFICATION_ID = 500;

    public SyncService() {
        super(SyncService.class.getName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {


        Log.d(TAG, "***************************SERVICE START****************************");
        Log.d(TAG, "Background Sycn-Service Called @ " + System.currentTimeMillis());

        SyncServiceHelper.showNotification(this, true);

    }

}
