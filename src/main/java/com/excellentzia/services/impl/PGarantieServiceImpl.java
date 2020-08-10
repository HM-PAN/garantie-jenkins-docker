package com.excellentzia.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excellentzia.models.PGarantie;
import com.excellentzia.repository.IPGarantieDao;
import com.excellentzia.service.IPGarantieService;
@Service
public class PGarantieServiceImpl implements IPGarantieService {
		@Autowired
		
	private	IPGarantieDao dao ;

		@Override
	public PGarantie add(PGarantie t) {
		dao.save(t);		
		return t;
	}

	@Override
	public PGarantie update(PGarantie t) {
		dao.save(t);
		return t;
	}

	@Override
	public PGarantie getOne(String id) {
		// TODO Auto-generated method stub
		
		return dao.findById(id).get();
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
