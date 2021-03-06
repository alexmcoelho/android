package br.exemploormlite.dao;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import br.exemploormlite.cdp.Discipline;
import br.exemploormlite.cdp.Student;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;


public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
	private static final String databaseName = "school.db";
	private static final int databaseVersion = 15;
	
	public DatabaseHelper(Context context) {
		super(context, databaseName, null, databaseVersion);
	}
	
	
	@Override
	public void onCreate(SQLiteDatabase sd, ConnectionSource cs) {
		try {
			TableUtils.createTable(cs, Student.class);
			TableUtils.createTable(cs, Discipline.class);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void onUpgrade(SQLiteDatabase sd, ConnectionSource cs, int oldVersion, int newVersion) {
		try {
			TableUtils.dropTable(cs, Student.class, true);
			TableUtils.dropTable(cs, Discipline.class, true);
			onCreate(sd, cs);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void close(){
		super.close();
	}
}
