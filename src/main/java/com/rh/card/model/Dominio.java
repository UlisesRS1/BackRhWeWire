package com.rh.card.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table (name = "dominio")
public class Dominio {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idDominio;
    private int nivel;
    private String descripcionDominio;

}
