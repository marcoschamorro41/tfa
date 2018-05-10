package com.tfa.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

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
        boolean correctUser = userid.equalsIgnoreCase("admin")
                || userid.equalsIgnoreCase("chamo");
        boolean correctPass = password.equalsIgnoreCase("123");
        return correctUser && correctPass;
    }

    public boolean isAdmin(String userid) {
        return userid.equalsIgnoreCase("admin");
    }

}