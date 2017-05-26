package com.example.alexm.sqllite;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.alexm.sqllite.data.model.Carro;
import com.example.alexm.sqllite.data.repo.RepositorioCarro;

import java.util.List;

public class MainActivity extends ListActivity {
    protected static final int INSERIR_EDITAR = 1;
    public static RepositorioCarro repositorio = new RepositorioCarro();
    public List<Carro> carros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btCriar = (Button) findViewById(R.id.button);
        btCriar.setOnClickListener(criarNovo());
        atualizar();
    }

    private View.OnClickListener criarNovo() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                novoRegistro();
            }
        };
    }

    public void atualizar(){
        //Pega a lista de carros e exibe na tela
        carros = repositorio.listarCarros();
        setListAdapter(new CarroListAdapter(this, carros));
    }

    public void novoRegistro(){
        startActivityForResult(new Intent(this, EditarCarro.class), INSERIR_EDITAR);
    }


}
