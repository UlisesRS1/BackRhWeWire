package com.rh.card.repository;

import com.rh.card.model.HabilidadDominioEmpleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadDominioEmpleadoRepository extends JpaRepository<HabilidadDominioEmpleado, Long> {
}
