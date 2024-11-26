package com.matuzalem.mongodb.relacionamentos.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.matuzalem.mongodb.relacionamentos.models.Perfil;

public interface PerfilRepository extends MongoRepository<Perfil, String> {

    
}
