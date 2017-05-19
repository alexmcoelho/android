package com.example.alexm.aplicacao08broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ExemploBoot extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Abrindo após o boot do sistema", Toast.LENGTH_SHORT).show();
        Intent it = new Intent(context, Tela1.class);
        it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(it);
    }
}