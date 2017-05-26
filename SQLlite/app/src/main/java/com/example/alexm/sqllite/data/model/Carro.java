package com.example.alexm.sqllite.data.model;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by alexm on 26/05/2017.
 */

public class Carro {

    public static final String TABLE = "carros";

    //pacote do content provider. Precisar ser unico
    public static final String AUTHORITY = "com.example.provider.carro";
    private long id;
    private String nome;
    private String placa;
    private int ano;

    public Carro(){

    }

    public Carro(long id, String nome, String placa, int ano) {
        super();
        this.id = id;
        this.nome = nome;
        this.placa = placa;
        this.ano = ano;
    }

    public Carro(String nome, String placa, int ano) {
        super();
        this.nome = nome;
        this.placa = placa;
        this.ano = ano;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public static final class Carros implements BaseColumns{
        //Não pode instanciar esta classe
        private Carros(){

        }

        public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/carros");
        public static final String NOME = "nome";
        public static final String ANO = "ano";
        public static final String PLACA = "´placa";
        //Mime type para todos os carros
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.google.carros";
        //Mime type um única carro
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.google.carros";
        //Ordenação default para inserir no order by
        public static final String DEFAULT_SORT_ORDER = "id_ASC";

        public static Uri getUriId(long id){
            Uri uriCarro = ContentUris.withAppendedId(Carros.CONTENT_URI, id);
            return uriCarro;
        }
    }

    //Serão as colunas do banco
    public static String[] colunas = new String[]{
            Carros._ID,
            Carros.NOME,
            Carros.PLACA,
            Carros.ANO
    };

    @Override
    public String toString() {
        return "Nome: " +getNome() + ", placa: " +getPlaca() + ", Ano: " +getAno();
    }
}
