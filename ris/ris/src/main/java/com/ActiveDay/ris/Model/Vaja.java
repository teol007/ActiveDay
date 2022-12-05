package com.ActiveDay.ris.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vaja {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String naziv;
	private String opis;
	private int stPonovitev = 1;
	private long casTrajanja;
	private boolean stanje = false;

	public Vaja() {} //More bit,da se bo lahko objekt sploh shrano iz JSON-a (pa neke za serializacijo je se bil error)

	public Vaja(String naziv) {
		throw new UnsupportedOperationException();
	}

	public Vaja(String naziv, String opis) {
		throw new UnsupportedOperationException();
	}

	public Vaja(String naziv, int stPonovitev) {
		throw new UnsupportedOperationException();
	}

	public Vaja(String naziv, long casTrajanja) {
		throw new UnsupportedOperationException();
	}

	public Vaja(String naziv, int stPonovitev, long casTrajanja) {
		throw new UnsupportedOperationException();
	}

	public Vaja(String naziv, String opis, int stPonovitev) {
		throw new UnsupportedOperationException();
	}

	public Vaja(String naziv, String opis, long casTrajanja) {
		throw new UnsupportedOperationException();
	}

	public Vaja(String naziv, String opis, int stPonovitev, long casTrajanja) {
		throw new UnsupportedOperationException();
	}

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getOpis() {
		return this.opis;
	}

	public void setStPonovitev(int stPonovitev) {
		this.stPonovitev = stPonovitev;
	}

	public int getStPonovitev() {
		return this.stPonovitev;
	}

	public void setCasTrajanja(long casTrajanja) {
		this.casTrajanja = casTrajanja;
	}

	public long getCasTrajanja() {
		return this.casTrajanja;
	}

	public void setStanje(boolean stanje) {
		this.stanje = stanje;
	}

	public boolean getStanje() {
		return this.stanje;
	}
}