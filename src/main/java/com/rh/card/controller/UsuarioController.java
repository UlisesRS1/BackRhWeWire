package com.rh.card.controller;

import com.rh.card.model.Usuario;
import com.rh.card.repository.UsuarioRepository;
import org.apache.catalina.startup.Tomcat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping ("/api/usuario")
@CrossOrigin (origins = "*")
public class UsuarioController {
    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Long id){
        return usuarioRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.ok().build());
    }

    @PostMapping
    public Usuario insertUsuario(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        return usuarioRepository.findById(id)
                .map(existing -> {
                    existing.setUsuario(usuario.getUsuario());
                    existing.setIdRolUsuario(usuario.getIdRolUsuario());
                    existing.setContraseña(usuario.getContraseña());
                    return ResponseEntity.ok(usuarioRepository.save(existing));
                }).orElseGet(() -> ResponseEntity.ok().build());
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id){
        if (!usuarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        usuarioRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
