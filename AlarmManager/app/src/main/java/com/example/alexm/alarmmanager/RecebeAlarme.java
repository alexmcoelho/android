package com.example.alexm.alarmmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class RecebeAlarme extends BroadcastReceiver {
    private static final String CATEGORIA = "livro";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(CATEGORIA, "Alarme disparado!");
        //Podemos iniciar uma activity, serviço ou exibir uma notificação ao usuário aqui
        Toast.makeText(context, "Alarme disparado!", Toast.LENGTH_SHORT).show();
    }
}
