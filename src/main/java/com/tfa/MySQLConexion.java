package com.tfa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConexion {
	
	public static void main(String [] args) {
		getConexion();
	}
	
	public static Connection getConexion () {
		
		Connection con = null;
		
		try {
			System.out.println("Empezo bien");
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url= "jdbc:mysql://localhost:81/tienda";
			String usuario = "root";
			String contrasenia = "";
			
			System.out.println("Siguio");
			con = DriverManager.getConnection(url, usuario, contrasenia);
			System.out.println("Despues de getCOnneciton");
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM employees";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
		         //Retrieve by column name
		         int id  = rs.getInt("id");
		         int age = rs.getInt("age");
		         String first = rs.getString("first");
		         String last = rs.getString("last");

		         //Display values
		         System.out.print("ID: " + id);
		         System.out.print(", Age: " + age);
		         System.out.print(", First: " + first);
		         System.out.println(", Last: " + last);
		      }
		      //STEP 6: Clean-up environment
		      rs.close();
		      stmt.close();
		      con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar Driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error al conectar la BD");
			e.printStackTrace();
		}
				
		return con;
	}

}
