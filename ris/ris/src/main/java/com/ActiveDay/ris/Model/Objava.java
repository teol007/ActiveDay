package com.ActiveDay.ris.Model;

import org.hibernate.annotations.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public abstract class Objava {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private long casObjave;
	private boolean javno = false;

	@ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "uporabnik.id") @OnDelete(action = OnDeleteAction.CASCADE) @JsonIgnore
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