package com.matuzalem.mongodb.relacionamentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.matuzalem.mongodb.relacionamentos.repositories.EstudanteRepository;
import com.matuzalem.mongodb.relacionamentos.models.Estudante;


@RestController
@RequestMapping("/estudantes")
public class EstudanteController {
    @Autowired
    private EstudanteRepository estudanteRepository;

    @GetMapping
    public List<Estudante> getAll() {
        return estudanteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Estudante> getById(@PathVariable("id") String id) {
        return estudanteRepository.findById(id);
    }

    @PostMapping
    public Estudante create(@RequestBody Estudante estudante) {
        return estudanteRepository.save(estudante);
    }

    @PutMapping("/{id}")
    public Estudante update(@PathVariable("id") String id, @RequestBody Estudante estudante) {
        if (estudanteRepository.existsById(id)) {
            estudante.setId(id);
            return estudanteRepository.save(estudante);
        }
        throw new RuntimeException("Estudante com ID: " + id + " não encontrado");
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        if (estudanteRepository.existsById(id)) {
            estudanteRepository.deleteById(id);
        } 
    }
}