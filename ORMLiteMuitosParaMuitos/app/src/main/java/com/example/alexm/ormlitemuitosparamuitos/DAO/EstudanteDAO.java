package com.example.alexm.ormlitemuitosparamuitos.DAO;

import com.example.alexm.ormlitemuitosparamuitos.Modelo.Estudante;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

/**
 * Created by alexm on 07/06/2017.
 */

public class EstudanteDAO extends BaseDaoImpl<Estudante, Integer> {
    public EstudanteDAO(ConnectionSource cs) throws SQLException {
        super(Estudante.class);
        setConnectionSource(cs);
        initialize();
    }
}
