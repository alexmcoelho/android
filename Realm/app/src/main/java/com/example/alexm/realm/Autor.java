package com.example.alexm.realm;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by alexm on 26/05/2017.
 */

public class Autor extends RealmObject {

    @PrimaryKey
    int id;
    String nome;
    RealmList<Livro> livros;

    public Autor(){

    }

    public Autor(int id, String nome, RealmList<Livro> livros) {
        this.id = id;
        this.nome = nome;
        this.livros = livros;
    }

    public RealmList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(RealmList<Livro> livros) {
        this.livros = livros;
    }

    public Autor(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
