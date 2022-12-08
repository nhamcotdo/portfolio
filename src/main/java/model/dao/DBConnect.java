package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	private String url = "jdbc:mysql://localhost:3306/iportfolio";
	private Connection conn = null;

	public Connection connect() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(url, "root", "");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return conn;
	}

}
