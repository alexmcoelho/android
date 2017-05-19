package com.example.alexm.bindservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Chronometer;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }
    public class MyBinder extends Binder {
        MyService getService(){
            return MyService.this;
        }
    }
    private static String LOG_TAG = "aula";
    private IBinder mBinder = new MyBinder();
    private Chronometer mChronometer;

    @Override
    public void onCreate() {
        Log.v(LOG_TAG,"in onBind");
        Toast.makeText(getApplication(), "onBind Service", Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

    @Override
    public void onRebind(Intent intent) {
        Log.v(LOG_TAG,"in onRebind");
        Toast.makeText(getApplication(), "onRebind Service", Toast.LENGTH_SHORT).show();
        super.onRebind(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.v(LOG_TAG,"in onBind");
        Toast.makeText(getApplication(), "onBind Service", Toast.LENGTH_SHORT).show();
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.v(LOG_TAG,"in onUnbind");
        Toast.makeText(getApplication(), "onUnbind Service", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v(LOG_TAG,"in onDestroy");
        Toast.makeText(getApplication(), "onDestroy Service", Toast.LENGTH_SHORT).show();
        mChronometer.stop();
    }
    public String getTimestamp(){
        long elapsedMillis = SystemClock.elapsedRealtime() - mChronometer.getBase();
        int hours = (int) (elapsedMillis / 3600000);
        int minutes = (int) (elapsedMillis - hours  * 3600000) / 60000;
        int seconds = (int) (elapsedMillis - (hours  * 3600000) - (minutes * 60000)) / 1000;
        int miliseconds = (int) elapsedMillis - (hours  * 3600000) - (minutes * 60000) - (seconds * 1000);
        return hours + ":" + minutes + ":" + seconds + ":" + miliseconds;

    }

    @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
        mChronometer = new Chronometer(this);
        mChronometer.setBase(SystemClock.elapsedRealtime());
        mChronometer.start();
        return super.onStartCommand(intent, flags, startId);
    }
}

