package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Test;

public class TestSistema {


	@Test
	public void testQueRegistroUnBanco() {
		Vigilancia vigilancia = new Vigilancia ("Vesure");
			
		Integer idbanco=1;
		Banco banco = new Banco(idbanco , "la Casa de Papel");
		
		vigilancia.agregarBanco (banco);
		
		assertEquals(idbanco, banco.getIdBanco());
	}
	
	@Test
	public void quePuedaRegistrarUnAtracador() throws Exception {
		
		Vigilancia vigilancia = new Vigilancia ("Nombre De la Compania de Vigilancia");
		Integer idbanda = 1;
		String nombre="La Casa de Papel";
		Banda banda = new Banda (idbanda,nombre);
		
		Integer dni= 1;
		nombre="Ursula";
		String apellido= "Corbero";
		String apodo="Tokio";
		
		//No Cambiar esta Linea
		Persona atracador = new Atracador (dni, nombre, apellido,apodo,banda,TipoDePersona.Atracador);
		vigilancia.registrarPersona (atracador);
		Integer valorEsperado = 1;
		Integer valorObtenido = vigilancia.getPersonas().size();
		//Compleatar el Assert
		assertEquals(valorEsperado,valorObtenido);
		
	}
	
	
	@Test(expected=PersonaDuplicadaException.class)
	public void queCuandoSeRegistre2PersonasConElMismoDNiLanceUnaExpcionPersonaDuplicadaException() throws Exception {
		Vigilancia vigilancia = new Vigilancia ("Nombre De la Compania de Vigilancia");
		//Creo Vigilante
		
		
		Persona vigilante = new Vigilante (1, "Pepito", "Pistolero", new Banco(1, "LA Casa De Papel"), TipoDePersona.Vigilante );
		vigilancia.registrarPersona (vigilante);
		//Creo Banda
		Integer idBanda = 1;
		String nombre="La Casa de Papel";
		Banda banda = new Banda (idBanda,nombre);
		//Creo Atracador
		Integer dni= 1;
		nombre="Ursula";
		String apellido= "Corbero";
		String apodo="Tokio";
		//No Cambiar esta Linea
		Persona atracador = new Atracador (dni, nombre, apellido,apodo,banda, TipoDePersona.Atracador );
		vigilancia.registrarPersona (atracador);
		 
	}
	

	@Test
	public void queSePuedaRegistraUnAtraco () throws Exception {
		
		Vigilancia vigilancia = new Vigilancia ("Nombre De la Compania de Vigilancia");
		Integer idBanda = 1;
		String nombre="La Casa de Papel";
		Banda banda = new Banda (idBanda,nombre);
		
		Integer dni= 1;
		nombre="Ursula";
		String apellido= "Corbero";
		String apodo="Tokio";
		
		//No Cambiar esta Linea
		Persona atracador = new Atracador (dni, nombre, apellido,apodo,banda, TipoDePersona.Atracador );
		vigilancia.registrarPersona (atracador);
		
		Integer idBanco=1;
		Banco banco = new Banco(idBanco, "la Casa de Papel");
		vigilancia.agregarBanco (banco);
		
		vigilancia.registrarAtraco(dni, idBanco);
		Integer valorEsperado=1;
		
		Integer claveAtraco=1;
		Atraco atraco =vigilancia.buscarAtracoPorClave(claveAtraco);
		
		Banco bancoEsperado = new Banco(idBanco, "la Casa de Papel");
		
		//No cambiar
		assertTrue(bancoEsperado.equals(atraco.getBanco()) );
		
		
	}
	
	
	

	@Test
	private void queSePuedaObtenerLosAtracadoresOrdenadosPorApodos() throws Exception {
		Vigilancia vigilancia = new Vigilancia ("Nombre De la Compania de Vigilancia");
		
		Integer idbanda = 1;
		String nombre="La Casa de Papel";
		Banda banda = new Banda (idbanda,nombre);
		
		Integer dni= 2;
		nombre="marcela";
		String apellido= "Corrales";
		String apodo="muelas";
		
		
		Integer idbanda1 = 1;
		String nombre1="La Casa de Papel";
		
		Integer dni1= 1;
		nombre="Ursula";
		String apellido1= "Corbero";
		String apodo1="Tokio";
		
		//No Cambiar esta Linea
		Persona atracador1 = new Atracador (dni, nombre, apellido,apodo,banda,TipoDePersona.Atracador);
		vigilancia.registrarPersona (atracador1);
		//No Cambiar esta Linea
		Persona atracador = new Atracador (dni, nombre, apellido,apodo,banda,TipoDePersona.Atracador);
		vigilancia.registrarPersona (atracador);
		
		TreeSet<Atracador> lista = vigilancia.obtenerAtracadoresOrdenados();
		
		assertEquals(apodo,lista.first().getApodo());
		assertEquals(apodo1,lista.last().getApodo());
	}
	
//Cree un 3 test a su eleccion para que pruebe el resto de las funcionalidades
	@Test
	private void testSignificativo1() {
		
	}
	
	@Test
	private void testSignificativo2() {
		
	}
	
	@Test
	private void testSignificativo3() {
		
	}
	

}
