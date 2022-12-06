package com.ActiveDay.ris.Model;

import jakarta.persistence.*;

@Entity
public class Ocena extends Objava {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int ocena;

	public Ocena(int ocena) {
		throw new UnsupportedOperationException();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public int getOcena() {
		return this.ocena;
	}
}