package com.ActiveDay.ris.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public abstract class Objava {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private long casObjave;
	private boolean javno = false;

	//to se naredi al?
	//@ManyToOne(fetch = FetchType.LAZY) @JOINColumn(name = "uporabnik.id") @ONDelete(action = OnDeleteAction.CASCADE) @JsonIgnore
	private Uporabnik avtor;

	public Objava() {
		throw new UnsupportedOperationException();
	}

	public Objava(long casObjave, Uporabnik avtor) {
		throw new UnsupportedOperationException();
	}

	public Objava(long casObjave, Uporabnik avtor, boolean javno) {
		throw new UnsupportedOperationException();
	}

	public long getCasObjave() {
		return this.casObjave;
	}

	public void setJavno(boolean javno) {
		this.javno = javno;
	}

	public boolean isJavno() {
		return this.javno;
	}

	public void setId(Long id) { this.id = id; }

    public Long getId() { return id; }
}