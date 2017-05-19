package com.example.alexm.handler;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class TelaSplashScreenRunnable extends Activity implements Runnable {

    private final int DELAY = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_splash_screen_runnable);
        Toast.makeText(this, "Aguarde o carregamento da aplicação...", Toast.LENGTH_SHORT).show();
        //SOLICITA para o Handler executar o Runnable (this), fechando Screen depois de alguns segundos
        Handler h = new Handler();
        h.postDelayed(this, DELAY);
    }

    @Override
    public void run() {
        //Abre o menu principal
        startActivity(new Intent(this, MainActivity.class));
        //Finaliza está activity
        finish();
    }
}
