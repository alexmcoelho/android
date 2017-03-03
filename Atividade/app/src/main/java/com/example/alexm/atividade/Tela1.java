package com.example.alexm.atividade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Tela1 extends AppCompatActivity {

    Pessoa p = new Pessoa();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);
        //Passa parametro
        Button passaParam = (Button) findViewById(R.id.btEnviar);
        passaParam.setOnClickListener(passarParametro());
    }

    private View.OnClickListener passarParametro() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p = new Pessoa();
                Bundle bundle = new Bundle();

                EditText etName = (EditText)findViewById(R.id.editName);
                EditText etCpf = (EditText)findViewById(R.id.editCpf);
                EditText etEndereco = (EditText)findViewById(R.id.editEndereco);

                p.setNome(etName.getText().toString());
                p.setCfp(etCpf.getText().toString());
                p.setEndereco(etEndereco.getText().toString());

                bundle.putSerializable("p", p);
                Intent it = new Intent(getApplicationContext(),
                        Tela2.class);
                it.putExtras(bundle);
                startActivity(it);
            }
        };
    }
}
