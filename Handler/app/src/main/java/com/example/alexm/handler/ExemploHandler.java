package com.example.alexm.handler;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ExemploHandler extends Activity {
    protected static final int MENSAGEM_TESTE = 1;
    protected Handler handler = new TesteHandler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo_handler);
        Button b = (Button) findViewById(R.id.btEnviar);
        b.setText("Atualizar texto em 3 segundos");
        b.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Message msg = new Message();
                msg.what = MENSAGEM_TESTE;
                handler.sendMessageDelayed(msg, 3000);
            }
        });
    }

    private class TesteHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MENSAGEM_TESTE :
                    Toast.makeText(ExemploHandler.this, "A mensagem chegou", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}


