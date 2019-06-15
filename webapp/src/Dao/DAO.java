package Dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DAO {


	public static Connection getConnection() throws NamingException{
		Connection con =null;
		try {
			InitialContext  ini = new InitialContext();

			 DataSource ds =(DataSource)ini.lookup("java:/comp/env/jdbc/test");
			 con = ds.getConnection();


		}catch(SQLException e) {
			e.printStackTrace();
		}catch(NamingException e) {
			e.printStackTrace();
		}
		return con;
	}
}