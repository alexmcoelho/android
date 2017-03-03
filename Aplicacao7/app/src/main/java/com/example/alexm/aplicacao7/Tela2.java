package com.example.alexm.aplicacao7;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Tela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        Button btMaps = (Button) findViewById(R.id.btMaps);
        btMaps.setOnClickListener(openMaps());

        Button btFotos = (Button) findViewById(R.id.btFotos);
        btFotos.setOnClickListener(openFotos());

        Button btVideo = (Button) findViewById(R.id.btVideo);
        btVideo.setOnClickListener(openVideo());

        Button btSMS = (Button) findViewById(R.id.btSMS);
        btSMS.setOnClickListener(enviaMensamge());

        Button btTela3 = (Button) findViewById(R.id.btTela3);
        btTela3.setOnClickListener(abrirTela3());
        Button abrirTela2 = (Button) findViewById(R.id.btTela3);
        abrirTela2.setOnClickListener(tela2Method());
    }

    private View.OnClickListener tela2Method() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),
                        Tela3.class);
                startActivity(it);
            }
        };
    }

    private View.OnClickListener openMaps() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etAdreess = (EditText) findViewById(R.id.editEndereco);
                String geo_url = "geo:0,0?="+etAdreess.getText().toString();
                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse(geo_url));
                startActivity(it);
            }
        };
    }

    private View.OnClickListener openFotos() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fotosIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(fotosIntent);
            }
        };
    }

    private View.OnClickListener openVideo() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent videoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivity(videoIntent);
            }
        };
    }

    private View.OnClickListener enviaMensamge() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("sms:12345678");
                Intent it = new Intent(Intent.ACTION_SENDTO, uri);
                EditText etSMS = (EditText) findViewById(R.id.editSMs);
                it.putExtra("sms_body", etSMS.getText().toString());
                startActivity(it);
            }
        };
    }

    private View.OnClickListener abrirTela3() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };
    }
}
