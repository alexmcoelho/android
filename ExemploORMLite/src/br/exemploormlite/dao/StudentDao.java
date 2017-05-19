package br.exemploormlite.dao;

import java.sql.SQLException;

import br.exemploormlite.cdp.Student;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

public class StudentDao extends BaseDaoImpl<Student, Integer> {
	public StudentDao(ConnectionSource cs) throws SQLException{
		super(Student.class);
		setConnectionSource(cs);
		initialize();
	}
}
