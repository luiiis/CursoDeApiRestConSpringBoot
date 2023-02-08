package com.example.ApiRest.controllers;

import com.example.ApiRest.models.Usuario;
import com.example.ApiRest.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UsuarioServices services;

    @GetMapping("/usuario")
    public List<Usuario> listar(){
        return services.findAll();
    }

    @PostMapping("/usuario")
    public ResponseEntity<?> crear(@RequestBody Usuario usuario){
        Usuario usuarioNew=null;
        Map<String,Object> response = new HashMap<>();
        try{
            usuarioNew = services.save(usuario);
        }catch(DataAccessException e){
            response.put("mensaje","Error al realizar el insert en la base de datos");
            response.put("error",e.getMessage());
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje","El usuario se a creado con exito");
        response.put("usuario",usuarioNew);
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> show(@PathVariable Long id){
        Usuario usuario = null;
        Map<String,Object> response = new HashMap<>();
        try{
            usuario = services.findById(id);
        }catch(DataAccessException e){
            response.put("mensaje","Error al realizar el la visualizacion en la base de datos");
            response.put("error",e.getMessage());
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(usuario==null){
            response.put("mensaje","el cliente con id: ".concat(" ").concat("No existe"));
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);
    }
}
