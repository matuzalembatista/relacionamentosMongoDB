package com.matuzalem.mongodb.relacionamentos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.matuzalem.mongodb.relacionamentos.models.Perfil;
import com.matuzalem.mongodb.relacionamentos.repositories.PerfilRepository;


@RestController
@RequestMapping("/perfis")
public class PerfilController {
    @Autowired
    private PerfilRepository perfilRepository;

    @GetMapping
    public List<Perfil> getAll() {
        return perfilRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Perfil getById(@PathVariable("id") String id) {
        return perfilRepository.findById(id).orElseThrow(() -> new RuntimeException("Perfil não encontrado"));
    }

    @PostMapping
    public Perfil create(@RequestBody Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    @PutMapping("/{id}")    
    public Perfil update(@PathVariable("id") String id, @RequestBody Perfil perfil){
        Perfil perfilSalvo = perfilRepository.findById(id).orElse(null);
        if(perfilSalvo != null){
            perfilSalvo.setBio(perfil.getBio());
            perfilSalvo.setAvataUrl(perfil.getAvataUrl());
            return perfilRepository.save(perfilSalvo);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        perfilRepository.deleteById(id);
    }
}