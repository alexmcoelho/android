package com.example.alexm.projetorealm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;

public class AddProduto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_produto);

        final Realm realm = Realm.getDefaultInstance();


        final EditText descricao = (EditText) findViewById(R.id.edtDescricao);
        final EditText quantidade = (EditText) findViewById(R.id.edtQuantidade);
        final EditText valor = (EditText) findViewById(R.id.edtValor);
        Button adicionar = (Button) findViewById(R.id.btAdicionar);
        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Produto livro = new Produto();
                int proximo = 1;
                if(realm.where(Produto.class).max("id") != null){
                    proximo = realm.where(Produto.class).max("id").intValue() + 1;
                }
                livro.setId(proximo);
                livro.setDescricao(descricao.getText().toString());
                livro.setQuantidade(Integer.parseInt(quantidade.getText().toString()));
                livro.setValor(Double.parseDouble(valor.getText().toString()));

                realm.beginTransaction();
                realm.copyToRealm(livro);
                realm.commitTransaction();
                realm.close();

                Toast.makeText(getApplicationContext(), "Gravação realizada com sucesso!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AddProduto.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
