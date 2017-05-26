package com.example.alexm.sqllite.data;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by alexm on 26/05/2017.
 */

public class DatabaseManager {
    private Integer mOpenCounter = 0;
    private static DatabaseManager instance;
    private static SQLiteOpenHelper mDatabaseHelper;
    private SQLiteDatabase mDatabase;

    public static synchronized void initializeInstance(SQLiteOpenHelper helper){
        if(instance == null){
            instance = new DatabaseManager();
            mDatabaseHelper = helper;
        }
    }

    public static synchronized DatabaseManager getInstance(){
        if(instance == null){
            throw new IllegalStateException(DatabaseManager.class.getSimpleName() +
                    "Não inicializado, inicialize a instacncia (..) primeiro");
        }
        return instance;
    }
    public synchronized SQLiteDatabase openDatabase(){
        mOpenCounter+=1;
        if(mOpenCounter == 1){
            //Open new Database
            mDatabase = mDatabaseHelper.getWritableDatabase();
        }
        return mDatabase;
    }

    public synchronized void closedDatabase(){
        mOpenCounter-=1;
        if(mOpenCounter == 0){
            //Closing database
            mDatabase.close();
        }
    }
}
