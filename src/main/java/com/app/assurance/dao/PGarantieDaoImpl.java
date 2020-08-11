package com.excellentzia.dao;

import com.excellentzia.entities.PGarantie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PGarantieDaoImpl implements PGarantieDao {
    @Autowired
    private PGarantieRepository dao ;

    @Override
    public PGarantie add(PGarantie t) {
        return dao.save(t);
    }

    @Override
    public PGarantie update(PGarantie t) {
        dao.save(t);
        return t;
    }

    @Override
    public Optional<PGarantie>  getOne(String id) {
        // TODO Auto-generated method stub

        return dao.findById(id);
    }

    @Override
    public List<PGarantie> findAll() {
        // TODO Auto-generated method stub
        return dao.findAll();
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        dao.deleteById(id);
    }

    @Override
    public boolean exists(String id) {
        // TODO Auto-generated method stub
        return dao.existsById(id);
    }

    @Override
    public Long counter() {
        // TODO Auto-generated method stub
        return dao.count();
    }


}
