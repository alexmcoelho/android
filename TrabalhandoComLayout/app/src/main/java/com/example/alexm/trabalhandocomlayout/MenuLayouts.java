package com.example.alexm.trabalhandocomlayout;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuLayouts extends ListActivity {

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        String[ ] items = new String[]{
                "FrameLayout background", "LinearLayout horizontal",
                "LinearLayout vertical",
                "LinearLayout gravity", "LinearLayout weight",
                "TableLayout shrink", "TableLayout stretch,",
                "TableLayout Form", "RelativeLayout Form",
                "AbsoluteLayout Form",
                "LinearLayout aninhado",
                "ScrollView",
                "LinearLayout API",
                "TableLayout API"};
        this.setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, items));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        switch (position){
            case 0:
                startActivity(R.layout.frame_layout_background);
                break;
            case 1:
                startActivity(R.layout.linear_layout_horizontal);
                break;
            case 2:
                startActivity(R.layout.linear_layout_vertical);
                break;
            case 3:
                startActivity(R.layout.linear_layout_gravity);
                break;
            case 4:
                startActivity(R.layout.linear_layout_weight_text_2);
                break;
            case 5:
                startActivity(R.layout.table_layout_shrink);
                break;
            case 6:
                startActivity(R.layout.table_layout_stretch);
                break;
            case 7:
                startActivity(R.layout.table_layout_form);
                break;
            case 8:
                startActivity(R.layout.relative_layout_form);
                break;
            case 9:
                startActivity(R.layout.absolute_layout_form);
                break;
            case 10:
                startActivity(R.layout.linear_layout_form_aninhado);
                break;
            case 11:
                startActivity(new Intent(this,Exemplo_scrollView.class));
                break;
            case 12:
                startActivity(new Intent(this,ExemploLinearLayoutAPI.class));
                break;
            case 13:
                startActivity(new Intent(this,ExemploTableLayoutAPI.class));
                break;
        }

    }

    private void startActivity(int layoutId){
        Intent intent = new Intent(this,ActivityLayoutIdGenerica.class);
        intent.putExtra("layoutResId",layoutId);
        startActivity(intent);
    }
}