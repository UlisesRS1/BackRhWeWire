package com.rh.card.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Dominio {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idDominio;
    private int nivel;
    private String descripcionDominio;

}
