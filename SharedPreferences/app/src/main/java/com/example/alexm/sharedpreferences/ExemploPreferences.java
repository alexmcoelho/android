package com.example.alexm.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

public class ExemploPreferences extends AppCompatActivity implements OnClickListener {

    private static final String CATEGORIA = "aula";
    //nome da preferencia salva
    private static final String NOME = "aulaAndroid";
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo_preferences);
        pref = getSharedPreferences(NOME, 0);

        boolean marcado = pref.getBoolean("status", false);
        Log.i(CATEGORIA, "Status atual: " + marcado);
        CheckBox check = (CheckBox) findViewById(R.id.check);
        //Exibe o valor na tela
        check.setChecked(marcado);
        Button btSalvar = (Button) findViewById(R.id.btSalvar);
        btSalvar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //abre a preferencia para edicao
        SharedPreferences.Editor editor = pref.edit();
        CheckBox check = (CheckBox) findViewById(R.id.check);
        boolean isChecked = check.isChecked();
        //Atualiza o valor
        editor.putBoolean("status", isChecked);
        Log.i(CATEGORIA, "Status salvo para: " + isChecked);
        //Faz commit para salvar os dados
        editor.commit();
    }


}
