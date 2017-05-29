package com.example.alexm.testeormlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.alexm.testeormlite.DAO.DatabaseHelper;
import com.example.alexm.testeormlite.DAO.DisciplinaDAO;
import com.example.alexm.testeormlite.DAO.EstudanteDAO;
import com.example.alexm.testeormlite.Modelo.Disciplina;
import com.example.alexm.testeormlite.Modelo.Estudante;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.RawRowMapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private EstudanteDAO estudanteDAO;
    private DisciplinaDAO disciplinaDAO;
    private List<Estudante> estudantes;
    private Estudante estudante;
    private int primeiroID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(MainActivity.this);

        estudantes = new ArrayList<Estudante>();

        estudante = new Estudante();
        estudante.setNome("Alex");
        estudante.setDisciplinas(Arrays.asList(new Disciplina("Matemática", "MT"), new Disciplina("Português", "PT")));
        estudantes.add(estudante);

        estudante = new Estudante();
        estudante.setNome("Ricardo");
        estudante.setDisciplinas(Arrays.asList(new Disciplina("Geográfia", "GE"), new Disciplina("Artes", "AR")));
        estudantes.add(estudante);

        //CREATE
        try {
            estudanteDAO = new EstudanteDAO(databaseHelper.getConnectionSource());
            disciplinaDAO = new DisciplinaDAO(databaseHelper.getConnectionSource());

            for (Estudante estud : estudantes){
                int result = estudanteDAO.create(estud);

                if(result == 1){
                    for (Disciplina disc : estud.getDisciplinas()){
                        disc.setEstudante(estud);
                        disciplinaDAO.create(disc);
                    }
                    primeiroID = primeiroID == 0 ? estud.getId() : primeiroID;
                }
            }
            //PEGANDO AS LINHAS DO BANCO
            Log.i("Script", " ");
            Log.i("Script", "REGISTROS CADASTRADOS");
            estudantes = estudanteDAO.queryForAll();//Pegando todas as linhas
            for (Estudante estud : estudantes){
                Log.i("Script", "Nome: "+estud.getNome()+"\nID: "+estud.getId() + "Disciplinas: "+ estud.getDisciplinas().size());
                //Listando as disciplinas do aluno
                for (Disciplina disc : estud.getDisciplinas()){
                    Log.i("Script", "Disciplina: "+disc.getNome()+"\nID: "+disc.getId() + " Código: "+ disc.getCodigo());
                }
                //Adicionando uma nova disciplina para o aluno - (poderia fazer assim sempre que
                // precissace adicionar uma disciplina a um aluno
                Disciplina disciplina = new Disciplina("História", "HI");
                disciplina.setEstudante(estud);
                disciplinaDAO.create(disciplina);
                //Aplicando o update no registro - mudando o nome no caso
                estud.setNome(estud.getNome()+" - ANDROID CLASS");
                estudanteDAO.update(estud);
            }

            //LISTANDO TODOS OS REGISTROS, EMBORA FORAM ALTERADOS
            Log.i("Script", " ");
            Log.i("Script", "REGISTROS DEPOIS DE TEREM SIDO ALTERADOS");
            estudantes = estudanteDAO.queryForAll();//Pegando todas as linhas
            for (Estudante estud : estudantes){
                Log.i("Script", "Nome: "+estud.getNome()+"\nID: "+estud.getId() + "Disciplinas: "+ estud.getDisciplinas().size());
                //Listando as disciplinas do aluno
                for (Disciplina disc : estud.getDisciplinas()){
                    Log.i("Script", "Disciplina: "+disc.getNome()+"\nID: "+disc.getId() + " Código: "+ disc.getCodigo());
                }
            }

            //CONSULTANDO REGISTROS PELO ID
            Log.i("Script", " ");
            Log.i("Script", "CONSULTANDO REGISTROS PELO ID");
            estudante = estudanteDAO.queryForId(primeiroID);//Pegando todas as linhas
            Log.i("Script", "Nome: "+estudante.getNome()+"\nID: "+estudante.getId() + "Disciplinas: "+ estudante.getDisciplinas().size());
            for (Disciplina disc : estudante.getDisciplinas()){
                Log.i("Script", "Disciplina: "+disc.getNome()+"\nID: "+disc.getId() + " Código: "+ disc.getCodigo());
            }

            //DELETANDO A COLEÇÃO DE DISCIPLINAS
            disciplinaDAO.delete(estudante.getDisciplinas());

            //CONSULTANDO REGISTROS PELO NOME
            Log.i("Script", " ");
            Log.i("Script", "CONSULTANDO REGISTROS PELO NOME");
            Map<String, Object> values = new HashMap<String, Object>();
            //primeiro a coluna que será pego e depois o conteúdo
            values.put("nome", "Ricardo");
            estudantes = estudanteDAO.queryForFieldValues(values);//Pegando o que foi filtrado
            for (Estudante estud : estudantes){
                Log.i("Script", "Nome: "+estud.getNome()+"\nID: "+estud.getId() + "Disciplinas: "+ estud.getDisciplinas().size());
                //Listando as disciplinas do aluno
                for (Disciplina disc : estud.getDisciplinas()){
                    Log.i("Script", "Disciplina: "+disc.getNome()+"\nID: "+disc.getId() + " Código: "+ disc.getCodigo());
                    //DELETANDO DISCIPLINAS UM POR UM
                    disciplinaDAO.delete(disc);
                }
            }

            //LISTANDO NOVAMENTE TODOS OS REGISTROS, EMBORA FORAM ALTERADOS - USANDO RAW
            Log.i("Script", " ");
            Log.i("Script", "REGISTROS DEPOIS DE NOVAMENTE TEREM SIDO ALTERADOS");
            GenericRawResults<Estudante> raw = estudanteDAO.queryRaw("SELECT id, nome FROM estudante WHERE nome LIKE \"Alex%\"",
                    new RawRowMapper<Estudante>() {
                @Override
                public Estudante mapRow(String[] arrayColunas, String[] arrayValores) throws SQLException {
                    return new Estudante(Integer.parseInt(arrayValores[0]), arrayValores[1]);//De acordo com o contrutor que recebe (
                }
            });//Pegando todas as linhas - usando o raw
            for (Estudante estud : raw){
                Log.i("Script", "Nome: "+estud.getNome()+"\nID: "+estud.getId());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        databaseHelper.close();
    }
}
