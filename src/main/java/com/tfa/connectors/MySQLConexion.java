package com.tfa.connectors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.MysqlDataSource;

public class MySQLConexion {

    public static void main(String [] args) {
        try {
            getConexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConexion () throws SQLException {


        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("");
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("mamascheroni");

        Connection conn = dataSource.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios");

        while(rs.next()){
            //Retrieve by column name
            String username = rs.getString("username");
            String password = rs.getString("password");
            String rol = rs.getString("rol");
            String company = rs.getString("company");

            //Display values
            System.out.print("Usuario: " + username + " ");
            System.out.print("Contra: " + password + " ");
            System.out.print("Rol: " + rol + " ");
            System.out.println("Empresa: " + company + " ");
        }
        rs.close();
        stmt.close();
        conn.close();

        return conn;
    }

}
