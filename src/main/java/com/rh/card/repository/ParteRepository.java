package com.rh.card.repository;

import com.rh.card.model.Parte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParteRepository extends JpaRepository<Parte, Long> {
}
