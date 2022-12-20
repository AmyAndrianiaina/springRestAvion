package com.ws.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "avion")
public class Avion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "assurance")
	private Date assurance;
	@Column(name = "dateentretien")
	private Date dateEntretien;
	@Column(name = "km")
	private int km;

	public Avion() {
		super();
	}

	public Avion(Date assurance, Date dateEntretien, int km) {
		super();
		this.assurance = assurance;
		this.dateEntretien = dateEntretien;
		this.km = km;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getAssurance() {
		return assurance;
	}

	public void setAssurance(Date assurance) {
		this.assurance = assurance;
	}

	public Date getdateEntretien() {
		return dateEntretien;
	}

	public void setdateEntretien(Date dateEntretien) {
		this.dateEntretien = dateEntretien;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

}
