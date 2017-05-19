package com.example.alexm.alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Calendar;

public class ExemploAgendaAlarmeRepetir extends AppCompatActivity {

    private static final String CATEGORIA = "livro";
    private static final int segundos = 5;

    //devido a a versão, executa a cada 1 min para economizar recursos o android faz isso
    private static final int tempoRepetir = 10 * 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView text = new TextView(this);
        text.setText("Alarme agendado para daqui a " + segundos + " segundos.\nE repetir a cada 10 segundos.");
        //setContentView(R.layout.activity_exemplo_agenda_alarme_repetir);
        setContentView(text);
        agendar(segundos);
    }

    private void agendar(int segundos){
        Intent it = new Intent("EXECUTAR_ALARME");
        PendingIntent p = PendingIntent.getBroadcast(ExemploAgendaAlarmeRepetir.this, 0, it, 0);
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        c.add(Calendar.SECOND, segundos);
        AlarmManager alarme = (AlarmManager) getSystemService(ALARM_SERVICE);
        long time = c.getTimeInMillis();
        alarme.setRepeating(AlarmManager.RTC_WAKEUP, time, tempoRepetir, p);
        Log.i(CATEGORIA, "Alarme agendado para daqui a " + segundos + " segundos. Repetir a cada " + tempoRepetir);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(CATEGORIA, "onDestry() - alarme cancelado.");
        Intent it = new Intent("EXECUTAR_ALARME");
        PendingIntent p = PendingIntent.getBroadcast(ExemploAgendaAlarmeRepetir.this, 0 ,it, 0);
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        am.cancel(p);
    }
}
