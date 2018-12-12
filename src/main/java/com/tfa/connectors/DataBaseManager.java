package com.tfa.connectors;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DataBaseManager {

	private static final String USER = "root";
	private static final String PASSWORD = "";
	private static final String SERVER_NAME = "localhost";
	private static final int SERVER_PORT = 3306;
	private static final String DB_NAME = "mamascheroni";
	
	
	public static MysqlDataSource getMysqlDataSource() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser(USER);
		dataSource.setPassword(PASSWORD);
		dataSource.setServerName(SERVER_NAME);
		dataSource.setPort(SERVER_PORT);
		dataSource.setDatabaseName(DB_NAME);
		return dataSource;
	}
	
}
