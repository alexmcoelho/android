package com.example.alexm.trabalhandocomlayout;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Tela1 extends ListActivity {

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        String[] items = new String[] {"layout basico","layouts"};
        this.setListAdapter(new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1,items));
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        switch (position) {
            case 0:
                startActivity(new Intent(this,MenuBasicoLayouts.class));
                break;
            case 1:
                startActivity(new Intent(this,MenuLayouts.class));
                break;
        }

    }
}