package com.example.alexm.aplicacao5;

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
        //Passa parametro
        Button passaParam = (Button) findViewById(R.id.button);
        passaParam.setOnClickListener(passarParametro());
    }

    private View.OnClickListener passarParametro() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                EditText etName = (EditText)findViewById(R.id.editText);
                String nome = etName.getText().toString();
                bundle.putString("Nome", nome);
                Intent it = new Intent(getApplicationContext(),
                        Tela2.class);
                it.putExtras(bundle);
                startActivity(it);
            }
        };
    }
}
