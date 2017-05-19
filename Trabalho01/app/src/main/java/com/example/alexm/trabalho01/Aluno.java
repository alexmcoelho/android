package com.example.alexm.trabalho01;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by alexm on 24/03/2017.
 */

public class Aluno implements Parcelable {

    private String nome;
    private String matricula;
    private String sexo;
    private int idade;
    private String endereco;
    private String serie;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }
    protected Aluno(Parcel in){
        nome = in.readString();
        matricula = in.readString();
        sexo = in.readString();
        idade = in.readInt();
        endereco = in.readString();
        serie = in.readString();

    }

    public Aluno(String nome, String matricula, String sexo, int idade, String endereco, String serie){
        this.nome = nome;
        this.matricula = matricula;
        this.sexo = sexo;
        this.idade = idade;
        this.endereco = endereco;
        this.serie = serie;
    }

    public Aluno(){

    }

    public static final Creator<Aluno> CREATOR = new Creator<Aluno>() {
        @Override
        public Aluno createFromParcel(Parcel in) {
            return new Aluno(in);
        }

        @Override
        public Aluno[] newArray(int size) {
            return new Aluno[size];
        }
    };

    public int describeContents(){
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i){
        parcel.writeString(nome);
        parcel.writeString(matricula);
        parcel.writeString(sexo);
        parcel.writeInt(idade);
        parcel.writeString(endereco);
        parcel.writeString(serie);
    }
}
