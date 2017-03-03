package com.example.alexm.aplicativo6;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Tela1 extends ListActivity {

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        String[] itens = new String[] {"Tela 2", "Cadastro", "Sair"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itens);

        setListAdapter(adaptador);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        switch (position){
            case 0:
                Intent it = new Intent(getApplicationContext(), Tela2.class);
                startActivity(it);
                break;
            case 1:
                Intent its = new Intent(getApplicationContext(), TelaCadastro.class);
                startActivity(its);
                break;
            case 2:
                finish();
                break;
        }
    }
}
