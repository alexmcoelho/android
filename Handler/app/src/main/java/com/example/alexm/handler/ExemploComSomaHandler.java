package com.example.alexm.handler;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ExemploComSomaHandler extends ExemploBaseSoma {
    protected static final int SOMAR = 1;
    private int soma;

    protected void somar(final int n1, final int n2) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                soma = n1 + n2;
                TextView t = (TextView) findViewById(R.id.labelSoma);
                t.setText(String.valueOf("Soma: "+soma));
            }
        });
    }
}
