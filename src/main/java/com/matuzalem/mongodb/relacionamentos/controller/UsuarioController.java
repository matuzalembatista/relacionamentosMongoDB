package com.matuzalem.mongodb.relacionamentos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import com.matuzalem.mongodb.relacionamentos.models.Perfil;
import com.matuzalem.mongodb.relacionamentos.models.Usuario;
import com.matuzalem.mongodb.relacionamentos.models.Postagem;
import com.matuzalem.mongodb.relacionamentos.repositories.PerfilRepository;
import com.matuzalem.mongodb.relacionamentos.repositories.UsuarioRepository;
import com.matuzalem.mongodb.relacionamentos.repositories.PostagemRepository;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    private  PerfilRepository perfilRepository;


    @Autowired
    private  UsuarioRepository usuarioRepository;

    @GetMapping()
    public List<Usuario>getAll() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> getIdUsuarios(@PathVariable String id){
        return usuarioRepository.findById(id);
    } 


    @PostMapping()
    public Usuario create (@RequestBody Usuario usuario){
        if (usuario.getPerfil() != null && usuario.getPerfil().getId() == null){
            Perfil perfilSalvo = perfilRepository.save(usuario.getPerfil());
            usuario.setPerfil(perfilSalvo);
        }
        
        return usuarioRepository.save(usuario);
    }


    @PutMapping("/{id}")
    public Usuario update(@PathVariable("id") String id, @RequestBody Usuario usuario) {
        Usuario usuarioSalvo = usuarioRepository.findById(id).orElse(null);
        if(usuarioSalvo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }
        
        usuarioSalvo.setNome(usuario.getNome());

        if (usuario.getPerfil() != null) {
            usuarioSalvo.setPerfil(usuario.getPerfil());
        }

        if (usuario.get() != null) {
            usuarioSalvo.setPostagens(usuario.getPostagens());
        }

        return usuarioRepository.save(usuarioSalvo);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        Usuario usuarioSalvo = usuarioRepository.findById(id).orElse(null);
        if (usuarioSalvo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }
        usuarioRepository.delete(usuarioSalvo);
    }
    


    



    
}
