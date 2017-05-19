package com.example.alexm.projetorealm;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by alexm on 17/05/2017.
 */

public class Configuracao extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration config= new RealmConfiguration.Builder(this).deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(config);
    }
}
