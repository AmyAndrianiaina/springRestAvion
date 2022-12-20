package com.ws.crud.implementation;	

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ws.crud.interfaces.CustomRepository;
import com.ws.crud.model.Avion;
import com.ws.crud.repository.AvionRepository;

@Service("customRepositoryImpl")
public class CustomRepositoryImpl implements CustomRepository{
	
	@Autowired
	private AvionRepository avionRepository;

	@Transactional
	public List<Avion> findByAssuranceGreaterThanAndAssuranceLessThan(Date assurance1, Date assurance2) {
		List<Avion> response = (List<Avion>) avionRepository.findByAssuranceGreaterThanAndAssuranceLessThan(assurance1, assurance2);
		return response;
	}

}