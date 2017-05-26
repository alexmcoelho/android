package com.example.alexm.sqllite;

import android.content.Intent;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.alexm.sqllite.data.model.Carro;

public class EditarCarro extends AppCompatActivity {

    private EditText campoNome;
    private EditText campoPlaca;
    private EditText campoAno;
    private Long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_carro);
        campoNome = (EditText) findViewById(R.id.idNomes);
        campoPlaca = (EditText) findViewById(R.id.idPlacas);
        campoAno = (EditText) findViewById(R.id.idAnos);
        id = null;
        Bundle extras = getIntent().getExtras();
        Button btSalvar = (Button) findViewById(R.id.btSalvar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });
    }

    public void salvar(){
        int ano = 0;
        try {
            ano = Integer.parseInt(campoAno.getText().toString());
        }catch (NumberFormatException e){

        }
        Carro carro = new Carro();
        if(id != null){
            carro.setId(id);
        }
        carro.setNome(campoNome.getText().toString());
        carro.setPlaca(campoPlaca.getText().toString());
        carro.setAno(ano);
        salvarCarro(carro);
        setResult(RESULT_OK, new Intent());
        finish();
    }

    private void salvarCarro(Carro carro) {
        MainActivity.repositorio.salvar(carro);
    }
}
