package com.tfa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.tfa.connectors.DataBaseManager;
import com.tfa.entities.Usuario;

@Service
public class UserService {

	public static Usuario obtnerDatosUsuario(String user) {
		Usuario usuario = new Usuario();
		try {
			MysqlDataSource dataSource = DataBaseManager.getMysqlDataSource();
			String query = "SELECT * FROM usuarios WHERE username = ?";
			Connection conn = dataSource.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, user);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				usuario.setUsername(user);
				usuario.setCompany(rs.getString("company"));
				usuario.setPass(rs.getString("password"));
				usuario.setRol(rs.getString("rol"));
			}
			
			rs.close();
			statement.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
	}

	public static boolean crearUsuario(String corporate, String user, String password, String typeUser) {
		boolean bandera = false;

		try {

			MysqlDataSource dataSource = DataBaseManager.getMysqlDataSource();

			String query = "INSERT INTO usuarios (username, password, rol, company) " + "VALUES (?, ?, ?, ?);";

			Connection conn = dataSource.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);

			statement.setString(1, user);
			statement.setString(2, password);
			statement.setString(3, typeUser);
			statement.setLong(4, Long.parseLong(corporate));

			int inserted = 0;
			try {
				inserted = statement.executeUpdate();
			} catch (Exception e) {
				inserted = -1;
			}

			bandera = (inserted == 1) ? true : false;

			statement.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bandera;
	}

	
	public static boolean modificarUsuario(String oldUsername, String corporate, String user, String password, String typeUser) {
		boolean bandera = false;

		try {

			MysqlDataSource dataSource = DataBaseManager.getMysqlDataSource();

			String query = "UPDATE usuarios "
					+ "SET username = ?, password = ?, rol = ?, company = ? "
					+ "WHERE username = ?";

			Connection conn = dataSource.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);

			statement.setString(1, user);
			statement.setString(2, password);
			statement.setString(3, typeUser);
			statement.setString(4, corporate);
			statement.setString(5, oldUsername);

			int inserted = 0;
			try {
				inserted = statement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				inserted = -1;
			}

			System.out.println("Codigo de insercion: " + inserted);
			bandera = (inserted == 1) ? true : false;

			statement.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bandera;
	}
	
	
    
    

	public String borrarUsuario(String corporate, String user) {

		return "Se ha borrado Usuario";

	}

}
