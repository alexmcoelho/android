package com.example.alexm.aplicacao08broadcast;

import android.app.ListActivity;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Tela1 extends ListActivity {
    private static final String[] nomes = new String[]{
            "Exemplo 1",
            "Exemplo 2",
            "Exemplo 3 Erro ANR",
            "Exemplo 4 Iniciar no boot a aplicação",
            "Sair",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomes));
        // Registra um BroadcastReceiver pela API
        registerReceiver(new ExemploReceiver2(), new IntentFilter("ABRIR_RECEIVER_2"));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int posisition, long id) {
        switch (posisition) {
            case 0:
                sendBroadcast(new Intent("ABRIR_RECEIVE_1"));
                break;
            case 1:
                sendBroadcast(new Intent("ABRIR_RECEIVER_2"));
                break;
            case 2:
                sendBroadcast(new Intent("TESTE_ANR"));
                break;
            case 3:
                sendBroadcast(new Intent("ABRIR_TELA_TESTE"));
                break;
            default:
                finish();
                break;
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        // Remove o BroadcastReceiver
        unregisterReceiver(new ExemploReceiver2());
    }
}
