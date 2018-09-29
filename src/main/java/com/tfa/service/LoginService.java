package com.tfa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.tfa.connectors.SQLClient;
import com.tfa.entities.Session;

@Service
public class LoginService {

    public Session login(String usuario, String password) {
        Session session = null;
        try {
            SQLClient connector = new SQLClient();
            Connection connection = connector.connect();
            ResultSet resultSet = null;
            PreparedStatement statement = null;
            String query = "SELECT * FROM usuarios WHERE username = ?";

            statement = connection.prepareStatement(query);
            statement.setString(1, usuario);
            resultSet = statement.executeQuery();

            boolean userExist = false;
            if (resultSet.next()) {
                userExist = true;
                if (password.equals(resultSet.getString("password")))
                    session = new Session(true, null, usuario);
            }

            if(!userExist) session = new Session(false, "The user does not exist", null);
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            session = new Session(false,
                    "Se produjo un error al conectarse a la base de datos.\nDescripcion: " + e.getMessage());
        }
        return session;
    }

	public boolean validateUser(String userid, String password) {
		boolean bandera = false;
		try {
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setUser("mmascheroni");
			dataSource.setPassword("Marie2704!");
			dataSource.setServerName("23.229.219.200");
			dataSource.setPort(3306);
			dataSource.setDatabaseName("mamascheroni");

			String query = "SELECT * FROM usuarios WHERE username = ?";

			Connection conn = dataSource.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, userid);
			ResultSet rs = statement.executeQuery();

			
			
			while (rs.next()) {
				String pass = rs.getString("password");
				bandera = password.equalsIgnoreCase(pass);
			}
			rs.close();
			statement.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bandera;

	}

    public boolean isAdmin(String userid) {
    	boolean bandera = false;
    	
    	try {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUser("mmascheroni");
            dataSource.setPassword("Marie2704!");
            dataSource.setServerName("23.229.219.200");
            dataSource.setPort(3306);
            dataSource.setDatabaseName("mamascheroni");

            String query = "SELECT * FROM usuarios WHERE username = ?";
            
            Connection conn = dataSource.getConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, userid);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
            	String roluser = rs.getString("rol");
				bandera = roluser.equalsIgnoreCase("admin");
            }
        
            rs.close();
            statement.close();
            conn.close();
            
        	} catch (SQLException e) {
        		e.printStackTrace();
        	}
    	return bandera;
        
    }

}