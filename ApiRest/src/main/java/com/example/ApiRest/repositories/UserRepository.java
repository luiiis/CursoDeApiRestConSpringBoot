package com.example.ApiRest.repositories;

import com.example.ApiRest.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Usuario,Long> {
}
