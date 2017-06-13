package com.example.alexm.ormlitemuitosparamuitos.DAO;

import com.example.alexm.ormlitemuitosparamuitos.Modelo.DisciplinaHasEstudante;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

/**
 * Created by alexm on 07/06/2017.
 */

public class DisciplinaHasEstudanteDAO extends BaseDaoImpl<DisciplinaHasEstudante, Integer> {
    public DisciplinaHasEstudanteDAO(ConnectionSource cs) throws SQLException {
        super(DisciplinaHasEstudante.class);
        setConnectionSource(cs);
        initialize();
    }
}