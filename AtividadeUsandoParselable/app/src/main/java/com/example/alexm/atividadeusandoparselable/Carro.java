package com.example.alexm.atividadeusandoparselable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by alexm on 03/03/2017.
 */

public class Carro implements Parcelable {
    private String nome;
    private int placa;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPlaca() {
        return placa;
    }

    public void setPlaca(int placa) {
        this.placa = placa;
    }

    protected Carro(Parcel in){
        nome = in.readString();
        placa = in.readInt();
    }

    public Carro(String nome, int placa){
        this.nome = nome;
        this.placa = placa;
    }

    public static final Creator<Carro> CREATOR = new Creator<Carro>() {
        @Override
        public Carro createFromParcel(Parcel in) {
            return new Carro(in);
        }

        @Override
        public Carro[] newArray(int size) {
            return new Carro[size];
        }
    };

    public int describeContents(){
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i){
        parcel.writeString(nome);
        parcel.writeInt(placa);
    }
}
