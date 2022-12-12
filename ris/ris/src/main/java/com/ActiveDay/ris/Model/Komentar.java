package com.ActiveDay.ris.Model;

import jakarta.persistence.*;

@Entity
public class Komentar extends Objava {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String naslov;
	private String vsebina;

	public Komentar(){}

	public Komentar(String vsebina) {
		throw new UnsupportedOperationException();
	}

	public Komentar(String naslov, String vsebina) {
		throw new UnsupportedOperationException();
	}

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

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