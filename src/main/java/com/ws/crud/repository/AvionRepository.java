package com.ws.crud.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ws.crud.interfaces.CustomRepository;
import com.ws.crud.model.Avion;

@Repository
public interface AvionRepository extends JpaRepository<Avion, Long>{

	public List<Avion> findByAssuranceGreaterThanAndAssuranceLessThan(Date assurance1, Date assurance2);
}
