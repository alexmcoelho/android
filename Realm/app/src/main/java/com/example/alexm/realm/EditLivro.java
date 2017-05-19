package com.example.alexm.realm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;

public class EditLivro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_livro);

        final Realm realm = Realm.getDefaultInstance();

        Intent intent = getIntent();
        final int id = intent.getIntExtra("ID", 0); //caso nao tiver nada no id coloca zero
        final Livro livro = realm.where(Livro.class).equalTo("id", id).findFirst();//e faz a consulta no banco

        final EditText nome = (EditText) findViewById(R.id.edtLivro);
        final EditText autor = (EditText) findViewById(R.id.edtAutor);
        final EditText ano = (EditText) findViewById(R.id.edtAno);
        nome.setText(livro.getNome());
        autor.setText(livro.getAutor());
        ano.setText(String.valueOf(livro.getAno()));

        Button alterar = (Button) findViewById(R.id.btAlterar);
        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.beginTransaction();
                livro.setNome(nome.getText().toString());
                livro.setAutor(autor.getText().toString());
                livro.setAno(Integer.parseInt(ano.getText().toString()));
                realm.copyToRealm(livro);
                realm.commitTransaction();
                realm.close();

                Toast.makeText(getApplicationContext(), "Alteração realizada com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });

        Button remover = (Button) findViewById(R.id.btRemover);
        remover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.beginTransaction();
                livro.deleteFromRealm();
                realm.copyToRealm(livro);
                realm.commitTransaction();
                realm.close();

                Toast.makeText(getApplicationContext(), "Exclusão realizada com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
