package com.example.alexm.ormlitemuitosparamuitos.Modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Collection;

/**
 * Created by alexm on 07/06/2017.
 */

@DatabaseTable(tableName = "disciplina")
public class Disciplina {
    @DatabaseField(generatedId = true) //id auto increment
    private long id;
    @DatabaseField
    private String nome;
    @DatabaseField
    private String codigo;
    @ForeignCollectionField
    private Collection<DisciplinaHasEstudante> disciplinaHasEstudantes;

    public Disciplina() {
    }

    public Disciplina(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Collection<DisciplinaHasEstudante> getDisciplinaHasEstudantes() {
        return disciplinaHasEstudantes;
    }

    public void setDisciplinaHasEstudantes(Collection<DisciplinaHasEstudante> disciplinaHasEstudantes) {
        this.disciplinaHasEstudantes = disciplinaHasEstudantes;
    }
}
