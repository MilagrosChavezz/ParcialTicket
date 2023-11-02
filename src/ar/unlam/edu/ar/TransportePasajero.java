package ar.unlam.edu.ar;

public class TransportePasajero extends MedioTransporte implements ITransportable{

	private Integer cantidadDePasajerosMaximo;
	
	
	public TransportePasajero(String patente , Integer cantidadPasajeros) {
		super(patente);
		// TODO Auto-generated constructor stub
		this.cantidadDePasajerosMaximo=cantidadPasajeros;
	}


	public Integer getCantidadDePasajerosMaximo() {
		return cantidadDePasajerosMaximo;
	}


	public void setCantidadDePasajerosMaximo(Integer cantidadDePasajerosMaximo) {
		this.cantidadDePasajerosMaximo = cantidadDePasajerosMaximo;
	}


	@Override
	public Integer obtenerCantidadMaximaPasajero() {
		// TODO Auto-generated method stub
		return cantidadDePasajerosMaximo;
	}

	
	
}
