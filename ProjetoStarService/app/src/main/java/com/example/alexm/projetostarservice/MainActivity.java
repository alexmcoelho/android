package com.example.alexm.projetostarservice;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public static final Class<? extends Service> CLS = HelloIntentService.class;
    public void onClickStart(View v){
        startService(new Intent(this, CLS));
    }
    public void onClickStop(View view){
        stopService(new Intent(this, CLS));
    }
}
