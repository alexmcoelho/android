package com.example.alexm.testeormlite.Modelo;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "disciplina")
public class Disciplina {
    @DatabaseField(generatedId = true) //id auto increment
    private long id;
    @DatabaseField
    private String nome;
    @DatabaseField
    private String codigo;
    @DatabaseField(foreign = true)
    private Estudante estudante;

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

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
}
