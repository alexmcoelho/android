package com.example.alexm.handler;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class TelasplashScreen extends AppCompatActivity {
    private static final int FECHAR_SPLASH = 1;
    private final int DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telasplash_screen);

        Message msg = new Message();
        msg.what = FECHAR_SPLASH;
        handler.sendMessageDelayed(msg, DELAY);
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case FECHAR_SPLASH:
                    startActivity(new Intent(TelasplashScreen.this, MainActivity.class));
                    Toast.makeText(TelasplashScreen.this, "Fim Splash", Toast.LENGTH_SHORT).show();
                    finish();
                    default:
                        break;
            }
        }
    };
}
