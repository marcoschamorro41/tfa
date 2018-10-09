package com.tfa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tfa.entities.Usuario;
import com.tfa.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    // MOSTRADORES
    
    @RequestMapping(value="/usuarios", method = RequestMethod.GET)
    public String showUserPage(ModelMap model){
        return "usuarios";
    }

    @RequestMapping(value="/usercreation", method = RequestMethod.GET)
    public String showCreateUserPage(ModelMap model) {
        return "crear-usuario";
    }
    
    @RequestMapping(value="/edituser", method = RequestMethod.GET)
    public String showEditUserPage(ModelMap model, @RequestParam String username) {
        
    	Usuario usuario = UserService.obtnerDatosUsuario(username);
        
    	if (usuario == null) {
    		model.put("errorMessage", "Error al obtener los datos del usuario desde la base de datos");
    		return "error-page";
    	}
    	
    	model.put("viejoUsuario", usuario.getUsername());
        model.put("usuario", usuario.getUsername());
        model.put("password", usuario.getPass());
        model.put("empresa", usuario.getCompany());
        model.put("rol", usuario.getRol());
    	
        return "editar-usuario";
    }

    
    // ACCIONES
    
    
    @RequestMapping(value="/creationofuser", method = RequestMethod.POST)
    public String createUser(ModelMap model, @RequestParam String username,
            @RequestParam String password, @RequestParam String corporate, @RequestParam String usertype) {
        
    	if (!corporate.equalsIgnoreCase("Admin") 
    			|| !corporate.equalsIgnoreCase("Operador")
    			|| !corporate.equalsIgnoreCase("Invitado"))
    		model.put("errorMessage", "El rol no es correcto. Solo puede ser: Admin, Operador o Invitado");
    	
    	boolean creado = UserService.crearUsuario(corporate, username, password, usertype);
    	
        if (!creado) {
        	model.put("errorMessage", "Error al crear usuario. Compruebe los datos");
        	return "crear-usuario";
        	
        } else {
        	model.put("username", username);
        	return "usuario-creado";
        }	
    }
    
    @RequestMapping(value="/editionofuser", method = RequestMethod.POST)
    public String editUser(ModelMap model, @RequestParam String oldUsername, @RequestParam String username,
            @RequestParam String password, @RequestParam String corporate, @RequestParam String usertype) {
        
    	if (!corporate.equalsIgnoreCase("Admin") 
    			|| !corporate.equalsIgnoreCase("Operador")
    			|| !corporate.equalsIgnoreCase("Invitado"))
    		model.put("errorMessage", "El rol no es correcto. Solo puede ser: Admin, Operador o Invitado");
    	
    	boolean creado = UserService.modificarUsuario(oldUsername, corporate, username, password, usertype);
    	
        if (!creado) {
        	model.put("errorMessage", "Error al crear usuario. Compruebe los datos");
        	return "crear-usuario";
        	
        } else {
        	model.put("username", username);
        	return "usuario-creado";
        }	
    }

}
