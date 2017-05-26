package com.example.alexm.sqllite.data;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.alexm.sqllite.app.App;
import com.example.alexm.sqllite.data.model.Carro;
import com.example.alexm.sqllite.data.repo.RepositorioCarro;

/**
 * Created by alexm on 26/05/2017.
 */

public class SQLHelper extends SQLiteOpenHelper {
    private static final  String CATEGRORIA = "AULA";
    private static final String NOME_BANCO = "aula_android";
    private static final int VERSAO_BANCO = 1;

    public SQLHelper(){
        super(App.getContext(), NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys=ON");
        db.execSQL(RepositorioCarro.createTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versaoAntiga, int novaVersao) {
        db.execSQL("DROP TABLE IF EXISTS " + Carro.TABLE);
        onCreate(db);
    }
}
