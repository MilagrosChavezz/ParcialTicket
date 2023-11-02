package ar.unlam.edu.ar;

public class TransporteMixto extends MedioTransporte implements iCargable, ITransportable {

	/*
	 * No se pueden agregar mas Atributos
	 */
	private Integer cantidadPasajerosMaximos;
	private Double cargaMaxima;

	public TransporteMixto(String patente, Integer cantidadPasajerosMaximos, Double cargaMaxima) {
		super(patente);
		// TODO Auto-generated constructor stub
		this.cantidadPasajerosMaximos = cantidadPasajerosMaximos;
		this.cargaMaxima = cargaMaxima;
	}

	public Integer getCantidadPasajerosMaximos() {
		return cantidadPasajerosMaximos;
	}

	public void setCantidadPasajerosMaximos(Integer cantidadPasajerosMaximos) {
		this.cantidadPasajerosMaximos = cantidadPasajerosMaximos;
	}

	public Double getCargaMaxima() {
		return cargaMaxima;
	}

	public void setCargaMaxima(Double cargaMaxima) {
		this.cargaMaxima = cargaMaxima;
	}

	@Override
	public Integer obtenerCantidadMaximaPasajero() {
		// TODO Auto-generated method stub
		return cantidadPasajerosMaximos;
	}

	@Override
	public Double obtenerCantidadMaximaCarga() {
		// TODO Auto-generated method stub
		return cargaMaxima;
	}

}
