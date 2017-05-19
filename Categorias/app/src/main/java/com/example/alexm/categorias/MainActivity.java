package com.example.alexm.categorias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.btTela2);
        button.setOnClickListener(abrirTela2());

        Button button2 = (Button) findViewById(R.id.btTela3);
        button2.setOnClickListener(abrirTela3());
    }

    private View.OnClickListener abrirTela2() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent("ACAO_TESTE");
                it.addCategory("CATEGORIA_TESTE1");
                startActivity(it);
            }
        };
    }

    private View.OnClickListener abrirTela3() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent("ACAO_TESTE");
                it.addCategory("CATEGORIA_TESTE2");
                startActivity(it);
            }
        };

    }

}
