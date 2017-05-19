package com.example.alexm.trabalhandocomlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ActivityLayoutIdGenerica extends AppCompatActivity {

    private static final String TAG = "ID";
    @Override
    protected void onCreate(Bundle icicle) {

        super.onCreate(icicle);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            int id = extras.getInt("layoutResId");
            Log.i(TAG, "abrir layout"+id);
            setContentView(id);
        }else{
            TextView text = new TextView(this);
            text.setText("precisa informar o id do layout");
            setContentView(text);
        }
    }
}
