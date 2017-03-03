package com.example.alexm.atividadeusandoparselable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Tela1 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);
        Button passaParam = (Button) findViewById(R.id.btEnviar);
        passaParam.setOnClickListener(passarParametro());
    }

    private View.OnClickListener passarParametro() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();

                EditText etName = (EditText)findViewById(R.id.txtNome);
                EditText etPlaca = (EditText)findViewById(R.id.txtPlaca);

                String nome = etName.getText().toString();
                int placa = Integer.parseInt(etPlaca.getText().toString());

                Carro carro = new Carro(nome,placa);

                bundle.putParcelable("carro", carro);
                Intent it = new Intent(getApplicationContext(),
                        Tela2.class);
                it.putExtras(bundle);
                startActivity(it);
            }
        };
    }
}
