package com.example.alexm.testeormlite.DAO;

import com.example.alexm.testeormlite.Modelo.Estudante;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
/**
 * Created by alexm on 28/05/2017.
 */

public class EstudanteDAO extends BaseDaoImpl<Estudante, Integer> {
    public EstudanteDAO(ConnectionSource cs) throws SQLException {
        super(Estudante.class);
        setConnectionSource(cs);
        initialize();
    }
}
