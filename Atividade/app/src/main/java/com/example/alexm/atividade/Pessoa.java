package com.example.alexm.atividade;

import java.io.Serializable;

/**
 * Created by alexm on 24/02/2017.
 */

public class Pessoa implements Serializable{
    private String nome;
    private String cfp;
    private String endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCfp() {
        return cfp;
    }

    public void setCfp(String cfp) {
        this.cfp = cfp;
    }
}
