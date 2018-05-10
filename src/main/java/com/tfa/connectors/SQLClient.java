package com.tfa.connectors;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class SQLClient {

    private Connection conn;
    private boolean isConnected;

    public SQLClient() {
        conn = null;
        isConnected = false;
    }

    public Connection connect() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("sql10237246");
        dataSource.setPassword("CQuyBrI8HQ");
        dataSource.setServerName("sql10.freemysqlhosting.net");
        dataSource.setDatabaseName("sql10237246");

        try {
            conn = dataSource.getConnection();
            dataSource.getConnection();
            isConnected = true;
        } catch (SQLException e) {
            e.printStackTrace();
            isConnected = false;
        }
        return conn;
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isConnected() {
        return isConnected;
    }

}
