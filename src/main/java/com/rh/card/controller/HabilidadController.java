package com.rh.card.controller;

import com.rh.card.model.Habilidad;
import com.rh.card.repository.HabilidadRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping ("/api/habilidad")
@CrossOrigin (origins = "*")
public class HabilidadController {
    private HabilidadRepository habilidadRepository;

    public HabilidadController(HabilidadRepository habilidadRepository) {
        this.habilidadRepository = habilidadRepository;
    }

    @GetMapping
    public List<Habilidad> getAll(){
        return habilidadRepository.findAll();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Habilidad> getById(@PathVariable Long id){
        return habilidadRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.ok().build());
    }

    @PostMapping
    public Habilidad insertHabilidad(@RequestBody Habilidad habilidad){
        return habilidadRepository.save(habilidad);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Habilidad> updateHabilidad(@PathVariable Long id, @RequestBody Habilidad habilidad){
        return habilidadRepository.findById(id)
                .map(existing -> {
                    existing.setNombreHabilidad(habilidad.getNombreHabilidad());
                    return ResponseEntity.ok(habilidadRepository.save(existing));
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteHabilidad(@PathVariable Long id){
        if (!habilidadRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        habilidadRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
