package com.example.alexm.projetostarservice;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class HelloIntentService extends IntentService {
    public HelloIntentService() {
        super("HelloIntentService");
    }
    private static final int MAX = 10;
    private static final String TAG = "aula";
    private boolean running;

    @Override
    protected void onHandleIntent(Intent intent) {
        running=true;
        int count = 0;
        while(running && count <MAX){
            fazAlgumaCoisa();
            Log.d(TAG,"ExemploServiço executando..."+count);
            count++;
        }
    }
    private void fazAlgumaCoisa() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void onDestroy() {
        super.onDestroy();
        running = false;
        Log.d(TAG, "ExemploServiço.OnDestroy");
    }


}
