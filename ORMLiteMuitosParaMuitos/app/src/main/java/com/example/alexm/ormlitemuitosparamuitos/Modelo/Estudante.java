package com.example.alexm.ormlitemuitosparamuitos.Modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Collection;

/**
 * Created by alexm on 07/06/2017.
 */

@DatabaseTable(tableName = "estudante")
public class Estudante {
    @DatabaseField(generatedId = true) //id auto increment
    private long id;
    @DatabaseField
    private String nome;
    @ForeignCollectionField
    private Collection<DisciplinaHasEstudante> disciplinaHasEstudantes;

    public Estudante() {
    }

    public Estudante(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Collection<DisciplinaHasEstudante> getDisciplinaHasEstudantes() {
        return disciplinaHasEstudantes;
    }

    public void setDisciplinaHasEstudantes(Collection<DisciplinaHasEstudante> disciplinaHasEstudantes) {
        this.disciplinaHasEstudantes = disciplinaHasEstudantes;
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


}
