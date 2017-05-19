package com.example.alexm.aplicacao08broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ExemploReceiver2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "ExemploReceiver2 Configurado na API", Toast.LENGTH_SHORT).show();
    }
}

