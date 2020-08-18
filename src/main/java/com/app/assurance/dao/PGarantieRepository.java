package com.app.assurance.dao;

import com.app.assurance.entities.PGarantie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PGarantieRepository extends JpaRepository<PGarantie, String> {
}
