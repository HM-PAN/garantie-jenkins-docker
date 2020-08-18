package com.app.assurance.dao;

import com.app.assurance.entities.PGarantie;

import java.util.List;
import java.util.Optional;

public interface PGarantieDao {

    public PGarantie add(PGarantie pgarantie);
    public PGarantie update (PGarantie pgarantie);
    public Optional<PGarantie> getOne(String idG);
    public List<PGarantie> findAll();
    public void delete(String idG);
    public boolean exists (String id);
    public Long counter ();






    /**
     * public List<Rround> findAllCurrentRound();
     * 	public List<Rround> findAllClosedRound();
     *     public Optional<Rround> findById(Long id);
     *     public Rround Create(Rround rround);
     *     public void Delete (Long id);
     *     public Rround Update(Rround rround);
     * 	public boolean exists(Long rndid);
     * 	**/
}
