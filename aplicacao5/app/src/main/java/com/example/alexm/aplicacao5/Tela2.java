package com.example.alexm.aplicacao5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Tela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        Intent it = getIntent();
        Bundle backBundle = it.getExtras();//o certo seria verificar se esta null
        String nome = backBundle.getString("Nome").toString();
        TextView tvNome = (TextView)findViewById(R.id.msg);
        tvNome.setText(nome);
    }
}
