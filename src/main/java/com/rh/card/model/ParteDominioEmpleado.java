package com.rh.card.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ParteDominioEmpleado {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idParteDominioEmpleado;

    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_parte", nullable = false)
    private Parte parte;

    @ManyToOne
    @JoinColumn(name = "id_dominio", nullable = false)
    private Dominio dominio;
}
