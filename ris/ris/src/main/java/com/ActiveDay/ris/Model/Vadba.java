package com.ActiveDay.ris.Model;

import java.util.ArrayList;

public class Vadba extends Objava {
	private String naziv;
	private int stIntervalov = 1;
	private boolean stanje = false;
	private ArrayList<Vaja> vaje = new ArrayList<Vaja>();
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