package com.example.alexm.studentrealm.application;

import android.app.Application;

import com.example.alexm.studentrealm.domain.MigrationData;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by viniciusthiengo on 11/2/15.
 */
public class CustomApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .name("realm-students.realm")
                .schemaVersion(MigrationData.VERSION)
                .migration(new MigrationData())
                //.deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration( realmConfiguration );
    }
}
