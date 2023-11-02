package ar.unlam.edu.ar;

public class TransporteCarga extends MedioTransporte implements iCargable {

	private Double cantidadMaximaCarga;

	public TransporteCarga(String patente, Double cantidadMaximaCarga) {
		super(patente);
		// TODO Auto-generated constructor stub
		this.cantidadMaximaCarga = cantidadMaximaCarga;
	}

	@Override
	public Double obtenerCantidadMaximaCarga() {
		// TODO Auto-generated method stub
		return cantidadMaximaCarga;
	}

	public Double getCantidadMaximaCarga() {
		return cantidadMaximaCarga;
	}

	public void setCantidadMaximaCarga(Double cantidadMaximaCarga) {
		this.cantidadMaximaCarga = cantidadMaximaCarga;
	}

}
