package com.example.alexm.sugarorm.modelos;

import com.orm.SugarRecord;

/**
 * Created by alexm on 12/05/2017.
 */

public class Produto extends SugarRecord{

    private String descricao;
    private int quantidade;

    public Produto(){

    }

    public Produto(String descricao, int quantidade){
        this.descricao = descricao;
        this.quantidade = quantidade;
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
}
