package com.example.alexm.trabalho01;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TelaInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        Button passaParam = (Button) findViewById(R.id.btCadAluno);
        passaParam.setOnClickListener(abrirTelaAluno());

        Button lancarNotas = (Button) findViewById(R.id.btNotas);
        lancarNotas.setOnClickListener(abrirTelaNota());
    }

    private View.OnClickListener abrirTelaNota() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = getIntent();
                Bundle backBundle = new Bundle();

                if(it.getExtras() != null){
                    Intent it2 = new Intent("ACAO");
                    it2.addCategory("TRI_01");
                    it2.putExtras(it.getExtras());
                    backBundle = it2.getExtras();//o certo seria verificar se esta null
                    String nome = backBundle.getString("nome").toString();
                    Toast.makeText(getApplicationContext(), "Cadastrar notas do aluno " + nome, Toast.LENGTH_SHORT).show();
                    startActivity(it2);
                }else{
                    Toast.makeText(getApplicationContext(), "Não é possível lançar as notas, pois não existe nenhum Aluno(a) cadastrado!", Toast.LENGTH_SHORT).show();
                }

            }
        };
    }

    private View.OnClickListener abrirTelaAluno() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent("ACAO");
                it.addCategory("ALUNO");
                startActivity(it);
            }
        };
    }


}
