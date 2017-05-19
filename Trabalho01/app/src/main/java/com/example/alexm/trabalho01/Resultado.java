package com.example.alexm.trabalho01;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Resultado extends AppCompatActivity {

    Nota nota = new Nota();
    Bundle bundle = new Bundle();
    DecimalFormat df = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        Intent it = getIntent();

        bundle = it.getExtras();

        Button inicio = (Button) findViewById(R.id.btVoltarInicio);

        inicio.setOnClickListener(inicio());

        //dados alumno

        String nome = bundle.getString("nome").toString();
        TextView tvNome = (TextView)findViewById(R.id.txNomeResultado);
        tvNome.setText("Aluno: " + nome);
        String serie = bundle.getString("serie").toString();
        TextView tvSerie = (TextView)findViewById(R.id.txSerieResultado);
        tvSerie.setText("Série: " + serie);

        //primeiro tri

        Double nota01Tri01 = bundle.getDouble("nota01Tri01");
        TextView edNota01Tri01 = (TextView) findViewById(R.id.txNota01Tri01);
        edNota01Tri01.setText(""+nota01Tri01);

        Double peso01Tri01 = bundle.getDouble("peso01Tri01");
        TextView edPeso01Tri01 = (TextView) findViewById(R.id.txPeso01Tri01);
        edPeso01Tri01.setText(""+peso01Tri01);

        Double nota02Tri01 = bundle.getDouble("nota02Tri01");
        TextView edNota02Tri01 = (TextView) findViewById(R.id.txNota02Tri01);
        edNota02Tri01.setText(""+nota02Tri01);

        Double peso02Tri01 = bundle.getDouble("peso02Tri01");
        TextView edPeso02Tri01 = (TextView) findViewById(R.id.txPeso02Tri01);
        edPeso02Tri01.setText(""+peso02Tri01);

        Double nota03Tri01 = bundle.getDouble("nota03Tri01");
        TextView edNota03Tri01 = (TextView) findViewById(R.id.txNota03Tri01);
        edNota03Tri01.setText(""+nota03Tri01);

        Double peso03Tri01 = bundle.getDouble("peso03Tri01");
        TextView edPeso03Tri01 = (TextView) findViewById(R.id.txPeso03Tri01);
        edPeso03Tri01.setText(""+peso03Tri01);

        Double mediaTri01 = bundle.getDouble("mediaTri01");
        TextView edMediaTri01 = (TextView) findViewById(R.id.txMediaTri01);
        edMediaTri01.setText(""+df.format(mediaTri01));

        if(mediaTri01 < 7){
            edMediaTri01.setTextColor(Color.RED);
        }else{
            edMediaTri01.setTextColor(Color.BLACK);
        }

        //segundo tri

        Double nota01Tri02 = bundle.getDouble("nota01Tri02");
        TextView edNota01Tri02 = (TextView) findViewById(R.id.txNota01Tri02);
        edNota01Tri02.setText(""+nota01Tri02);

        Double peso01Tri02 = bundle.getDouble("peso01Tri02");
        TextView edPeso01Tri02 = (TextView) findViewById(R.id.txPeso01Tri02);
        edPeso01Tri02.setText(""+peso01Tri02);

        Double nota02Tri02 = bundle.getDouble("nota02Tri02");
        TextView edNota02Tri02 = (TextView) findViewById(R.id.txNota02Tri02);
        edNota02Tri02.setText(""+nota02Tri02);

        Double peso02Tri02 = bundle.getDouble("peso02Tri02");
        TextView edPeso02Tri02 = (TextView) findViewById(R.id.txPeso02Tri02);
        edPeso02Tri02.setText(""+peso02Tri02);

        Double nota03Tri02 = bundle.getDouble("nota03Tri02");
        TextView edNota03Tri02 = (TextView) findViewById(R.id.txNota03Tri02);
        edNota03Tri02.setText(""+nota03Tri02);

        Double peso03Tri02 = bundle.getDouble("peso03Tri02");
        TextView edPeso03Tri02 = (TextView) findViewById(R.id.txPeso03Tri02);
        edPeso03Tri02.setText(""+peso03Tri02);

        Double mediaTri02 = bundle.getDouble("mediaTri02");
        TextView edMediaTri02 = (TextView) findViewById(R.id.txMediaTri02);
        edMediaTri02.setText(""+df.format(mediaTri02));

        if(mediaTri02 < 7){
            edMediaTri02.setTextColor(Color.RED);
        }else{
            edMediaTri02.setTextColor(Color.BLACK);
        }

        //terceiro tri

        Double nota01Tri03 = bundle.getDouble("nota01Tri03");
        TextView edNota01Tri03 = (TextView) findViewById(R.id.txNota01Tri03);
        edNota01Tri03.setText(""+nota01Tri03);

        Double peso01Tri03 = bundle.getDouble("peso01Tri03");
        TextView edPeso01Tri03 = (TextView) findViewById(R.id.txPeso01Tri03);
        edPeso01Tri03.setText(""+peso01Tri03);

        Double nota02Tri03 = bundle.getDouble("nota02Tri03");
        TextView edNota02Tri03 = (TextView) findViewById(R.id.txNota02Tri03);
        edNota02Tri03.setText(""+nota02Tri03);

        Double peso02Tri03 = bundle.getDouble("peso02Tri03");
        TextView edPeso02Tri03 = (TextView) findViewById(R.id.txPeso02Tri03);
        edPeso02Tri03.setText(""+peso02Tri03);

        Double nota03Tri03 = bundle.getDouble("nota03Tri03");
        TextView edNota03Tri03 = (TextView) findViewById(R.id.txNota03Tri03);
        edNota03Tri03.setText(""+nota03Tri03);

        Double peso03Tri03 = bundle.getDouble("peso03Tri03");
        TextView edPeso03Tri03 = (TextView) findViewById(R.id.txPeso03Tri03);
        edPeso03Tri03.setText(""+peso03Tri03);

        Double mediaTri03 = bundle.getDouble("mediaTri03");
        TextView edMediaTri03 = (TextView) findViewById(R.id.txMediaTri03);
        edMediaTri03.setText(""+df.format(mediaTri03));

        if(mediaTri03 < 7){
            edMediaTri03.setTextColor(Color.RED);
        }else{
            edMediaTri03.setTextColor(Color.BLACK);
        }

        Double mediaGeral =  (mediaTri01 + mediaTri02 + mediaTri03) / 3;
        TextView edMediaGeral = (TextView) findViewById(R.id.txMediaGeral);
        edMediaGeral.setText("Média: "+ df.format(mediaGeral));

        TextView edSituacao = (TextView) findViewById(R.id.txSituacao);

        if(mediaGeral < 7){
            edMediaGeral.setTextColor(Color.RED);
            edSituacao.setText("REPROVADO!");
        }else{
            edMediaGeral.setTextColor(Color.BLACK);
            edSituacao.setText("APROVADO!");
        }

    }

    private View.OnClickListener inicio() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent("ACAO");
                it.addCategory("INICIAL");
                startActivity(it);
            }
        };
    }
}
