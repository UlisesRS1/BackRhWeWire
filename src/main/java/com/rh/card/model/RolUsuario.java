package com.rh.card.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table (name = "rol_usuario")
public class RolUsuario {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idRolUsuario;
    private String rol;
}
