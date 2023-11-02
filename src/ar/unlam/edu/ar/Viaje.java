package ar.unlam.edu.ar;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Viaje {

	private LocalDateTime salida;
	private LocalDateTime llegada;
	private String origen;
	private String destino;
	private MedioTransporte medioTransporte;
	private Set<Pasajero>pasajeros;

	public Viaje(LocalDateTime salida, LocalDateTime llegada, String origen, String destino,
			MedioTransporte medioTransporte) {
		super();
		this.salida = salida;
		this.llegada = llegada;
		this.origen = origen;
		this.destino = destino;
		this.medioTransporte = medioTransporte;
		this.pasajeros=new HashSet<>();
	}

	public LocalDateTime getSalida() {
		return salida;
	}

	public void setSalida(LocalDateTime salida) {
		this.salida = salida;
	}

	public LocalDateTime getLlegada() {
		return llegada;
	}

	public void setLlegada(LocalDateTime llegada) {
		this.llegada = llegada;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public MedioTransporte getMedioTransporte() {
		return medioTransporte;
	}

	public void setMedioTransporte(MedioTransporte medioTransporte) {
		this.medioTransporte = medioTransporte;
	}

	public void agregarPasajero(Pasajero pasajero) {
		pasajeros.add(pasajero);
	}

	public Set<Pasajero> getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(Set<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}
	
}
