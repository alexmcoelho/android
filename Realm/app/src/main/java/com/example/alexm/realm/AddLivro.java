package com.example.alexm.realm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import io.realm.Realm;

public class AddLivro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_livro);

        final Realm realm = Realm.getDefaultInstance();


        final EditText nome = (EditText) findViewById(R.id.edtLivro);
        final EditText autor = (EditText) findViewById(R.id.edtAutor);
        final EditText ano = (EditText) findViewById(R.id.edtAno);
        Button adicionar = (Button) findViewById(R.id.btAdicionar);
        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Livro livro = new Livro();
                int proximo = 1;
                if(realm.where(Livro.class).max("id") != null){
                    proximo = realm.where(Livro.class).max("id").intValue() + 1;
                }
                livro.setId(proximo);
                livro.setNome(nome.getText().toString());
                livro.setAutor(autor.getText().toString());
                livro.setAno(Integer.parseInt(ano.getText().toString()));

                realm.beginTransaction();
                realm.copyToRealm(livro);
                realm.commitTransaction();
                realm.close();

                Toast.makeText(getApplicationContext(), "Gravação realizada com sucesso!", Toast.LENGTH_SHORT).show();


            }
        });

    }
}
