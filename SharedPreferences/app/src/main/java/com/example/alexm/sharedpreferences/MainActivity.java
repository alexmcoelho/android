package com.example.alexm.sharedpreferences;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    private static final String[] ops = new String[]{
        "Salvar no diretório restrito do aplicativo",
            "Salvar no sdcard",
            "Preferencias",
            "Sair"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layout = android.R.layout.simple_list_item_1;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, layout, ops);
        this.setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        switch (position){
            case 0:
                startActivity(new Intent(this, ExemploSalvarArquivo.class));
            case 1:
                startActivity(new Intent(this, ExemploSalvarArquivoSDCard.class));
            case 2:
                //startActivity(new Intent(this, TelaSplashScreenRunnable.class));
            case 3:
                finish();
        }
    }
}
