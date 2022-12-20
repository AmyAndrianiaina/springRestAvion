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
	@Column(name = "numero")
	private String numero;
	@Column(name = "marque")
	private String marque;
	@Column(name = "model")
	private String model;
	@Column(name = "assurance")
	private Date assurance;
	@Column(name = "dateentretien")
	private Date dateEntretien;
	@Column(name = "km")
	private int km;

	public Avion() {
		super();
	}

	public Avion(Date assurance, Date dateEntretien, int km, String numero, String marque, String model) {
		super();
		this.numero = numero;
		this.marque = marque;
		this.model = model;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Date getAssurance() {
		return assurance;
	}

	public void setAssurance(Date assurance) {
		this.assurance = assurance;
	}

	public Date getDateEntretien() {
		return dateEntretien;
	}

	public void setDateEntretien(Date dateEntretien) {
		this.dateEntretien = dateEntretien;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

}
