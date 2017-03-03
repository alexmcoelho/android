package com.example.alexm.aplicacao7;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Tela3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);

        Button btContatos = (Button) findViewById(R.id.btContatos);
        btContatos.setOnClickListener(openContatos());
    }

    private View.OnClickListener openContatos() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("content://com.android.contacts/contacts");
                Intent it = new Intent(Intent.ACTION_PICK, uri);
                startActivityForResult(it, 1);
            }
        };
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == Activity.RESULT_OK){
            Uri uri = data.getData();
            Toast.makeText(getApplicationContext(), uri.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
