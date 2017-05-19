package com.example.alexm.sugarorm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.alexm.sugarorm.modelos.Produto;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private EditText edtProduto, edtQuantidade;
    private Button btnADD, btnListar;
    ListView mListView;
    ArrayAdapter<Produto> adapter;
    Produto p =new Produto();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtProduto = (EditText) findViewById(R.id.edtDescricao);
        edtQuantidade = (EditText) findViewById(R.id.edtQuantidade);

        btnADD = (Button) findViewById(R.id.button);


        mListView = (ListView) findViewById(R.id.l1);


        Toast.makeText(getApplicationContext(), "" , Toast.LENGTH_LONG).show();

        btnADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p = new Produto(edtProduto.getText().toString(), Integer.parseInt(edtQuantidade.getText().toString()));
                p.save();
                Toast.makeText(getApplicationContext(), "" + p, Toast.LENGTH_LONG).show();

            }
        });
    }

    private View.OnClickListener listando() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Produto> list;
                list = Produto.listAll(Produto.class);
            }
        };
    }

    private View.OnClickListener add() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p = new Produto(edtProduto.getText().toString(), Integer.parseInt(edtQuantidade.getText().toString()));
                p.save();
                Toast.makeText(getApplicationContext(), "" + p, Toast.LENGTH_LONG).show();
            }
        };
    }

}
