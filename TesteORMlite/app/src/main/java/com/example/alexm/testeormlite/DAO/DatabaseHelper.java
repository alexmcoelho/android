package com.example.alexm.testeormlite.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.alexm.testeormlite.Modelo.Disciplina;
import com.example.alexm.testeormlite.Modelo.Estudante;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by alexm on 28/05/2017.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper{
    private static final String databaseName = "banco_de_dados_escola.db";
    private static final int databaseVersion = 13;

    public DatabaseHelper(Context context) {
        super(context, databaseName, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Estudante.class);
            TableUtils.createTable(connectionSource, Disciplina.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Estudante.class, true);// o true vai fazer com que não apareça os erros
            TableUtils.dropTable(connectionSource, Disciplina.class, true);
            onCreate(sqLiteDatabase,connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        super.close();
    }
}
