package com.rh.card.repository;

import com.rh.card.model.RolUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolUsuariorepository extends JpaRepository<RolUsuario, Long> {
}
