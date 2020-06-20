package com.example.onlinebankingapplication;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import java.util.HashMap;

public class Postmaster extends Service {
    private HashMap<String, Details> detailsMap = new HashMap<>();

    @Override
    public void onCreate() {
        super.onCreate();
        IntentFilter filters = new IntentFilter();
        filters.addAction(Intent.ACTION_POWER_CONNECTED);
        filters.addAction(Intent.ACTION_POWER_DISCONNECTED);
        registerReceiver(powerStateReceiver, filters);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Bundle data = intent.getExtras();
        Details details = (Details) data.getSerializable("details");
        if (details != null) {
            detailsMap.put(details.getNic(), details);
        }
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(powerStateReceiver);
    }

    BroadcastReceiver powerStateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction() != null) {
                if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
                    Log.d("State", "Connected!");
                    Log.d("PoolSize", String.valueOf(detailsMap.size()));
                }
                if (intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)) {
                    Log.d("State", "Disconnected!");
                }
            }
        }
    };
}
