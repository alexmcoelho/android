package com.example.alexm.sqllite.data.repo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.alexm.sqllite.data.DatabaseManager;
import com.example.alexm.sqllite.data.model.Carro;

/**
 * Created by alexm on 26/05/2017.
 */

public class RepositorioCarro {
    private static final String CATEGORIA = "AULA";

    public RepositorioCarro(){

    }

    public  static String createTable(){
        return "CREATE TABLE " + Carro.TABLE +
                "(_ID integer primary key autoincrement, "+
                "nome text not null, placa text not null, "+
                "ano text not null)";
    }

    public long salvar(Carro carro){
        long id = carro.getId();
        if(id != 0){
            atualizar(carro);
        }else{
            id = inserir(carro);
        }
        return id;
    }

    public long inserir(Carro carro) {
        ContentValues values = new ContentValues();
        values.put(Carro.Carros.NOME, carro.getNome());
        values.put(Carro.Carros.PLACA, carro.getPlaca());
        values.put(Carro.Carros.ANO, carro.getAno());
        long id = inserir(values);
        return id;
    }

    public long inserir(ContentValues valores){
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        long id = db.insert(Carro.TABLE, "", valores);
        DatabaseManager.getInstance().closedDatabase();
        return id;
    }

    public int atualizar(Carro carro){
        ContentValues values = new ContentValues();
        values.put(Carro.Carros.NOME, carro.getNome());
        values.put(Carro.Carros.PLACA, carro.getPlaca());
        values.put(Carro.Carros.ANO, carro.getAno());
        String _id = String.valueOf(carro.getId());
        String where = Carro.Carros._ID + "=?";
        String[] whereArgs = new String[] {_id};
        int count = atualizar(values, where, whereArgs);
        return count;
    }

    public int atualizar(ContentValues valores, String where, String[] whereAgrs){
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        int count = db.update(Carro.TABLE, valores, where, whereAgrs);
        Log.i(CATEGORIA, "Atualizou [" + count + "] registros" );
        DatabaseManager.getInstance().closedDatabase();
        return count;
    }

    public int deletar(long id){
        String where = Carro.Carros._ID + "=?";
        String _id = String.valueOf(id);
        String[] whereArgs = new String[] { _id };
        int count = deletar(where, whereArgs);
        return count;
    }

    public int deletar(String where, String[] whereArgs){
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        int count = db.delete(Carro.TABLE, where, whereArgs);
        DatabaseManager.getInstance().closedDatabase();
        Log.i(CATEGORIA, "Deletou [" + count + "] registros");
        return count;
    }

    public Carro buscarCarro(long id){
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        Cursor c = db.query(true, Carro.TABLE,
                Carro.colunas,
                Carro.Carros._ID + "=" +id,
                null, null, null, null, null);
        if(c.getCount() > 0){
            c.moveToFirst();
            Carro carro = new Carro();
            carro.setId(c.getLong(0));
            carro.setNome(c.getString(1));
            carro.setPlaca(c.getString(2));
            carro.setAno(c.getInt(3));
            DatabaseManager.getInstance().closedDatabase();
            return carro;
        }
        DatabaseManager.getInstance().closedDatabase();
        return null;
    }

    public Cursor getCursor(){
        try {
            SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
            Cursor c = db.query(Carro.TABLE, Carro.colunas,
            null, null, null, null, null);
            return c;
        }catch (SQLException e){
            Log.e(CATEGORIA, "Erro ao buscar os registros: " +e.toString());
            return null;
        }
    }
}
