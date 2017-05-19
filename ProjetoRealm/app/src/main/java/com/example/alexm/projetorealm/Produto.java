package com.example.alexm.projetorealm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by alexm on 17/05/2017.
 */

public class Produto extends RealmObject{
    @PrimaryKey
    private int id;
    private String descricao;
    private int quantidade;
    private double valor;

    public Produto(){

    }

    public Produto(int id, String descricao, int quantidade, double valor){
        this.id = id;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
