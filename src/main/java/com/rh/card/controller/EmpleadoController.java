package com.rh.card.controller;

import com.rh.card.model.Empleado;
import com.rh.card.repository.EmpleadoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping ("/api/empleado")
@CrossOrigin (origins = "*")
public class EmpleadoController {
    private EmpleadoRepository empleadoRepository;

    public EmpleadoController(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @GetMapping
    public List<Empleado> getAll(){
        return empleadoRepository.findAll();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Empleado> getById(@PathVariable Long id){
        return empleadoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Empleado> updateEmpleado(@PathVariable Long id, @RequestBody Empleado empleado){
        return empleadoRepository.findById(id)
                .map(existing -> {
                    existing.setActivo(empleado.isActivo());
                    existing.setNombreEmpleado(empleado.getNombreEmpleado());
                    existing.setFechaIngreso(empleado.getFechaIngreso());
                    existing.setRutaFoto(empleado.getRutaFoto());
                    existing.setFechaRenovacion(empleado.getFechaRenovacion());
                    existing.setIdDepartamento(empleado.getIdDepartamento());

                    return ResponseEntity.ok(empleadoRepository.save(existing));
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable Long id){
        if (!empleadoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        empleadoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
