package com.rh.card.repository;

import com.rh.card.model.ParteDominioEmpleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParteDominioEmpleadoRepository extends JpaRepository<ParteDominioEmpleado, Long> {
}
