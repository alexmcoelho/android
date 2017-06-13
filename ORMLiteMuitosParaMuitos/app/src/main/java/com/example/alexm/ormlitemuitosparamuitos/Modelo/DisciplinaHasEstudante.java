package com.example.alexm.ormlitemuitosparamuitos.Modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by alexm on 07/06/2017.
 */

@DatabaseTable(tableName = "disciplina_has_estudante")
public class DisciplinaHasEstudante {

    @DatabaseField(generatedId = true) //id auto increment
    private long id;

    @DatabaseField(columnName = "id_disciplina", foreign = true)
    private Disciplina disciplina;

    @DatabaseField(columnName = "id_estudante", foreign = true)
    private Estudante estudante;







    private String pegaNome;
    private String pegaCodigo;


    public DisciplinaHasEstudante() {
    }

    public DisciplinaHasEstudante(String pegaNome, String pegaCodigo) {
        this.pegaNome = pegaNome;
        this.pegaCodigo = pegaCodigo;
    }

    public String getPegaNome() {
        return pegaNome;
    }

    public void setPegaNome(String pegaNome) {
        this.pegaNome = pegaNome;
    }

    public String getPegaCodigo() {
        return pegaCodigo;
    }

    public void setPegaCodigo(String pegaCodigo) {
        this.pegaCodigo = pegaCodigo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
}
