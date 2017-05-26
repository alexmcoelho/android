package com.example.alexm.sqllite.app;

import android.app.Application;
import android.content.Context;

import com.example.alexm.sqllite.data.DatabaseManager;
import com.example.alexm.sqllite.data.SQLHelper;

/**
 * Created by alexm on 26/05/2017.
 */

public class App extends Application {
    private static Context context;
    private static SQLHelper sqlHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();
        sqlHelper = new SQLHelper();
        DatabaseManager.initializeInstance(sqlHelper);
    }

    public static Context getContext(){
        return context;
    }
}
