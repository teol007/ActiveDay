package com.ActiveDay.ris.Model;

public class Komentar extends Objava {
	private String naslov;
	private String vsebina;

	public Komentar(String vsebina) {
		throw new UnsupportedOperationException();
	}

	public Komentar(String naslov, String vsebina) {
		throw new UnsupportedOperationException();
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getNaslov() {
		return this.naslov;
	}

	public void setVsebina(String vsebina) {
		this.vsebina = vsebina;
	}

	public String getVsebina() {
		return this.vsebina;
	}
}