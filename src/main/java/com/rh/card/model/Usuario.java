package com.rh.card.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private Long idRolUsuario;
    private String usuario;
    private String contraseña;
}
