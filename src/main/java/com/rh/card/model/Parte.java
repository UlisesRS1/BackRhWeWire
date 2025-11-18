package com.rh.card.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table (name = "parte")
public class Parte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idParte;
    private String nombreParte;
}
