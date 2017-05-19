package com.example.alexm.trabalho01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button = (Button) findViewById(R.id.btLogin);
        button.setOnClickListener(login());
    }

    private View.OnClickListener login() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText etName = (EditText)findViewById(R.id.edLogin);
                String login = etName.getText().toString();
                EditText etSenha = (EditText)findViewById(R.id.edSenha);
                String senha = etSenha.getText().toString();
                String frase;

                if(login.equals("admin") && senha.equals("123")){
                    Intent it = new Intent("ACAO");
                    it.addCategory("INICIAL");
                    frase="Login efetuado com sucesso!";
                    startActivity(it);
                }else{
                    frase = "Usuário ou senha inválido(s).\n" +
                            "Tente login: admin e senha: 123";
                }
                Toast.makeText(getApplicationContext(), frase,
                        Toast.LENGTH_SHORT).show();


            }
        };
    }
}
