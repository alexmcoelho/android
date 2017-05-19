package com.example.alexm.handler;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        String[] mStrings = new String[]{
                "Hello Handler",
                "SplashScreen - Mensagem What",
                "SplashScreen - Runnable",
                "Activity de Soma - Erro Thread",
                "Activity de Soma - Handler",
                "Sair"
        };
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrings));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        switch (position){
            case 0:
                startActivity(new Intent(this, ExemploHandler.class));
            case 1:
                startActivity(new Intent(this, TelasplashScreen.class));
            case 2:
                startActivity(new Intent(this, TelaSplashScreenRunnable.class));
            case 3:
                startActivity(new Intent(this, SomarThread.class));
            case 4:
                startActivity(new Intent(this, ExemploComSomaHandler.class));
        }
       // super.onListItemClick(l, v, position, id);
    }
}
