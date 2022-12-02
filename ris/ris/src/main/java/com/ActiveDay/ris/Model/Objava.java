package com.ActiveDay.ris.Model;

public abstract class Objava {
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
}