package com.rh.card.controller;

import com.rh.card.model.Departamento;
import com.rh.card.repository.DepartamentoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping ("/api/departamento")
@CrossOrigin (origins = "*")
public class DepartamentoController {
    private DepartamentoRepository departamentoRepository;

    public DepartamentoController(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    @GetMapping
    public List<Departamento> getAll(){
        return departamentoRepository.findAll();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Departamento> getById(@PathVariable Long id){
        return departamentoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Departamento insertDepartamento(@RequestBody Departamento departamento){
        return departamentoRepository.save(departamento);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Departamento> updateDepartamento(@PathVariable Long id, @RequestBody Departamento departamento){
        return departamentoRepository.findById(id)
                .map(existing -> {
                    existing.setNombreDepartamento(departamento.getNombreDepartamento());
                    return ResponseEntity.ok(departamentoRepository.save(existing));
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteDepartamento(@PathVariable Long id){
        if (!departamentoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        departamentoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
