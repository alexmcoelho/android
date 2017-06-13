package com.example.alexm.sqllite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        if(extras != null){
            id = extras.getLong(Carro.Carros._ID);
            if(id != null){
                Carro c = buscarCarro(id);
                campoNome.setText(c.getNome());
                campoPlaca.setText(c.getPlaca());
                campoAno.setText(String.valueOf(c.getAno()));
            }
        }
        Button btCancelar = (Button) findViewById(R.id.btCancelar);
        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
        Button btSalvar = (Button) findViewById(R.id.btSalvar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });
        Button btExcluir = (Button) findViewById(R.id.btExcluir);
        if(id == null){
            btExcluir.setVisibility(View.INVISIBLE);
        }else{
            btExcluir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    excluir();
                }
            });
        }

    }

    public void excluir(){
        if(id != null){
            excluirCarro(id);
        }
        setResult(RESULT_OK, new Intent());
        finish();
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

    private Carro buscarCarro(Long id) {
        return MainActivity.repositorio.buscarCarro(id);
    }

    public void salvarCarro(Carro carro) {
        MainActivity.repositorio.salvar(carro);
    }

    public void excluirCarro(long id){
        MainActivity.repositorio.deletar(id);
    }
}
