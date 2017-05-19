package com.example.alexm.projetorealm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;

public class EditProduto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_produto);

        final Realm realm = Realm.getDefaultInstance();

        Intent intent = getIntent();
        final int id = intent.getIntExtra("ID", 0); //caso nao tiver nada no id coloca zero
        final Produto produto = realm.where(Produto.class).equalTo("id", id).findFirst();//e faz a consulta no banco

        final EditText descricao = (EditText) findViewById(R.id.edtDescricao);
        final EditText quantidade = (EditText) findViewById(R.id.edtQuantidade);
        final EditText valor = (EditText) findViewById(R.id.edtValor);
        descricao.setText(produto.getDescricao());
        quantidade.setText(String.valueOf(produto.getQuantidade()));
        valor.setText(String.valueOf(produto.getValor()));

        Button alterar = (Button) findViewById(R.id.btAlterar);
        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.beginTransaction();
                produto.setDescricao(descricao.getText().toString());
                produto.setQuantidade(Integer.parseInt(quantidade.getText().toString()));
                produto.setValor(Double.parseDouble(valor.getText().toString()));
                realm.copyToRealm(produto);
                realm.commitTransaction();
                realm.close();

                Toast.makeText(getApplicationContext(), "Alteração realizada com sucesso!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(EditProduto.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button remover = (Button) findViewById(R.id.btRemover);
        remover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.beginTransaction();
                produto.deleteFromRealm();
                realm.copyToRealm(produto);
                realm.commitTransaction();
                realm.close();

                Toast.makeText(getApplicationContext(), "Exclusão realizada com sucesso!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(EditProduto.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
