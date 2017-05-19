package com.example.alexm.bindservice;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    MyService mBoundService;
    boolean mServiceBound = false;
    TextView timestampText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timestampText = (TextView)findViewById(R.id.tcTempo);
        Button printTimestampButton = (Button)findViewById(R.id.btPrint);
        Button stopTimestampButton = (Button)findViewById(R.id.btParar);
        printTimestampButton.setOnClickListener(printTime());
        stopTimestampButton.setOnClickListener(callStopService());
    }

    private View.OnClickListener callStopService() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mServiceBound){
                    unbindService(mServiceConnection);
                    mServiceBound = false;
                }
                Intent intent = new Intent(MainActivity.this, MyService.class);
                stopService(intent);
            }
        };
    }

    private View.OnClickListener printTime() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mServiceBound){
                    timestampText.setText(mBoundService.getTimestamp());
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(getApplicationContext(), MyService.class);
        startService(intent);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mServiceBound){
            unbindService(mServiceConnection);
            mServiceBound = false;
        }
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.MyBinder myBinder = (MyService.MyBinder) service;
            mBoundService = myBinder.getService();
            mServiceBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mServiceBound = false;
        }
    };
}
