package com.example.alexm.realm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;

public class AddLivro extends AppCompatActivity {

    RealmList<Autor> listaAutores;
    List<String> listaSoNome;
    String guardaNome;
    public Autor autor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_livro);

        final Realm realm = Realm.getDefaultInstance();
        final Realm realm2 = Realm.getDefaultInstance();

        final EditText nome = (EditText) findViewById(R.id.edtLivro);
        final EditText autor = (EditText) findViewById(R.id.edtAutor);
        final EditText ano = (EditText) findViewById(R.id.edtAno);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);


        List<Autor> list = realm.where(Autor.class).findAll();

        listaSoNome = new ArrayList<String>();
        int cont = 0;
        do{
            listaSoNome.add(list.get(cont).getNome());
            cont++;
        }while (cont < list.size());

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listaSoNome);
        spinner.setAdapter(adapter);

        //Listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                guardaNome = listaSoNome.get(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Button adicionar = (Button) findViewById(R.id.btAdicionar);
        adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Livro livro = new Livro();
                int proximo = 1;
                if(realm.where(Livro.class).max("id") != null){
                    proximo = realm.where(Livro.class).max("id").intValue() + 1;
                }
                Autor autor2 = realm2.where(Autor.class).equalTo("nome", guardaNome).findFirst();
                listaAutores.add(autor2);

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
