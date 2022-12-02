package com.ActiveDay.ris.Model;

import java.util.ArrayList;

public class Uporabnik {
	private String ime;
	private String priimek;
	private String uporabniskoIme;
	private String email;
	private String geslo;
	private Arhiv arhiv;
	private ArrayList<Objava> objave = new ArrayList<Objava>();

	public void ustvariObjavo(Objava objava) {
		throw new UnsupportedOperationException();
	}

	public void izbrisiObjavo(Objava objava) {
		throw new UnsupportedOperationException();
	}

	public Uporabnik(String email) {
		throw new UnsupportedOperationException();
	}

	public Uporabnik(String ime, String priimek, String uporabniskoIme, String email, String geslo) {
		throw new UnsupportedOperationException();
	}

	public void setArhiv(Arhiv arhiv) {
		this.arhiv = arhiv;
	}

	public Arhiv getArhiv() {
		return this.arhiv;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getIme() {
		return this.ime;
	}

	public void setPriimek(String priimek) {
		this.priimek = priimek;
	}

	public String getPriimek() {
		return this.priimek;
	}

	public void setUporabniskoIme(String uporabniskoIme) {
		this.uporabniskoIme = uporabniskoIme;
	}

	public String getUporabniskoIme() {
		return this.uporabniskoIme;
	}

	public String getEmail() {
		return this.email;
	}

	public void setGeslo(String geslo) {
		this.geslo = geslo;
	}

	public String getGeslo() {
		return this.geslo;
	}
}