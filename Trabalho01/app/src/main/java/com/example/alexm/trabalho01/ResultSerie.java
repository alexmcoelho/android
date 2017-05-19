package com.example.alexm.trabalho01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class ResultSerie extends AppCompatActivity {

    RadioButton rbPrimeiroSerie;
    RadioButton rbSegundaSerie;
    RadioButton rbTerceiraSerie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_serie);
        Button passaParam = (Button) findViewById(R.id.btContinuar);
        passaParam.setOnClickListener(passarParametro());

        rbPrimeiroSerie = (RadioButton) findViewById(R.id.rbPrimeiraSerie);
        rbSegundaSerie = (RadioButton) findViewById(R.id.rbSegundaSerie);
        rbTerceiraSerie = (RadioButton) findViewById(R.id.rbTerceiraSerie);

        passaParam.setOnClickListener(passarParametro());
        rbPrimeiroSerie.setOnClickListener(radioButtonPri());
        rbSegundaSerie.setOnClickListener(radioButtonSeg());
        rbTerceiraSerie.setOnClickListener(radioButtonSTer());

    }

    private View.OnClickListener radioButtonSTer() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rbTerceiraSerie.isChecked()){
                    rbPrimeiroSerie.setChecked(false);
                    rbSegundaSerie.setChecked(false);
                }
            }
        };
    }

    private View.OnClickListener radioButtonSeg() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rbSegundaSerie.isChecked()){
                    rbPrimeiroSerie.setChecked(false);
                    rbTerceiraSerie.setChecked(false);
                }
            }
        };
    }

    private View.OnClickListener radioButtonPri() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rbPrimeiroSerie.isChecked()){
                    rbSegundaSerie.setChecked(false);
                    rbTerceiraSerie.setChecked(false);
                }
            }
        };
    }

    private View.OnClickListener passarParametro() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();

                final RadioButton rbPrimeiraSerie = (RadioButton) findViewById(R.id.rbPrimeiraSerie);
                final RadioButton rbSegundaSerie = (RadioButton) findViewById(R.id.rbSegundaSerie);
                final RadioButton rbTerceiraSerie = (RadioButton) findViewById(R.id.rbTerceiraSerie);

                String serie = "";
                if (rbPrimeiraSerie.isChecked()) {
                    serie ="1º Série";
                }
                if (rbSegundaSerie.isChecked()) {
                    serie = "2º Série";
                }
                if (rbTerceiraSerie.isChecked()) {
                    serie = "3º Série";
                }

                if(!rbPrimeiraSerie.isChecked() && !rbSegundaSerie.isChecked() && !rbTerceiraSerie.isChecked()){
                    Toast.makeText(getApplicationContext(), "Série não informada!", Toast.LENGTH_SHORT).show();
                }else {

                    Intent it = getIntent();
                    Aluno aluno = it.getParcelableExtra("aluno");

                /*String nome = backBundle.getString("nome").toString();
                String matricula = backBundle.getString("matricula").toString();
                String sexo = backBundle.getString("sexo").toString();
                int idade = Integer.parseInt(backBundle.getString("idade").toString());
                String endereco = backBundle.getString("endereco").toString();*/

                    String nome = aluno.getNome();
                    String matricula = aluno.getMatricula();
                    String sexo = aluno.getSexo();
                    String idade = "" + aluno.getIdade();
                    String endereco = aluno.getEndereco();

                    bundle.putString("nome", nome);
                    bundle.putString("matricula", matricula);
                    bundle.putString("sexo", sexo);
                    bundle.putString("idade", idade);
                    bundle.putString("endereco", endereco);
                    bundle.putString("serie", serie);

                    it = new Intent("ACAO");
                    it.putExtras(bundle);
                    it.addCategory("ALUNO");
                    startActivity(it);
                }
            }
        };
    }
}
