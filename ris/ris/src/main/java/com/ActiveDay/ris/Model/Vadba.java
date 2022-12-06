package com.ActiveDay.ris.Model;

import java.util.ArrayList;
import jakarta.persistence.*;

@Entity
public class Vadba extends Objava 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String naziv;
	private int stIntervalov = 1;
	private boolean stanje = false;
	//mappedBy = "vaja" ne deluje
	@OneToMany(mappedBy = "", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private ArrayList<Vaja> vaje = new ArrayList<Vaja>();
	//mappedBy = "objava" ne deluje
	@OneToMany(mappedBy = "", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private ArrayList<Objava> objave = new ArrayList<Objava>();

	public void dodajVajo(Vaja vaja) {
		throw new UnsupportedOperationException();
	}

	public void odstraniVajo(Vaja vaja) {
		throw new UnsupportedOperationException();
	}

	public Vadba(String naziv) {
		throw new UnsupportedOperationException();
	}

	public Vadba(String naziv, int stIntervalov) {
		throw new UnsupportedOperationException();
	}

	public Vadba(String naziv, boolean stanje) {
		throw new UnsupportedOperationException();
	}

	public Vadba(String naziv, int stIntervalov, boolean stanje) {
		throw new UnsupportedOperationException();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setStIntervalov(int stIntervalov) {
		this.stIntervalov = stIntervalov;
	}

	public int getStIntervalov() {
		return this.stIntervalov;
	}

	public void setStanje(boolean stanje) {
		this.stanje = stanje;
	}

	public boolean isStanje() {
		return this.stanje;
	}
}