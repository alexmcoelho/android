package com.example.alexm.trabalho01;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by alexm on 30/03/2017.
 */

public class Nota implements Parcelable {
    private double nota;
    private double peso;

    public Nota(Parcel in) {
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Nota(Double nota, Double peso){
        this.nota = nota;
        this.peso = peso;
    }

    public Nota(){

    }

    public static final Creator<Nota> CREATOR = new Creator<Nota>() {
        @Override
        public Nota createFromParcel(Parcel in) {
            return new Nota(in);
        }

        @Override
        public Nota[] newArray(int size) {
            return new Nota[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(nota);
        dest.writeDouble(peso);
    }
}
