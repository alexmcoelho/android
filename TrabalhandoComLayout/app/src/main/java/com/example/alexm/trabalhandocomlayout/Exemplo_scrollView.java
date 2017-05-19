package com.example.alexm.trabalhandocomlayout;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Exemplo_scrollView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_exemplo_scroll_view2);

        LinearLayout layout = (LinearLayout) findViewById(R.id.layout1);

        for(int i = 1; i <= 100; i++){
            TextView text = new TextView(this);
            //É obrigatoriamente o layout_width e layout_heigth
            text.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            text.setText("Texto: " + i);
            layout.addView(text);
        }
    }
}
