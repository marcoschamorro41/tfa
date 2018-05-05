package com.tfa.service;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String crearUsuario(String corporate, String user, String password, String typeUser) {
        if (typeUser != "admin") {
            return "Se agrego otro usuario operador";
        }
        return "Se agrego un usuario admin";
    }



    public String modificarUsuario(String corporate, String user, String password, String typeUser) {

        if (typeUser != "admin") {
            return "Se modifico otro usuario";
        }
        return "No se modifico usuario admin";
    }

    public String borrarUsuario(String corporate, String user) {

        return "Se ha borrado Usuario";


    }

}

