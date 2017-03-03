package com.example.alexm.aplicacao4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(),
                        Main2Activity.class), 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int codigo, int resultado, Intent it) {
        if (codigo == 1) {
            Bundle params = it != null ? it.getExtras() : null;
            String msg = params.getString("msg");
            if (resultado == 1) {
                Toast.makeText(this, "Escolheu Sim: "
                        + msg, Toast.LENGTH_SHORT).show();
            } else if (resultado == 2) {
                Toast.makeText(this, "Escolheu Não: "
                        + msg, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Nâo Definido: "
                        + msg, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
