package com.rh.card.controller;

import com.rh.card.model.HabilidadDominioEmpleado;
import com.rh.card.repository.HabilidadDominioEmpleadoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping ("/api/habilidaddominioempleado")
@CrossOrigin (origins = "*")
public class HabilidadDominioEmpleadoController {
    private HabilidadDominioEmpleadoRepository habilidadDominioEmpleadoRepository;

    public HabilidadDominioEmpleadoController(
            HabilidadDominioEmpleadoRepository habilidadDominioEmpleadoRepository) {
        this.habilidadDominioEmpleadoRepository = habilidadDominioEmpleadoRepository;
    }

    @GetMapping
    public List<HabilidadDominioEmpleado> getAll(){
        return habilidadDominioEmpleadoRepository.findAll();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<HabilidadDominioEmpleado> getById(@PathVariable Long id){
        return habilidadDominioEmpleadoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.ok().build());
    }

    @PostMapping
    public HabilidadDominioEmpleado insertHabilidadDominioEmpleado(
            HabilidadDominioEmpleado habilidadDominioEmpleado){
        return habilidadDominioEmpleadoRepository.save(habilidadDominioEmpleado);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<HabilidadDominioEmpleado> updateHabilidadDominioEmpleado(
            @PathVariable Long id, @RequestBody HabilidadDominioEmpleado habilidadDominioEmpleado){
        return habilidadDominioEmpleadoRepository.findById(id)
                .map(existing -> {
                    existing.setEmpleado(habilidadDominioEmpleado.getEmpleado());
                    existing.setHabilidad(habilidadDominioEmpleado.getHabilidad());
                    existing.setDominio(habilidadDominioEmpleado.getDominio());
                    return ResponseEntity.ok(habilidadDominioEmpleadoRepository.save(existing));
                }).orElseGet(() -> ResponseEntity.ok().build());
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteHabilidadDominioEmpleado(@PathVariable Long id){
        if (!habilidadDominioEmpleadoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        habilidadDominioEmpleadoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
