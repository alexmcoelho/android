package com.example.alexm.projetostarservice;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.WorkerThread;
import android.util.Log;

public class HelloService extends Service {
    private static final int MAX = 10;
    private static final String TAG = "aula";
    protected int count;
    private boolean running;
    @Override
    public IBinder onBind(Intent intent) {return null;}

    @Override
    public void onCreate() {
        Log.d(TAG,"HelloService.onCreate() - Service criado");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"HelloService.onCreate() - Service iniciado: "+startId);
        count=0;
        running=true;
        new WorkerThread().start();
        return super.onStartCommand(intent, flags, startId);
    }
    class WorkerThread extends Thread{
        public void run(){
            try{
                while(running && count < MAX){
                    Thread.sleep(1000);
                    Log.d(TAG, "HelloService executando "+count);
                    count++;
                }
                Log.d(TAG, "HelloService fim");
            }catch (InterruptedException e){
                Log.e(TAG,e.getMessage(),e);
            }finally {
                stopSelf();
                Context context = HelloService.this;
                NotificationUtil.criarNotificacaoCompleto(getApplicationContext(),"fim do serviço",1);

            }
        }
}
    public void onDestroy(){
        running = false;
        Log.d(TAG,"serviço destruido");
    }
}
