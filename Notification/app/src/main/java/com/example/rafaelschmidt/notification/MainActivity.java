package com.example.rafaelschmidt.notification;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int NOTIFICACAO_SIMPLES = 1;
    private static final int NOTIFICACAO_COMPLETA = 2;
    private static final int NOTIFICACAO_BIG = 3;
    EditText etMensagem;
    MyReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etMensagem = (EditText) findViewById(R.id.editText);
        mReceiver = new MyReceiver();
        registerReceiver(mReceiver, new IntentFilter(NotificationUtil.ACAO_DELETE));
        registerReceiver(mReceiver, new IntentFilter(NotificationUtil.ACAO_NOTIFICACAO));
        Button btSimples = (Button) findViewById(R.id.simples);
        btSimples.setOnClickListener(criarNotificacaoSimples());
        Button btCompleto = (Button) findViewById(R.id.completo);
        btCompleto.setOnClickListener(criarNotificacaoCompleto());
        Button btBig = (Button) findViewById(R.id.big);
        btBig.setOnClickListener(criarNotificacaoBig());
    }

    private View.OnClickListener criarNotificacaoSimples() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationUtil.criarNotificacaoSimples(MainActivity.this,etMensagem.getText().toString(),NOTIFICACAO_SIMPLES);
            }
        };
    }
    private View.OnClickListener criarNotificacaoCompleto() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationUtil.criarNotificacaoCompleto(MainActivity.this,etMensagem.getText().toString(),NOTIFICACAO_COMPLETA);
            }
        };
    }
    private View.OnClickListener criarNotificacaoBig() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationUtil.criarNotificacaoBig(MainActivity.this,NOTIFICACAO_BIG);
            }
        };
    }
        class  MyReceiver extends BroadcastReceiver {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(MainActivity.this, intent.getAction(), Toast.LENGTH_SHORT).show();
            }
        }
    }

