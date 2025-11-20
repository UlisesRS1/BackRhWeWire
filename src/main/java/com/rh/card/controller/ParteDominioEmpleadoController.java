package com.rh.card.controller;

import com.rh.card.model.ParteDominioEmpleado;
import com.rh.card.repository.ParteDominioEmpleadoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping ("/api/partedominioempleado")
@CrossOrigin (origins = "*")
public class ParteDominioEmpleadoController {
    private ParteDominioEmpleadoRepository parteDominioEmpleadoRepository;

    public ParteDominioEmpleadoController(
            ParteDominioEmpleadoRepository parteDominioEmpleadoRepository) {
        this.parteDominioEmpleadoRepository = parteDominioEmpleadoRepository;
    }

    @GetMapping
    public List<ParteDominioEmpleado> getAll(){
        return parteDominioEmpleadoRepository.findAll();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<ParteDominioEmpleado> getById(@PathVariable Long id){
        return  parteDominioEmpleadoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.ok().build());
    }

    @PostMapping
    public ParteDominioEmpleado insertParteDominioEmpleado(
            @RequestBody ParteDominioEmpleado parteDominioEmpleado){
        return parteDominioEmpleadoRepository.save(parteDominioEmpleado);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<ParteDominioEmpleado> updateParteDominioEmpleado(
            @PathVariable Long id, @RequestBody ParteDominioEmpleado parteDominioEmpleado
    ){
        return parteDominioEmpleadoRepository.findById(id)
                .map(existing -> {
                    existing.setEmpleado(parteDominioEmpleado.getEmpleado());
                    existing.setDominio(parteDominioEmpleado.getDominio());
                    existing.setParte(parteDominioEmpleado.getParte());
                    return ResponseEntity.ok(parteDominioEmpleadoRepository.save(existing));
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteParteDominioEmpleado(@PathVariable Long id){
        if (!parteDominioEmpleadoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        parteDominioEmpleadoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
