package com.example.alexm.aplicacao7;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Tela1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);
        Button btCall = (Button) findViewById(R.id.btLigar);
        btCall.setOnClickListener(callMethod());

        Button browser = (Button) findViewById(R.id.btInternet);
        browser.setOnClickListener(browserMethod());

        Button abrirTela2 = (Button) findViewById(R.id.btTela2);
        abrirTela2.setOnClickListener(tela2Method());
    }

    private View.OnClickListener tela2Method() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(),
                        Tela2.class);
                startActivity(it);
            }
        };
    }

    private View.OnClickListener browserMethod() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edLink = (EditText) findViewById(R.id.editInternet);
                Uri uri = Uri.parse("https://"+edLink.getText().toString());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                //chegando permissao
       /* int permissionCheck =
                ContextCompat.checkSelfPermission(
                        getApplicationContext(),
                        Manifest.permission.INTERNET);
        if(permissionCheck != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                    new String[] {Manifest.permission.INTERNET}, 2);
        }else{*/
                startActivity(intent);
            }
        };
    }

    public void internet(){

        //}
    }

    private View.OnClickListener callMethod() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamar();
            }
        };
    }

    public void chamar(){
        EditText edPhone = (EditText) findViewById(R.id.editFone);
        Uri uri = Uri.parse("tel:"+edPhone.getText().toString());
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        //chegando permissao
        int permissionCheck =
                ContextCompat.checkSelfPermission(
                        getApplicationContext(),
                        Manifest.permission.CALL_PHONE);
        if(permissionCheck != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                    new String[] {Manifest.permission.CALL_PHONE}, 1);
        }else{
            startActivity(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1:
                if((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)){
                    chamar();
                }else{
                    Toast.makeText(getApplicationContext(),
                            "Sem permissão",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case 2:
                if((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)){
                    internet();
                }else{
                    Toast.makeText(getApplicationContext(),
                            "Sem permissão",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }
}
