package com.example.alexm.projetorealm;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by alexm on 17/05/2017.
 */

public class ProdutoAdapter extends ArrayAdapter<Produto> {

    private final Context context;
    private final List<Produto> elementos;

    public ProdutoAdapter(Context context, List<Produto> elementos) {
        super(context, R.layout.linha, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.linha, parent, false);

        TextView titulo = (TextView) rowView.findViewById(R.id.txtDescricao);
        TextView autor = (TextView) rowView.findViewById(R.id.txtQuantidade);
        TextView ano = (TextView) rowView.findViewById(R.id.txtValor);

        titulo.setText(elementos.get(position).getDescricao());
        autor.setText(Integer.toString(elementos.get(position).getQuantidade()));
        ano.setText(Double.toString(elementos.get(position).getValor()));

        return rowView;
    }
}
