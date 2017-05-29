package com.example.alexm.testeormlite.Modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Collection;

/**
 * Created by alexm on 28/05/2017.
 */

@DatabaseTable(tableName = "estudante")
public class Estudante {
    @DatabaseField(generatedId = true) //id auto increment
    private int id;
    @DatabaseField
    private String nome;
    @ForeignCollectionField
    private Collection<Disciplina> disciplinas;

    public Estudante() {
    }

    public Estudante(int id, String nome) {
        this.id = id;
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

    public Collection<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Collection<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
