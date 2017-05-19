package com.example.alexm.aplicacao08broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ExemploReceiverANR extends BroadcastReceiver {
    private static final String CATEGORIA = "aula";

    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            Log.i(CATEGORIA, "Teste ANR sleep ...");
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
