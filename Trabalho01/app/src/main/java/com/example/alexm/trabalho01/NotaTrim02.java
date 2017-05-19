package com.example.alexm.trabalho01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NotaTrim02 extends AppCompatActivity {

    EditText editNota01;
    EditText editNota02;
    EditText editNota03;

    EditText editPeso1;
    EditText editPeso2;
    EditText editPeso3;

    Intent it = new Intent("ACAO");
    Bundle backBundle = new Bundle();
    private Nota nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota_trim02);

        editNota01 = (EditText)findViewById(R.id.edNota1Tri02);
        editNota02 = (EditText)findViewById(R.id.edNota2Tri02);
        editNota03 = (EditText)findViewById(R.id.edNota3Tri02);

        editPeso1 = (EditText)findViewById(R.id.edPeso1Tri02);
        editPeso2 = (EditText)findViewById(R.id.edPeso2Tri02);
        editPeso3 = (EditText)findViewById(R.id.edPeso3Tri02);

        Button lancaNotaTri01 = (Button) findViewById(R.id.btContinuarTri02);

        lancaNotaTri01.setOnClickListener(lancaNotaTri());

        it = getIntent();
        backBundle = new Bundle();

        if(it.getExtras() != null){
            backBundle = it.getExtras();//o certo seria verificar se esta null
            String nome = backBundle.getString("nome").toString();
            TextView tvNome = (TextView)findViewById(R.id.txNomeAlunoTri02);
            tvNome.setText("Aluno: " + nome);
            String serie = backBundle.getString("serie").toString();
            TextView tvSerie = (TextView)findViewById(R.id.txSerieAlunoTri02);
            tvSerie.setText("Série: " + serie);
        }

    }

    private View.OnClickListener lancaNotaTri() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editNota01.getText().toString().equals("") && !editNota02.getText().toString().equals("") &&
                        !editNota03.getText().toString().equals("") && !editPeso1.getText().toString().equals("") &&
                        !editPeso2.getText().toString().equals("") && !editPeso3.getText().toString().equals("")){
                    Double nota1 = Double.parseDouble(editNota01.getText().toString());
                    Double nota2 = Double.parseDouble(editNota02.getText().toString());
                    Double nota3 = Double.parseDouble(editNota03.getText().toString());

                    Double peso01 = Double.parseDouble(editPeso1.getText().toString());
                    Double peso02 = Double.parseDouble(editPeso2.getText().toString());
                    Double peso03 = Double.parseDouble(editPeso3.getText().toString());
                    Double media = 0.0;
                    //validando a soma de pesos
                    Double somaPesos = peso01 + peso02 + peso03;
                    Boolean continuar = false;

                    if (somaPesos == 10){
                        media = nota1*(peso01/10) + nota2*(peso02/10) + nota3*(peso03/10);
                        continuar = true;
                    }else if(somaPesos == 30){
                        media = (nota1 + nota2 + nota3) / 3;
                        continuar = true;
                    }else{
                        continuar = false;
                    }

                    if(continuar == true){
                        Intent it2 = new Intent("ACAO");
                        it2.addCategory("TRI_03");
                        it2.putExtras(it.getExtras());//pega o que ja estava no bundle

                        //nota =  new Nota(nota1, peso01);
                        backBundle.putDouble("nota01Tri02", nota1);
                        backBundle.putDouble("peso01Tri02", peso01);
                        //nota = new Nota(nota2, peso02);
                        backBundle.putDouble("nota02Tri02", nota2);
                        backBundle.putDouble("peso02Tri02", peso02);
                        //nota = new Nota(nota3, peso03);
                        backBundle.putDouble("nota03Tri02", nota3);
                        backBundle.putDouble("peso03Tri02", peso03);

                        backBundle.putDouble("mediaTri02", media);

                        it2.putExtras(backBundle);

                        Toast.makeText(getApplicationContext(), "As notas foram lançadas com sucesso!", Toast.LENGTH_SHORT).show();
                        startActivity(it2);
                    }else{
                        Toast.makeText(getApplicationContext(), "A soma dos pesos têm que ser igual a 10, ou todos iguais a 10!", Toast.LENGTH_SHORT).show();
                    }


                }else{
                    Toast.makeText(getApplicationContext(), "Preencha todas notas!", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }
}
