package com.example.alexm.sharedpreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExemploSalvarArquivoSDCard extends AppCompatActivity {

    private static final String ARQUIVO = "arquivo.txt";
    private static final String CATEGORIA = "aula";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo_salvar_arquivo);
        setContentView(R.layout.activity_exemplo_salvar_arquivo);

        Button b = (Button) findViewById(R.id.salvar);
        b.setOnClickListener(salvar());

        Button b2 = (Button) findViewById(R.id.deletar);
        b2.setOnClickListener(Deletar());

        visualizarArquivo();
    }
    private void visualizarArquivo() {
        TextView text = (TextView) findViewById(R.id.txt);
        try {
            File f = SDCardUtils.getSdCardFile("exemploArquivo", ARQUIVO);
            Log.i(CATEGORIA, "Abrindo arquivo: " + f.getAbsolutePath());
            if(f.exists()){
                FileInputStream in = new FileInputStream(f);
                int tamanho = in.available();
                byte bytes[] = new byte[tamanho];
                in.read(bytes);
                String s = new String(bytes);
                text.setText(s);
            }else{
                Log.i(CATEGORIA, "Arquivo não existe ou foi excluído");
                text.setText("Arquivo não existe ou excluído");
            }
        }catch (FileNotFoundException e){
            Log.e(CATEGORIA, "Arquivo não econtrado: " + e.getMessage(), e);

        }catch (IOException e){
            Log.e(CATEGORIA, e.getMessage(), e);
        }
    }

    private View.OnClickListener Deletar() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File f = SDCardUtils.getSdCardFile("exemploArquivo", ARQUIVO);
                boolean ok = f.delete();
                Log.i(CATEGORIA, "Arquivo deletado ?" + ok);
                visualizarArquivo();
            }
        };
    }

    private View.OnClickListener salvar() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    File f = SDCardUtils.getSdCardFile("exemploArquivo", ARQUIVO);
                    FileOutputStream out = new FileOutputStream(f, true);
                    EditText texto = (EditText) findViewById(R.id.texto);
                    String msg = texto.getText().toString();
                    out.write("\n".getBytes());
                    out.write(msg.getBytes());
                    out.close();
                    Log.i(CATEGORIA, msg + " - Escrito com sucesso");
                    visualizarArquivo();
                } catch (FileNotFoundException e) {
                    Log.e(CATEGORIA, e.getMessage(), e);
                } catch (IOException e) {
                    Log.e(CATEGORIA, e.getMessage(), e);
                }
            }
        };
    }
}
