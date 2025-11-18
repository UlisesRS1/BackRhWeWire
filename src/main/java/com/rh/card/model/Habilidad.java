package com.rh.card.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table (name = "habilidad")
public class Habilidad {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idHabilidad;
    private String nombreHabilidad;
}
