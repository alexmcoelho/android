package com.example.alexm.sqllite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.alexm.sqllite.data.model.Carro;

import java.util.List;
import java.util.Objects;

/**
 * Created by alexm on 26/05/2017.
 */

public class CarroListAdapter extends BaseAdapter {
    private List<Carro> lista;
    private LayoutInflater inflater;
    public CarroListAdapter(Context context, List<Carro> lista){
        this.lista = lista;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount(){
        return lista.size();
    }

    public Object getItem(int position){
        return lista.get(position);
    }

    public long getItemId(int position){
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        Carro c =  lista.get(position);
        View view = inflater.inflate(R.layout.carro_linha_tabela, null);
        TextView nome = (TextView) view.findViewById(R.id.idNome);
        nome.setText(c.getNome());
        TextView placa = (TextView) view.findViewById(R.id.idPlaca);
        placa.setText(c.getPlaca());
        TextView ano = (TextView) view.findViewById(R.id.idAno);
        ano.setText(String.valueOf(c.getAno()));
        return view;
    }

}
