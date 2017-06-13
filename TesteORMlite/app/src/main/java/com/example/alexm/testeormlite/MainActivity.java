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
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private EstudanteDAO estudanteDAO;
    private DisciplinaDAO disciplinaDAO;
    private List<Estudante> estudantes;
    private Estudante estudante = null;
    private Disciplina disciplina;
    private List<Disciplina> disciplinas;
    private int primeiroID = 0;
    private static final String CATEGORIA = "Script";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CONEXÃO
        try {
            databaseHelper = new DatabaseHelper(MainActivity.this);
            estudanteDAO = new EstudanteDAO(databaseHelper.getConnectionSource());
            disciplinaDAO = new DisciplinaDAO(databaseHelper.getConnectionSource());

            estudante = new Estudante();
            estudante.setNome("Alex");
            estudanteDAO.create(estudante);

            disciplina = new Disciplina();
            disciplina.setNome("Matemática");
            disciplina.setCodigo("MT");
            disciplina.setEstudante(estudante);
            disciplinaDAO.create(disciplina);

            disciplina = new Disciplina();
            disciplina.setNome("Português");
            disciplina.setCodigo("PT");
            disciplina.setEstudante(estudante);
            disciplinaDAO.create(disciplina);


            estudante = new Estudante();
            estudante.setNome("Tiago");
            estudanteDAO.create(estudante);

            disciplina = new Disciplina();
            disciplina.setNome("Geografia");
            disciplina.setCodigo("GE");
            disciplina.setEstudante(estudante);
            disciplinaDAO.create(disciplina);

            disciplina = new Disciplina();
            disciplina.setNome("Artes");
            disciplina.setCodigo("AR");
            disciplina.setEstudante(estudante);
            disciplinaDAO.create(disciplina);


            QueryBuilder<Disciplina, Integer> aqb = disciplinaDAO.queryBuilder();
            QueryBuilder<Estudante, Integer> bqb = estudanteDAO.queryBuilder();
            List<Disciplina> results = aqb.join(bqb).query();

            /*for (Disciplina a : results){
                Log.i(CATEGORIA, "Nome: "+ a.getNome() + " ID: " + a.getId());
            }*/

            //SELECIONADO OS REGISTROS DO BANCO
            Log.i(CATEGORIA, "REGISTROS CADASTRADOS");
            estudantes = estudanteDAO.queryForAll();
            //Pegando todas as linhas
            for (Estudante estud : estudantes){
                Log.i(CATEGORIA, "Nome: "+estud.getNome()+"\nID: "+estud.getId() + " Disciplinas: "+ estud.getDisciplinas().size());
                //Listando as disciplinas do aluno
                for (Disciplina disc : estud.getDisciplinas()){
                    Log.i(CATEGORIA, "Disciplina: "+disc.getNome()+"\nID: "+disc.getId() + " Código: "+ disc.getCodigo());
                }
            }

            //LISTANDO TODOS OS REGISTROS, ATRAVÉS DO MÉTODO RAW
            Log.i(CATEGORIA, "CONSULTANDO REGISTROS ATRAVÉS DO MÉTODO RAW");
            GenericRawResults<Estudante> raw = estudanteDAO.queryRaw("SELECT id, nome FROM estudante WHERE nome LIKE \"Alex%\"",
                    new RawRowMapper<Estudante>() {
                        //Construtor que recebe como parâmetro o array de colunas, e o array dos valores, respectivamente
                        //Retorna todos os registros
                        @Override
                        public Estudante mapRow(String[] arrayColunas, String[] arrayValores) throws SQLException {
                            return new Estudante(Integer.parseInt(arrayValores[0]), arrayValores[1]);
                        }
                    });
            //For para percorrer todos os registros encontrados pelo mapRow
            for (Estudante estud : raw){
                Log.i(CATEGORIA, "Nome: "+estud.getNome()+"\nID: "+estud.getId());
            }

            //CONSULTANDO REGISTROS PELO ID
            //Log.i(CATEGORIA, "CONSULTANDO REGISTROS PELO ID");
            estudante = estudanteDAO.queryForId(1);
            //Deletando estudante encontrado através do ID
            estudanteDAO.delete(estudante);

            //CONSULTANDO REGISTROS PELO ID
            //Log.i(CATEGORIA, "CONSULTANDO REGISTROS PELO ID");
            estudante = estudanteDAO.queryForId(2);
            //Alterando o nome do estudante encontrado através do ID
            estudante.setNome("Tiago José Coelho");
            estudanteDAO.update(estudante);


            //SELECIONADO OS REGISTROS DO BANCO
            Log.i(CATEGORIA, "");
            Log.i(CATEGORIA, "CONSULTANDO REGISTROS APÓS EXCLUIR REGISTRO 1");
            estudantes = estudanteDAO.queryForAll();
            //Pegando todas as linhas
            for (Estudante estud : estudantes){
                Log.i(CATEGORIA, "Nome: "+estud.getNome()+"\nID: "+estud.getId() + " Disciplinas: "+ estud.getDisciplinas().size());
                //Listando as disciplinas do aluno
                for (Disciplina disc : estud.getDisciplinas()){
                    Log.i(CATEGORIA, "Disciplina: "+disc.getNome()+"\nID: "+disc.getId() + " Código: "+ disc.getCodigo());
                }
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
