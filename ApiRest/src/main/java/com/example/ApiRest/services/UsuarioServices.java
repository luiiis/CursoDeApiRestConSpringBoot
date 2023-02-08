package com.example.ApiRest.services;

import com.example.ApiRest.models.Usuario;

import java.util.List;
public interface UsuarioServices {

    public List<Usuario> findAll();
    public Usuario findById(Long id);
    public Usuario save(Usuario usuario);
    public void delete(Long id);
}
