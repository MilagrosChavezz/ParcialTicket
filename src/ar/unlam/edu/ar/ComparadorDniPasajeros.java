package ar.unlam.edu.ar;

import java.util.Comparator;

public class ComparadorDniPasajeros implements Comparator<Pasajero> {

	@Override
	public int compare(Pasajero o1, Pasajero o2) {
		// TODO Auto-generated method stub
		return o2.getDni().compareTo(o1.getDni());
	}

}
