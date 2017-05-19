package com.example.alexm.trabalhandocomlayout;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MenuBasicoLayouts extends ListActivity {

    @Override
    public void setListAdapter(ListAdapter adapter) {
        super.setListAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        String[] items = new String[]{"wrap_content","fill_parent","wrap_content_img",
                "fill_parent_img_wrap_content","fill_parent_img_fill_parent"};
        this.setListAdapter(new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1,items));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        switch (position){
            case 0:
                startActivity(R.layout.frame_layout_wrap_content);
                break;
            case 1:
                startActivity(R.layout.frame_layout_fill_parent);
                break;
            case 2:
                startActivity(R.layout.frame_layout_wrap_content_img);
                break;
            case 3:
                startActivity(R.layout.frame_layout_fill_parent_img_wrap);
                break;
            case 4:
                startActivity(R.layout.frame_layout_fill_parent_img_fill);
                break;
        }
    }

    private void startActivity(int layouts){
        Intent intent = new Intent(this, ActivityLayoutIdGenerica.class);
        intent.putExtra("layoutResId", layouts);
        startActivity(intent);
    }
}
