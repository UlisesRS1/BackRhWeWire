package com.rh.card.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table (name = "empleado")
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
