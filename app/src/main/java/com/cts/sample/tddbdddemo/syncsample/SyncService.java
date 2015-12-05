package com.cts.sample.tddbdddemo.syncsample;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

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
