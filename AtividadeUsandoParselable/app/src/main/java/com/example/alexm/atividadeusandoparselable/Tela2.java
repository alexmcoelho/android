package com.example.alexm.atividadeusandoparselable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Tela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        Intent it = getIntent();
        Carro carro = it.getParcelableExtra("carro");
        Toast.makeText(getApplicationContext(),carro.getNome()
                .concat(" ")
                .concat(Integer.toString(carro.getPlaca()))
                ,Toast.LENGTH_SHORT).show();
    }
}
