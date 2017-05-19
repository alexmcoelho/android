package com.example.alexm.trabalho01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class CadastroAluno extends AppCompatActivity {

    boolean confirma = false;
    Aluno aluno = new Aluno();
    Bundle bundle = new Bundle();
    Intent it = new Intent("ACAO");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_aluno);
        Button passaParam = (Button) findViewById(R.id.btEscolherSerie);
        Button confirmarCad = (Button) findViewById(R.id.btConfirmarCadAluno);
        RadioButton rbMasc = (RadioButton) findViewById(R.id.rbMasculino);
        RadioButton rbFem = (RadioButton) findViewById(R.id.rbFeminino);

        passaParam.setOnClickListener(passarParametro());
        rbMasc.setOnClickListener(radioButtonHomem());
        rbFem.setOnClickListener(radioButtonMulher());
        confirmarCad.setOnClickListener(confirmarCad());

        it = getIntent();
        confirma = false;

        if(it.getExtras() != null){
            bundle = it.getExtras();
            String nome = bundle.getString("nome").toString();
            EditText edName = (EditText)findViewById(R.id.edNome);
            edName.setText(nome);

            String matricula = bundle.getString("matricula").toString();
            EditText edMatricula = (EditText)findViewById(R.id.edMatricula);
            edMatricula.setText(matricula);

            String sexo = bundle.getString("sexo").toString();

            if(sexo.equals("Masculino")){
                rbMasc.setChecked(true);
                rbFem.setChecked(false);
            }else{
                rbFem.setChecked(true);
                rbMasc.setChecked(false);
            }

            String idade = bundle.getString("idade").toString();
            EditText edIdade = (EditText)findViewById(R.id.edIdade);
            edIdade.setText(idade);

            String endereco = bundle.getString("endereco").toString();
            EditText edEndereco = (EditText)findViewById(R.id.edEndereco);
            edEndereco.setText(endereco);

            String serie = bundle.getString("serie").toString();
            TextView txSerie = (TextView)findViewById(R.id.txS);
            txSerie.setText(serie);

            confirmarCad.setVisibility(View.VISIBLE);
            confirma = true;
        }else{
            confirmarCad.setVisibility(View.INVISIBLE);
        }

    }

    private View.OnClickListener confirmarCad() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(confirma == true){
                    Intent it2 = new Intent("ACAO");
                    it2.addCategory("INICIAL");
                    it2.putExtras(it.getExtras());
                    Toast.makeText(getApplicationContext(), "Aluno cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                    startActivity(it2);

                }else{
                    Toast.makeText(getApplicationContext(), "A série não foi escolhida!", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

    private View.OnClickListener radioButtonMulher() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final RadioButton rbMasc = (RadioButton) findViewById(R.id.rbMasculino);
                final RadioButton rbFem = (RadioButton) findViewById(R.id.rbFeminino);
                if(rbFem.isChecked()){
                    rbMasc.setChecked(false);
                }
            }
        };
    }

    private View.OnClickListener radioButtonHomem() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final RadioButton rbMasc = (RadioButton) findViewById(R.id.rbMasculino);
                final RadioButton rbFem = (RadioButton) findViewById(R.id.rbFeminino);
                if(rbMasc.isChecked()){
                    rbFem.setChecked(false);
                }
            }
        };
    }

    private View.OnClickListener passarParametro() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                it = new Intent("ACAO");

                    EditText etName = (EditText)findViewById(R.id.edNome);
                    EditText etMatricula = (EditText)findViewById(R.id.edMatricula);
                    final RadioButton rbMasc = (RadioButton) findViewById(R.id.rbMasculino);
                    final RadioButton rbFem = (RadioButton) findViewById(R.id.rbFeminino);
                    String sexo = "";
                    if (rbMasc.isChecked()) {
                        sexo ="Masculino";
                    }
                    if (rbFem.isChecked()) {
                        sexo = "Feminino";
                    }
                    EditText etIdade = (EditText)findViewById(R.id.edIdade);
                    EditText etEndereco = (EditText)findViewById(R.id.edEndereco);


                    String nome = etName.getText().toString();
                    String matricula = etMatricula.getText().toString();
                    int idade;
                    if(!etIdade.getText().toString().equals("")){
                        idade = Integer.parseInt(etIdade.getText().toString());
                    }else{
                        idade = 0;
                    }

                    String endereco = etEndereco.getText().toString();
                    String serie = "";

                    if(nome.equals("") || matricula.equals("") || idade == 0 || endereco.equals("")){
                        Toast.makeText(getApplicationContext(), "Antes de escolher a série, preencha todos os campos!", Toast.LENGTH_SHORT).show();
                    }else {

                        Aluno aluno = new Aluno(nome, matricula, sexo, idade, endereco, serie);
                        bundle.putParcelable("aluno", aluno);

                        it.addCategory("RESULTADO_SERIE");
                        it.putExtras(bundle);

                        startActivity(it);
                    }
            }
        };
    }


}
