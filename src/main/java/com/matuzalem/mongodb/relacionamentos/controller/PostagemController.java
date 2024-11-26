package com.matuzalem.mongodb.relacionamentos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.matuzalem.mongodb.relacionamentos.models.Postagem;
import com.matuzalem.mongodb.relacionamentos.repositories.PostagemRepository;


@RestController
@RequestMapping("/postagens")
public class PostagemController {
    @Autowired
    private PostagemRepository postagemRepository;

    @GetMapping
    public List<Postagem> getAll() {
        return postagemRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Postagem> getById(@PathVariable String id) {
        return postagemRepository.findById(id);
    }

    @PostMapping
    public Postagem create(@RequestBody Postagem postagem) {
        return postagemRepository.save(postagem);
    }

    @PutMapping("/{id}")
    public Postagem update(@PathVariable String id, @RequestBody Postagem postagem) {
        if (postagemRepository.existsById(id)) {
            postagem.setId(id);
            return postagemRepository.save(postagem);
        }
        throw new RuntimeException("Postagem com ID: " + id + " não encontrada");
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        if (postagemRepository.existsById(id)) {
            postagemRepository.deleteById(id);
        } 
    }

}
