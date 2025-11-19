package com.rh.card.controller;

import com.rh.card.model.Dominio;
import com.rh.card.repository.DominioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/dominio")
@CrossOrigin (origins = "*")
public class DominioController {
    private DominioRepository dominioRepository;

    public DominioController(DominioRepository dominioRepository) {
        this.dominioRepository = dominioRepository;
    }

    @GetMapping
    public List<Dominio> getAll(){
        return dominioRepository.findAll();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Dominio> getById(@PathVariable Long id){
        return dominioRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Dominio insertDominio(@RequestBody Dominio dominio){
        return dominioRepository.save(dominio);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Dominio> updateDominio(@PathVariable Long id,
                                                 @RequestBody Dominio dominio){
        return  dominioRepository.findById(id)
                .map(existing -> {
                    existing.setDescripcionDominio(dominio.getDescripcionDominio());
                    existing.setNivel(dominio.getNivel());
                    return ResponseEntity.ok(dominioRepository.save(existing));
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteDominio(@PathVariable Long id){
        if (!dominioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        dominioRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
