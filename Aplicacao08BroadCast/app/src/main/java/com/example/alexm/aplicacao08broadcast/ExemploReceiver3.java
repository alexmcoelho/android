package com.example.alexm.aplicacao08broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ExemploReceiver3 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent it = new Intent(context, TelaTeste.class);
        it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(it);
    }
}

