package com.example.alexm.ormlitemuitosparamuitos.DAO;

import com.example.alexm.ormlitemuitosparamuitos.Modelo.Disciplina;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

/**
 * Created by alexm on 07/06/2017.
 */

public class DisciplinaDAO extends BaseDaoImpl<Disciplina, Integer> {
    public DisciplinaDAO(ConnectionSource cs) throws SQLException {
        super(Disciplina.class);
        setConnectionSource(cs);
        initialize();
    }
}