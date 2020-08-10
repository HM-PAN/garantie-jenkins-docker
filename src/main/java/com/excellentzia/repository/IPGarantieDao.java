package com.excellentzia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excellentzia.models.PGarantie;

@Repository
public interface IPGarantieDao extends JpaRepository<PGarantie,String> {


}
