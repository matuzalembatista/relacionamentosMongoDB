package com.matuzalem.mongodb.relacionamentos.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.matuzalem.mongodb.relacionamentos.models.Curso;

@Repository
public interface CursoRepository extends MongoRepository<Curso, String> {
    
}
