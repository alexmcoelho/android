package com.example.alexm.aplicacao4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //sim
        Button sim = (Button) findViewById(R.id.btSim);
        sim.setOnClickListener(clickSim());

        //nao
        Button nao = (Button) findViewById(R.id.btNao);
        nao.setText("Não");
        nao.setOnClickListener(clickNao());
    }

    private View.OnClickListener clickNao() {
        return new View.OnClickListener(){
            public void onClick(View view){
                //Cria a intent
                Intent it = new Intent();
                //Seta a mensagem no retorno
                it.putExtra("msg","Clicou em não!");
                //seta o status do resultado e a Intent
                setResult(2,it);
                //Fim desta Activivy
                finish();
            }
        };
    }

    private View.OnClickListener clickSim() {
        return new View.OnClickListener(){
            public void onClick(View view){
                //Cria a intent
                Intent it = new Intent();
                //Seta a mensagem no retorno
                it.putExtra("msg","Clicou em sim!");
                //seta o status do resultado e a Intent
                setResult(1,it);
                //Fim desta Activivy
                finish();
            }
        };
    }
}
