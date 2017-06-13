package com.example.alexm.sqllite;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.alexm.sqllite.data.model.Carro;
import com.example.alexm.sqllite.data.repo.RepositorioCarro;

import java.util.List;

public class MainActivity extends ListActivity {
    protected static final int INSERIR_EDITAR = 1;
    public static RepositorioCarro repositorio = new RepositorioCarro();
    public List<Carro> carros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btCriar = (Button) findViewById(R.id.btNovo);
        btCriar.setOnClickListener(criarNovo());
        Button btMotora = (Button) findViewById(R.id.btMotoras);
        btMotora.setOnClickListener(visualizarMotoras());
        atualizarLista();
        ImageView iView = (ImageView) findViewById(R.id.swipeUp);
        iView.setOnTouchListener(swipeUp());
    }

   private View.OnTouchListener swipeUp() {
        return new OnSwipeTouchListener(MainActivity.this){
            public void onSwipeTop(){
                MainActivity.this.openOptionsMenu();
            }
        };
    }

    private View.OnClickListener visualizarMotoras() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(getApplicationContext(), MotorasActivity.class));
            }
        };
    }

    private View.OnClickListener criarNovo() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                novoRegistro();

            }
        };
    }

    public void atualizarLista(){
        //Pega a lista de carros e exibe na tela
        carros = repositorio.listarCarros();
        setListAdapter(new CarroListAdapter(this, carros));

    }

    public void novoRegistro(){
        startActivityForResult(new Intent(this, EditarCarro.class), INSERIR_EDITAR);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main,menu);

        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        //abrir menu
        switch (item.getItemId()){
            case R.id.menu_editar_carro :
                novoRegistro();
                break;
            case R.id.menu_buscar_carro :
                buscarRegistro();
                break;
        }

        return true;
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        editarCarro(position);
    }

    private void editarCarro(int position) {
        Carro carro = carros.get(position);
        Intent it = new Intent(this, EditarCarro.class);
        it.putExtra(Carro.Carros._ID, carro.getId());
        startActivityForResult(it, INSERIR_EDITAR);
    }

    //Para atualizar a lista assim que um registro for salvo, ou alteraddo
    //somente o metodo atualizarLista não é o suficiente
    @Override
    protected void onActivityResult(int codigo, int codigoRetorno, Intent it) {
        super.onActivityResult(codigo, codigoRetorno, it);

        if(codigoRetorno == RESULT_OK){
            atualizarLista();
        }
    }

    private void buscarRegistro() {
        startActivity(new Intent(this, buscarCarros.class));
    }


}
