package com.rh.card.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class HabilidadDominioEmpleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habilidad_empleado")
    private Long idHabilidadDominioEmpleado;

    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_habilidad", nullable = false)
    private Habilidad habilidad;

    @ManyToOne
    @JoinColumn(name = "id_dominio", nullable = false)
    private Dominio dominio;
}
