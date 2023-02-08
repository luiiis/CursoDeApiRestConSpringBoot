package com.example.ApiRest.controllers;

import com.example.ApiRest.models.Usuario;
import com.example.ApiRest.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void crear(@RequestBody Usuario usuario){
    services.save(usuario);
    }
}
