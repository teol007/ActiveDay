package com.ActiveDay.ris.Model;

import org.hibernate.annotations.*;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Objava {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private long casObjave = System.currentTimeMillis();
	private boolean javno = false;
	@ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "uporabnik.id") @OnDelete(action = OnDeleteAction.CASCADE) @JsonIgnore
	private Uporabnik avtor;

	public Objava() {} //More bit da se bo lahko objekt sploh shrano iz JSON-a

	@JsonCreator
	public Objava(@JsonProperty("casObjave") long casObjave, @JsonProperty("avtor") Uporabnik avtor) {
		throw new UnsupportedOperationException();
	}

	@JsonCreator
	public Objava(@JsonProperty("casObjave") long casObjave, @JsonProperty("avtor") Uporabnik avtor, @JsonProperty("javno") boolean javno) {
		throw new UnsupportedOperationException();
	}

	public void setId(Long id) { this.id = id; }

    public Long getId() { return id; }

	public long getCasObjave() {
		return this.casObjave;
	}

	public void setJavno(boolean javno) {
		this.javno = javno;
	}

	public boolean isJavno() {
		return this.javno;
	}

	public void setAvtor(Uporabnik avtor) {
		this.avtor = avtor;
	}

	public Uporabnik getAvtor() {
		return avtor;
	}
}