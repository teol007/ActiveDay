package com.ActiveDay.ris.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import org.hibernate.annotations.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.CascadeType;

@Entity
public class Arhiv {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	//mappedBy = "vadba" ne deluje
	@OneToMany(mappedBy = "", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Vadba> vadbe = new ArrayList<Vadba>();

	public void dodajVadbo(Vadba vadba) {
		throw new UnsupportedOperationException();
	}

	public void izvediVadbo(Vadba vadba) {
		throw new UnsupportedOperationException();
	}

	public void kopirajVadbo(Vadba vadba) {
		throw new UnsupportedOperationException();
	}

	public void odstraniVadbo(Vadba vadba) {
		throw new UnsupportedOperationException();
	}

	public Arhiv() {
		// throw new UnsupportedOperationException(); //to more bit zakomentirano, ker springboot ne zna inicializirat drugac
	}

	public Long getId() { return id; }

	public void setId(Long id) { this.id = id; }

	public List<Vadba> getVadbe() {
		return vadbe;
	}

	public void setVadbe(List<Vadba> vadbe) {
		this.vadbe = vadbe;
	}

	public void addVadbe(Vadba vadbe) {
		this.vadbe.add(vadbe);
	}

	public void removeVadbe(Vadba vadbe) {
		this.vadbe.remove(vadbe);
	}

	public Vadba[] toVadbeArray() {
		Vadba[] vadbe_Temp = new Vadba[this.vadbe.size()];
		this.vadbe.toArray(vadbe_Temp);
		return vadbe_Temp;
	}
}