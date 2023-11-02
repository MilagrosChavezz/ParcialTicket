package ar.unlam.edu.ar;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Empresa {

	private String nombre;
	private Map<Integer, Viaje> viajes;

	// Se registran todas las ventas de pasajes de los pasajeros
	private Set<Ticket> tickets;
	private Double totalCarga = 0.0;

	public Empresa(String nombre) {
		this.nombre = nombre;
		this.viajes = new HashMap<>();
		this.tickets = new HashSet<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Map<Integer, Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(Map<Integer, Viaje> viajes) {
		this.viajes = viajes;
	}

	/*
	 * Registra Un Nuevo viaje se debe guardar en un mapa donde la Key es un entero
	 * y es autoincremental arrancando de 0
	 */

	public Integer idSiguiente() {

		Integer numeroMaximo = 0;
		for (Map.Entry<Integer, Viaje> entry : viajes.entrySet()) {
			Integer key = entry.getKey();
			Viaje val = entry.getValue();
			if (key > numeroMaximo) {
				numeroMaximo = key;
			}
		}
		return numeroMaximo + 1;
	}

	public Integer idSiguienteTicket() {

		Integer numeroMaximo = 0;
		for (Ticket ticket : tickets) {
			if (numeroMaximo < ticket.getId()) {
				numeroMaximo = ticket.getId();
			}
		}

		return numeroMaximo + 1;
	}

	public void registrarViaje(Viaje viaje) {
		viajes.put(idSiguiente(), viaje);

	}

	/*
	 * Registra Un ticket para carga TicketCarga.class Si el viaje no admite Carga
	 * lanza TipoTicketInvalidoExcption si supera El peso maximo que soporta el
	 * medioTransprte Lanza Una exception CapacidadExcedidaException
	 */

	public Viaje buscarViaje(Integer id) throws ViajeInexistente {
		Viaje viajeBuscado = null;
		for (Map.Entry<Integer, Viaje> entry : viajes.entrySet()) {
			Integer key = entry.getKey();
			Viaje val = entry.getValue();
			if (key.equals(id)) {
				viajeBuscado = val;
				return viajeBuscado;
			}

		}
		throw new ViajeInexistente();
	}

	public Boolean admiteCarga(Integer id) throws TipoTicketInvalidoExcption, ViajeInexistente {
		Viaje viajeBuscado = buscarViaje(id);
		if (viajeBuscado.getMedioTransporte() instanceof iCargable) {
			return true;
		}
		throw new TipoTicketInvalidoExcption();
	}

	public Boolean soportaPesoMax(Integer id, Carga carga) throws CapacidadExcedidaException, ViajeInexistente {
		MedioTransporte viajeBuscado = buscarViaje(id).getMedioTransporte();
		if (((iCargable) viajeBuscado).obtenerCantidadMaximaCarga() > carga.getPeso()) {
			return true;
		}
		throw new CapacidadExcedidaException();
	}

	public void registrarTicketcarga(Integer numeroViaje, Carga carga)
			throws TipoTicketInvalidoExcption, CapacidadExcedidaException, ViajeInexistente {
		// TODO Auto-generated method stub
		if (admiteCarga(numeroViaje) && soportaPesoMax(numeroViaje, carga)) {
			tickets.add(new TicketCarga(idSiguienteTicket()));
			totalCarga+= carga.getPeso();
		}

	}

	/*
	 * Se registra un TicketPasajero TicketPasajero Si el viaje no admite pasajeros
	 * lanza TipoTicketInvalidoExcption si supera la cantidad de pasajero que
	 * soporta el medioTransprte Lanza Una exception
	 * CantidadPasajeroSobrepasadaException
	 */

	public Boolean viajeAdmitePasajero(Integer numeroViaje) throws TipoTicketInvalidoExcption, ViajeInexistente {
		MedioTransporte v = buscarViaje(numeroViaje).getMedioTransporte();
		if (v instanceof ITransportable) {
			return true;
		}
		throw new TipoTicketInvalidoExcption();
	}

	public Boolean noSobrepasaCantidadP(Integer numeroViaje)
			throws CantidadPasajeroSobrepasadaException, TipoTicketInvalidoExcption, ViajeInexistente {
		Viaje v = buscarViaje(numeroViaje);
		MedioTransporte v2 = buscarViaje(numeroViaje).getMedioTransporte();
		if (viajeAdmitePasajero(numeroViaje)
				&& v.getPasajeros().size() < ((ITransportable) v2).obtenerCantidadMaximaPasajero()) {
			return true;
		}
		throw new CantidadPasajeroSobrepasadaException();
	}

	public void registrarTicketPasajero(Integer numeroViaje, Pasajero pasajero)
			throws CantidadPasajeroSobrepasadaException, TipoTicketInvalidoExcption, ViajeInexistente {
		// TODO Auto-generated method stub
		if (noSobrepasaCantidadP(numeroViaje) && viajeAdmitePasajero(numeroViaje)) {
			tickets.add(new TicketPasajero(idSiguienteTicket()));
			buscarViaje(numeroViaje).agregarPasajero(pasajero);
		}
	}

	/*
	 * Se registra un TicketMixto TicketMixto.class si supera la cantidad de
	 * pasajero que soporta el medioTransprte Lanza Una exception
	 * CantidadPasajeroSobrepasadaException si supera El peso maximo que soporta el
	 * medioTransprte Lanza Una exception CapacidadExcedidaException
	 */

	public void registrarTicketMixto(Integer numeroViaje, Pasajero pasajero, Carga carga)
			throws CantidadPasajeroSobrepasadaException, TipoTicketInvalidoExcption, CapacidadExcedidaException,
			ViajeInexistente {
		// TODO Auto-generated method stub
		if (noSobrepasaCantidadP(numeroViaje) && soportaPesoMax(numeroViaje, carga)) {
			tickets.add(new TicketMixto(idSiguienteTicket()));
			buscarViaje(numeroViaje).agregarPasajero(pasajero);
			totalCarga+= carga.getPeso();
		}
	}

	/*
	 * retorna la lista de pasajero enforma Descendiente Lanza una exception si el
	 * viaje no existe o si el tipo de viaje No es compatible para trnssporte de
	 * pasajero lanza una exception si el viaje no existe
	 */

	public TreeSet<Pasajero> obtenerListaPasajeroOrdenadosPorDNIDescendiente(Integer numeroViaje)
			throws TipoTicketInvalidoExcption, ViajeInexistente {

		TreeSet<Pasajero> ordenadosPorDniDescendente = new TreeSet<>(new ComparadorDniPasajeros());

		if (viajeAdmitePasajero(numeroViaje)) {
			ordenadosPorDniDescendente.addAll(buscarViaje(numeroViaje).getPasajeros());

		}

		return ordenadosPorDniDescendente;
	}

	public Double obtenerELTotalDeCargaTransportadaEnTodosLosViajes() {

		return totalCarga;
	}

}
