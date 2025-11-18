package com.rh.card.repository;

import com.rh.card.model.Dominio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DominioRepository extends JpaRepository<Dominio, Long> {
}
