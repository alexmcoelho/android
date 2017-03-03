package com.example.alexm.atividade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Tela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        Intent it = getIntent();
        Bundle backBundle = it.getExtras();//o certo seria verificar se esta null
        //Bundle backBundle = getIntent().getBundleExtra("bundle_tela1"); mas se usar isso na Tela1 teria que usar it.putExtra("bundle_tela1", bundle); ao invez de it.putExtras(bundle);

        if(backBundle != null) {//verificando se esta null

            Pessoa p = (Pessoa) backBundle.getSerializable("p");
            String nome = p.getNome();
            String cpf = p.getCfp();
            String endereco = p.getEndereco();

            //Amarrando com os textView
            TextView tvNome = (TextView) findViewById(R.id.txtNome);
            TextView tvCpf = (TextView) findViewById(R.id.txtCpf);
            TextView tvEndereco = (TextView) findViewById(R.id.txtEndereco);

            //Passando para os textView o conteudo
            tvNome.setText(nome);
            tvCpf.setText(cpf);
            tvEndereco.setText(endereco);
        }
    }
}
