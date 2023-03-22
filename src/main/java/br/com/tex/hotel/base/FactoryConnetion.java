package br.com.tex.hotel.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryConnetion {
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /* Aqui registry */
		return DriverManager.getConnection("jdbc:mysql://localhost/projeto_hotel", "root", "235731");
	}
}
