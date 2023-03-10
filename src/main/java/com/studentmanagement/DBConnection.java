package com.studentmanagement;

import java.sql.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBConnection {
	private static Connection con = null;
	private static Logger logger = LogManager.getLogger(DBConnection.class);

	private DBConnection() {

	}

	static {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql:seneca", "postgres", "1234");
			logger.info("DB connection created");
		} catch (Exception e) {
			logger.info("There was a issue while creating db connection");
			logger.catching(e);
		}

	}

	public static Connection getcon() {
		logger.info("Connection method got called");
		return con;

	}
}
