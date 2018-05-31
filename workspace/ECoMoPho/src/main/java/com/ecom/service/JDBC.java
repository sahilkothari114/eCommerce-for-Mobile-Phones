package com.ecom.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ecom.util.EComConstants;

class JDBC {

	private static JDBC jdbc;

	private JDBC() {
	}

	public static JDBC getInstance() {
		if (jdbc == null) {
			jdbc = new JDBC();
		}
		return jdbc;
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(
					EComConstants.ADDRESS + ":" + EComConstants.PORT + "/" + EComConstants.DATABASE,
					EComConstants.USER, EComConstants.PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
