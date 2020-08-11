package com.excellentzia.services;

import com.excellentzia.dao.PGarantieDao;
import com.excellentzia.entities.PGarantie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PGarantieService {
    @Autowired
    private PGarantieDao PGarantie;

    public PGarantie add(PGarantie pgarantie) {
        return PGarantie.add(pgarantie);
    }

    public PGarantie update(PGarantie pgarantie) {
        return PGarantie.update(pgarantie);
    }

    public Optional<PGarantie> getOne(String idG) {
        return PGarantie.getOne(idG);
    }

    public List<PGarantie> findAll() {
        return PGarantie.findAll();
    }

    public void delete(String idG) {
        PGarantie.delete(idG);
    }

    public boolean exists(String id) {
        return PGarantie.exists(id);
    }

    public Long counter() {
        return PGarantie.counter();
    }
}
