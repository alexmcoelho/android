package com.example.alexm.alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Calendar;

public class ExemploAgendarAlarme extends AppCompatActivity {
    private static final String CATEGORIA = "livro";
    private static final int segundos = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView text = new TextView(this);
        text.setText("Alarme agendado para daqui a " + segundos + " segundos");
        setContentView(text);
        agendar(segundos);
    }

    private void agendar(int segundos){
        Intent it = new Intent("EXECUTAR_ALARME");
        PendingIntent p = PendingIntent.getBroadcast(ExemploAgendarAlarme.this, 0, it, 0);
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        c.add(Calendar.SECOND, segundos);
        AlarmManager alarme = (AlarmManager) getSystemService(ALARM_SERVICE);
        long time = c.getTimeInMillis();
        alarme.set(AlarmManager.RTC_WAKEUP, time, p);
        Log.i(CATEGORIA, "Alarme agendado para daqui a " + segundos + " segundos");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(CATEGORIA, "onDestroy() - alarme cancelado.");
        Intent it = new Intent("EXECUTAR_ALARME");
        PendingIntent p = PendingIntent.getBroadcast(ExemploAgendarAlarme.this, 0, it, 0);
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        am.cancel(p);
    }
}
