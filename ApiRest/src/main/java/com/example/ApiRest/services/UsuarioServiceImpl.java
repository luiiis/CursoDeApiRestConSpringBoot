package com.example.ApiRest.services;

import com.example.ApiRest.models.Usuario;
import com.example.ApiRest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsuarioServiceImpl implements UsuarioServices{
    @Autowired
    private UserRepository repository;
    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) repository.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public void delete(Long id) {
      repository.deleteById(id);
    }
}
