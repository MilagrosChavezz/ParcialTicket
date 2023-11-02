package ar.unlam.edu.ar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.TreeSet;

import org.junit.Test;

public class TestComaniaTransporte {

	@Test
	public void queSePuedaRegistrarUnViaje() {

		// No modificar este test.
		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";

		Integer cantidadPasajerosMaximos = 50;
		MedioTransporte medioTransporte = new TransportePasajero(Patente, cantidadPasajerosMaximos);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);

		empresa.registrarViaje(viaje);

		Boolean valorObtenido = empresa.getViajes().containsValue(viaje);
		assertTrue(valorObtenido);

	}

	@Test
	public void queSePuedaRegistrarUnTicketDePasajeroAUnViaje()
			throws CantidadPasajeroSobrepasadaException, TipoTicketInvalidoExcption, ViajeInexistente {

		// No modificar este test.
		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";

		Integer cantidadPasajerosMaximos = 50;
		MedioTransporte medioTransporte = new TransportePasajero(Patente, cantidadPasajerosMaximos);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);

		empresa.registrarViaje(viaje);

		Integer numeroViaje = 1;
		Integer dni = 2222;
		String apellido = "perez";
		Pasajero pasajero = new Pasajero(dni, apellido);
		empresa.registrarTicketPasajero(numeroViaje, pasajero);

		// Completar Test

	}

	@Test(expected = TipoTicketInvalidoExcption.class)
	public void queAlRegistrarUnTicketDePasajeroAUnViajeConMedioDeTransporteDeCargaLanceUnaException()
			throws CantidadPasajeroSobrepasadaException, TipoTicketInvalidoExcption, ViajeInexistente {

		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";

		Double cargaMaxima = 50.0;
		MedioTransporte medioTransporte = new TransporteCarga(Patente, cargaMaxima);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);

		empresa.registrarViaje(viaje);

		Integer numeroViaje = 1;

		Integer dni = 2222;
		String apellido = "perez";
		Pasajero pasajero = new Pasajero(dni, apellido);
		empresa.registrarTicketPasajero(numeroViaje, pasajero);

		// Completar test

	}

	@Test
	public void queSePuedaRegistrarUnTicketDeCargaAUnViaje()
			throws TipoTicketInvalidoExcption, CapacidadExcedidaException, ViajeInexistente {

		// No modificar este test.
		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";

		Double cargaMaxima = 50.0;
		MedioTransporte medioTransporte = new TransporteCarga(Patente, cargaMaxima);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);
		empresa.registrarViaje(viaje);

		Integer numeroViaje = 1;
		empresa.registrarTicketcarga(numeroViaje, new Carga(1, 10.0));
		// Completar Test

	}

	@Test
	public void queSePuedaRegistrarUnTicketMixtoAUnViaje() throws CantidadPasajeroSobrepasadaException,
			TipoTicketInvalidoExcption, CapacidadExcedidaException, ViajeInexistente {

		// No modificar este test.
		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";

		Double cargaMaxima = 50.0;

		Integer cantidadPasajerosMaximos = 50;

		MedioTransporte medioTransporte = new TransporteMixto(Patente, cantidadPasajerosMaximos, cargaMaxima);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);

		empresa.registrarViaje(viaje);

		Integer numeroViaje = 1;
		Integer dni = 2222;
		String apellido = "perez";
		Pasajero pasajero = new Pasajero(dni, apellido);
		Carga carga = new Carga(1, 10.0);
		empresa.registrarTicketMixto(numeroViaje, pasajero, carga);

	}

	@Test(expected = CapacidadExcedidaException.class)
	public void queAlRegistrarUnticketYExcedalaCargaMaximaDelTransporteLanceUnaExceptionCapacidadExcedidaException()
			throws CantidadPasajeroSobrepasadaException, TipoTicketInvalidoExcption, CapacidadExcedidaException,
			ViajeInexistente {
		// Desarrollar test

		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";

		Double cargaMaxima = 50.0;

		Integer cantidadPasajerosMaximos = 50;

		MedioTransporte medioTransporte = new TransporteMixto(Patente, cantidadPasajerosMaximos, cargaMaxima);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);

		empresa.registrarViaje(viaje);

		Integer numeroViaje = 1;
		Integer dni = 2222;
		String apellido = "perez";
		Pasajero pasajero = new Pasajero(dni, apellido);
		Carga carga = new Carga(1, 60.0);
		empresa.registrarTicketMixto(numeroViaje, pasajero, carga);
	}

	@Test
	public void queSePuedaObtenerUnaListaPasajeroDeUnViajeOrdenadoPorDNIDescendiente()
			throws CantidadPasajeroSobrepasadaException, TipoTicketInvalidoExcption, CapacidadExcedidaException,
			ViajeInexistente {
		// Desarrollar test
		// Debe invcar el Metodo obtenerListaPasajeroOrdenadosPorDNIDescendiente(Integer
		// numeroViaje) y este retorna un Treeset <Pasajero>

		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";

		Double cargaMaxima = 50.0;

		Integer cantidadPasajerosMaximos = 50;

		MedioTransporte medioTransporte = new TransporteMixto(Patente, cantidadPasajerosMaximos, cargaMaxima);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);

		empresa.registrarViaje(viaje);

		Integer numeroViaje = 1;
		Integer dni4 = 4444;
		String apellido4 = "perez";
		Pasajero pasajero4 = new Pasajero(dni4, apellido4);

		Integer dni1 = 1111;
		String apellido1 = "perez";
		Pasajero pasajero1 = new Pasajero(dni1, apellido1);

		Integer dni3 = 3333;
		String apellido3 = "perez";
		Pasajero pasajero3 = new Pasajero(dni3, apellido3);

		Integer dni = 2222;
		String apellido = "perez";
		Pasajero pasajero = new Pasajero(dni, apellido);
		Carga carga = new Carga(1, 10.0);

		empresa.registrarTicketMixto(numeroViaje, pasajero4, carga);
		empresa.registrarTicketMixto(numeroViaje, pasajero3, carga);
		empresa.registrarTicketMixto(numeroViaje, pasajero1, carga);
		empresa.registrarTicketMixto(numeroViaje, pasajero, carga);

		TreeSet<Pasajero> listaO = empresa.obtenerListaPasajeroOrdenadosPorDNIDescendiente(numeroViaje);
		Integer dniEsperadoPrimerP = listaO.first().getDni();
		Integer dniEsperadoUltimoP = listaO.last().getDni();

		assertEquals(dni4, dniEsperadoPrimerP);
		assertEquals(dni1, dniEsperadoUltimoP);
	}

	@Test
	public void queSePuedaObtenerElTotalDeCargasTransportada() throws CantidadPasajeroSobrepasadaException,
			TipoTicketInvalidoExcption, CapacidadExcedidaException, ViajeInexistente {
		// Desarrollar test

		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";

		Double cargaMaxima = 50.0;

		Integer cantidadPasajerosMaximos = 50;

		MedioTransporte medioTransporte = new TransporteMixto(Patente, cantidadPasajerosMaximos, cargaMaxima);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);

		empresa.registrarViaje(viaje);

		Integer numeroViaje = 1;
		Integer dni4 = 4444;
		String apellido4 = "perez";
		Pasajero pasajero4 = new Pasajero(dni4, apellido4);

		Integer dni1 = 1111;
		String apellido1 = "perez";
		Pasajero pasajero1 = new Pasajero(dni1, apellido1);

		Integer dni3 = 3333;
		String apellido3 = "perez";
		Pasajero pasajero3 = new Pasajero(dni3, apellido3);

		Integer dni = 2222;
		String apellido = "perez";
		Pasajero pasajero = new Pasajero(dni, apellido);
		Carga carga = new Carga(1, 40.0);

		empresa.registrarTicketMixto(numeroViaje, pasajero4, carga);
		empresa.registrarTicketMixto(numeroViaje, pasajero3, carga);
		empresa.registrarTicketMixto(numeroViaje, pasajero1, carga);
		empresa.registrarTicketMixto(numeroViaje, pasajero, carga);

		Double vo = empresa.obtenerELTotalDeCargaTransportadaEnTodosLosViajes();
		Double ve = 160.0;

		assertEquals(ve, vo, 0.01);

	}

	@Test
	public void queSePuedaObtenerElTotalDeCargasTransportadaEnMixto() throws CantidadPasajeroSobrepasadaException,
			TipoTicketInvalidoExcption, CapacidadExcedidaException, ViajeInexistente {
		// Desarrollar test

		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";

		Double cargaMaxima = 50.0;

		MedioTransporte medioTransporte = new TransporteCarga(Patente, cargaMaxima);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);

		empresa.registrarViaje(viaje);

		Integer numeroViaje = 1;

		Carga carga = new Carga(1, 40.0);

		empresa.registrarTicketcarga(numeroViaje, carga);
		empresa.registrarTicketcarga(numeroViaje, carga);
		empresa.registrarTicketcarga(numeroViaje, carga);
		empresa.registrarTicketcarga(numeroViaje, carga);

		Double vo = empresa.obtenerELTotalDeCargaTransportadaEnTodosLosViajes();
		Double ve = 160.0;

		assertEquals(ve, vo, 0.01);

	}
}
