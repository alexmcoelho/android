package com.example.alexm.realm;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by alexm on 13/05/2017.
 */

public class Configuracao extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration config= new RealmConfiguration.Builder(this).deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(config);
    }
}
