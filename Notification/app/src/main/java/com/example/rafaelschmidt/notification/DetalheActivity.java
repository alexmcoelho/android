package com.example.rafaelschmidt.notification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalheActivity extends AppCompatActivity {
    public static final String EXTRA_TEXTO = "texto";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);
        String texto = getIntent().getStringExtra(EXTRA_TEXTO);
        TextView txt = (TextView)findViewById(R.id.txtDetalhe);
        txt.setText(texto);
    }
}
