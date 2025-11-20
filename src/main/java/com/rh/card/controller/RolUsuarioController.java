package com.rh.card.controller;

import com.rh.card.model.RolUsuario;
import com.rh.card.repository.RolUsuariorepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping ("/api/rolusuario")
public class RolUsuarioController {
    private RolUsuariorepository rolUsuariorepository;

    public RolUsuarioController(RolUsuariorepository rolUsuariorepository) {
        this.rolUsuariorepository = rolUsuariorepository;
    }

    @GetMapping
    public List<RolUsuario> getAll(){
        return rolUsuariorepository.findAll();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<RolUsuario> getById(@PathVariable Long id){
        return rolUsuariorepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public RolUsuario insertRolUsuario(@RequestBody RolUsuario rolUsuario){
        return rolUsuariorepository.save(rolUsuario);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<RolUsuario> updateRolUsuario(
            @PathVariable Long id, @RequestBody RolUsuario rolUsuario
    ){
        return rolUsuariorepository.findById(id)
                .map(existing -> {
                    existing.setRol(rolUsuario.getRol());
                    return ResponseEntity.ok(rolUsuariorepository.save(existing));
                }).orElseGet(() -> ResponseEntity.ok().build());
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<RolUsuario> deleteRolUsuario(@PathVariable Long id){
        if (!rolUsuariorepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        rolUsuariorepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
