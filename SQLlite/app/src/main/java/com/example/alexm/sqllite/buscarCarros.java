package com.example.alexm.sqllite;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alexm.sqllite.data.model.Carro;

public class buscarCarros extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_carros);
        Button btBuscar = (Button) findViewById(R.id.btBuscar);
        btBuscar.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        setResult(RESULT_CANCELED);
        finish();
    }

    @Override
    public void onClick(View v) {
        EditText nome = (EditText) findViewById(R.id.idNomes);
        EditText placa = (EditText) findViewById(R.id.idPlacas);
        EditText ano = (EditText) findViewById(R.id.idAnos);
        String nomeCarro = nome.getText().toString();
        Carro carro = buscarCarro(nomeCarro);
        if(carro != null){
            placa.setText(carro.getPlaca());
            ano.setText(String.valueOf(carro.getAno()));
        }else {
            placa.setText("");
            ano.setText("");
            Toast.makeText(buscarCarros.this, "Nenhuma carro encontrado", Toast.LENGTH_SHORT).show();
        }
    }

    //buscar carro pelo nome
    private Carro buscarCarro(String nomeCarro) {
        Carro carro = MainActivity.repositorio.buscarCarroPorNome(nomeCarro);
        return carro;
    }
}
