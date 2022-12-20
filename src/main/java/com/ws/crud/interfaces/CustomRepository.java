package com.ws.crud.interfaces;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

import com.ws.crud.model.Avion;

public interface CustomRepository{
	public List<Avion> findByAssuranceGreaterThanAndAssuranceLessThan(Date assurance1, Date assurance2);
}
