package com.matuzalem.mongodb.relacionamentos.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.matuzalem.mongodb.relacionamentos.models.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{
}
