package com.example.alexm.ormlitemuitosparamuitos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.alexm.ormlitemuitosparamuitos.DAO.DatabaseHelper;
import com.example.alexm.ormlitemuitosparamuitos.DAO.DisciplinaDAO;
import com.example.alexm.ormlitemuitosparamuitos.DAO.DisciplinaHasEstudanteDAO;
import com.example.alexm.ormlitemuitosparamuitos.DAO.EstudanteDAO;
import com.example.alexm.ormlitemuitosparamuitos.Modelo.Disciplina;
import com.example.alexm.ormlitemuitosparamuitos.Modelo.DisciplinaHasEstudante;
import com.example.alexm.ormlitemuitosparamuitos.Modelo.Estudante;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.RawRowMapper;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private EstudanteDAO estudanteDAO;
    private DisciplinaDAO disciplinaDAO;
    private DisciplinaHasEstudanteDAO disciplinaHasEstudanteDAO;
    private Estudante estudante;
    private Disciplina disciplina;
    private DisciplinaHasEstudante disciplinaHasEstudante;
    private static final String CATEGORIA = "Script";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            databaseHelper = new DatabaseHelper(MainActivity.this);
            estudanteDAO = new EstudanteDAO(databaseHelper.getConnectionSource());
            disciplinaDAO = new DisciplinaDAO(databaseHelper.getConnectionSource());
            disciplinaHasEstudanteDAO = new DisciplinaHasEstudanteDAO(databaseHelper.getConnectionSource());

            //INSERINDO AS DISCIPLINAS
            //1
            disciplina = new Disciplina();
            disciplina.setNome("Matemática");
            disciplina.setCodigo("MT");
            disciplinaDAO.create(disciplina);
            //2
            disciplina = new Disciplina();
            disciplina.setNome("Português");
            disciplina.setCodigo("PT");
            disciplinaDAO.create(disciplina);
            //3
            disciplina = new Disciplina();
            disciplina.setNome("Geografia");
            disciplina.setCodigo("GE");
            disciplinaDAO.create(disciplina);
            //4
            disciplina = new Disciplina();
            disciplina.setNome("Artes");
            disciplina.setCodigo("AR");
            disciplinaDAO.create(disciplina);

            //INSERINDO OS ALUNOS E SUAS DISCIPLINAS
            estudante = new Estudante();
            estudante.setNome("Alex");
            estudanteDAO.create(estudante);

            disciplinaHasEstudante = new DisciplinaHasEstudante();
            disciplinaHasEstudante.setEstudante(estudante);
            disciplina = disciplinaDAO.queryForId(1);
            disciplinaHasEstudante.setDisciplina(disciplina);
            disciplinaHasEstudanteDAO.create(disciplinaHasEstudante);

            disciplinaHasEstudante = new DisciplinaHasEstudante();
            disciplinaHasEstudante.setEstudante(estudante);
            disciplina = disciplinaDAO.queryForId(2);
            disciplinaHasEstudante.setDisciplina(disciplina);
            disciplinaHasEstudanteDAO.create(disciplinaHasEstudante);

            estudante = new Estudante();
            estudante.setNome("Tiago");
            estudanteDAO.create(estudante);

            disciplinaHasEstudante = new DisciplinaHasEstudante();
            disciplinaHasEstudante.setEstudante(estudante);
            disciplina = disciplinaDAO.queryForId(3);
            disciplinaHasEstudante.setDisciplina(disciplina);
            disciplinaHasEstudanteDAO.create(disciplinaHasEstudante);

            disciplinaHasEstudante = new DisciplinaHasEstudante();
            disciplinaHasEstudante.setEstudante(estudante);
            disciplina = disciplinaDAO.queryForId(4);
            disciplinaHasEstudante.setDisciplina(disciplina);
            disciplinaHasEstudanteDAO.create(disciplinaHasEstudante);


            Log.i(CATEGORIA, "CONSULTANDO REGISTROS ATRAVÉS DO MÉTODO RAW");
            GenericRawResults<DisciplinaHasEstudante> raw =
                    disciplinaHasEstudanteDAO.queryRaw("SELECT disciplina.nome, codigo FROM estudante INNER JOIN " +
                            "disciplina_has_estudante ON estudante.id = disciplina_has_estudante.id_estudante INNER JOIN " +
                            "disciplina ON disciplina_has_estudante.id_disciplina = disciplina.id WHERE " +
                            "estudante.nome LIKE \"Alex%\"",
                    new RawRowMapper<DisciplinaHasEstudante>() {
                        //Construtor que recebe como parâmetro o array de colunas, e o array dos valores, respectivamente
                        //Retorna todos os registros
                        @Override
                        public DisciplinaHasEstudante mapRow(String[] arrayColunas, String[] arrayValores) throws SQLException {
                            return new DisciplinaHasEstudante(arrayValores[0], arrayValores[1]);
                        }
                    });
            //For para percorrer todos os registros encontrados pelo mapRow
            for (DisciplinaHasEstudante discEst : raw){
                Log.i(CATEGORIA, "Nome: " + discEst.getPegaNome() + " - Código: " + discEst.getPegaCodigo() + "\n");
            }

            Log.i(CATEGORIA, "CONSULTANDO REGISTROS ATRAVÉS DO MÉTODO QueryBuilder e JOIN");
            QueryBuilder<Estudante, Integer> aqb = estudanteDAO.queryBuilder();
            QueryBuilder<DisciplinaHasEstudante, Integer> bqb = disciplinaHasEstudanteDAO.queryBuilder();
            //JOIN com Estudante e DisciplinaHasEstudante
            bqb.join(aqb);
            QueryBuilder<Disciplina, Integer> cqb = disciplinaDAO.queryBuilder();
            //WHERE - aplicando o filtro, selecionando apenas estudantes que começam com Alex
            aqb.where().like("nome", "Alex%");
            //JOIN com DisciplinaHasEstudante e Disciplina
            List<Disciplina> results = cqb.join(bqb).orderBy("nome", true).query();

            for (Disciplina disc : results){
                Log.i(CATEGORIA, "Nome: " + disc.getNome() + " - Código: " + disc.getCodigo() + "\n");
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
