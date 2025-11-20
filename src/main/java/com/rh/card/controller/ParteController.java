package com.rh.card.controller;

import com.rh.card.model.Parte;
import com.rh.card.repository.ParteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping ("/api/parte")
@CrossOrigin (origins = "*")
public class ParteController {
    private ParteRepository parteRepository;

    public ParteController(ParteRepository parteRepository) {
        this.parteRepository = parteRepository;
    }

    @GetMapping
    public List<Parte> getAll(){
        return parteRepository.findAll();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Parte> getById(@PathVariable Long id){
        return parteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.ok().build());
    }

    @PostMapping
    public Parte insertParte(@RequestBody Parte parte){
        return parteRepository.save(parte);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Parte> updateParte(@PathVariable Long id, @RequestBody Parte parte){
        return parteRepository.findById(id)
                .map(existing -> {
                    existing.setNombreParte(parte.getNombreParte());
                    return ResponseEntity.ok(parteRepository.save(existing));
                }).orElseGet(() -> ResponseEntity.ok().build());
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteParte(@PathVariable Long id){
        if (!parteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        parteRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
