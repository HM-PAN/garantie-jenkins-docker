package com.excellentzia.dao;

import com.excellentzia.entities.PGarantie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PGarantieRepository extends JpaRepository<PGarantie, String> {
}
