package com.ActiveDay.ris.Model;

import java.util.ArrayList;

public class Arhiv {
	private ArrayList<Vadba> vadbe = new ArrayList<Vadba>();

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
		throw new UnsupportedOperationException();
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