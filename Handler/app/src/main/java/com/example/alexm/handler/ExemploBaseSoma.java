package com.example.alexm.handler;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public abstract class ExemploBaseSoma extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo_base_soma);

        Button b = (Button) findViewById(R.id.btOk);
        b.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText n1 = (EditText) findViewById(R.id.txt01);
                EditText n2 = (EditText) findViewById(R.id.txt02);
                int i1 = Integer.parseInt(n1.getText().toString());
                int i2 = Integer.parseInt(n2.getText().toString());
                somar(i1, i2);
            }                
        });
    }

    protected abstract void somar(int i1, int i2);

}
