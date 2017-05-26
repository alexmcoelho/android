package com.example.alexm.sqllite.data.model;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by alexm on 26/05/2017.
 */

public class Motorista {

    //pacote do content provider. Precisar ser unico
    public static final String AUTHORITY = "com.example.provider.carro";
    private long id;
    private String nome;
    private int idade;
    private Carro carro;

    public Motorista(){

    }

    public Motorista(String nome, int idade, Carro carro) {
        super();
        this.nome = nome;
        this.idade = idade;
        this.carro = carro;
    }

    public Motorista(long id, String nome, int idade, Carro carro) {
        super();
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.carro = carro;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public static final class Motoristas implements BaseColumns {
        //Não pode instanciar esta classe
        private Motoristas(){

        }

        public static final String NOME = "nome";
        public static final String IDADE = "idade";
        private static final String CARRO = "´carro";


    }
    public static String[] colunas = new String[]{
            Motoristas._ID,
            Motoristas.NOME,
            Motoristas.IDADE,
            Motoristas.CARRO

    };

    @Override
    public String toString() {
        return "id: " + getId() + "Nome: " +getNome() + ", Idade: " +getIdade() + ", Carro: " +getCarro();
    }
}
