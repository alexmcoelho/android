package com.example.alexm.handler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SomarThread extends ExemploBaseSoma {

    @Override
    protected void somar(final int n1, final int n2) {
        new Thread(){
            public void run(){
                int soma = n1 + n2;
                TextView t = (TextView) findViewById(R.id.labelSoma);
                t.setText(String.valueOf("Soma: "+soma));
            }
        }.start();
    }
}
