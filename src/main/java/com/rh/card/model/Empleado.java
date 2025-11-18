package com.rh.card.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Empleado {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idEmpleado;
    private Long idDepartamento;
    private String nombreEmpleado;
    private LocalDate fechaIngreso;
    private LocalDate fechaRenovacion;
    private boolean activo;
    private String rutaFoto;
}
