package ar.edu.unlam.pb2;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Vigilancia {

	private String nombre;
	private Map <Integer, Atraco> atracos;
	// Colocar el tipo de coleccion que corresponda
	private TreeSet<Persona> personas;
	// Colocar el tipo de coleccion que corresponda
	private HashSet<Banco> bancos;

	public Vigilancia(String nombre) {
		this.nombre = nombre;
		this.personas = new TreeSet<Persona>();
		this.bancos = new HashSet<Banco>();
		this.atracos = new HashMap <Integer, Atraco>();
	}
	
	//No se puede cambiar 
	
	

	/*
	 * Registra tanto como Vigiladores como atracadores no permite registrar 2
	 * personas con el mismo DNI. Si esto sucede lanza una exception
	 * PersonaDuplicadaException
	 * 
	 */

	public void registrarPersona(Persona persona) throws PersonaDuplicadaException {
		for (Persona p: personas) {
			if(p.getDni().equals(persona.getDni())) {
				throw new PersonaDuplicadaException("persona ya existente");
			}
		}
		this.personas.add(persona);
	}

	public void agregarBanco(Banco banco) {
		/*for (Banco b : bancos) {
			if (b.getIdBanco().equals(banco.getIdBanco())) {
				
			}
		}*/
		this.bancos.add(banco);
	}

	/*
	 * Este Metodo lanza las siguientes Excepciones NoSeEncuentraAtracadorException
	 * BancoNoEncontradoExcecption
	 * 
	 */
	
	public void registrarAtraco(Integer dniAtracador, Integer idBanco) throws Exception{

	Atracador atracador = buscarAtracadorPorDni(dniAtracador);
	Banco banco = buscarBancoPorId(idBanco);
	Atraco atraco = new Atraco (atracador,banco);		
	
	
	//Se debe agregar un atraco al Mapa
	this.atracos.put(01, atraco);	
		
		
	}

	private Atracador buscarAtracadorPorDni(Integer dniAtracador) throws NoSeEncuentraAtracadorException {
		for (Persona a: personas) {
			if (a.getDni().equals(dniAtracador)) {
				return (Atracador) a;
			}
		}
		throw new NoSeEncuentraAtracadorException("atracador inexistente");
	}

	private Banco buscarBancoPorId(Integer idBanco) throws BancoNoEncontradoExcecption {
		for (Banco banco : bancos) {
		if (banco.getIdBanco().equals(idBanco)) {
			return banco;
			}	
		}
		throw new BancoNoEncontradoExcecption("banco inexitente");
	}

	//Si la clave no existe lanza ClaveInexistenteException
	public Atraco buscarAtracoPorClave(Integer claveAtraco) throws ClaveInexistenteException {
		if(this.atracos.containsKey(claveAtraco)) {
			return atracos.get(claveAtraco);
		}
		 throw new ClaveInexistenteException("clave no existe en el sistema");
	}
	
	/*public Vigilante obtenerElVigiladorDeUnAtraco(Integer claveAtraco) throws ClaveInexistenteException {
		Atraco atraco = buscarAtracoPorClave(claveAtraco);
		Banco banco = atraco.getBanco();
		Vigilante vigilante ;
		
		for (Persona p: personas) {
			if(vigilante.getBanco().equals(banco)) {
			return vigilante;
		}
		
		}
		return null;
		
	}
*/
	
	public TreeSet<Atracador> obtenerAtracadoresOrdenados(){
		
		TreeSet<Atracador> atracadoresOrdenadados = new TreeSet<Atracador>(new OrdenPorApodos());
		for (Persona persona : personas) {
			if (persona.getTipo().equals(TipoDePersona.Atracador)) {
				atracadoresOrdenadados.add((Atracador) persona);
			}
		}
		
		return atracadoresOrdenadados;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Map<Integer, Atraco> getAtracos() {
		return atracos;
	}

	public void setAtracos(Map<Integer, Atraco> atracos) {
		this.atracos = atracos;
	}

	public TreeSet<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(TreeSet<Persona> personas) {
		this.personas = personas;
	}

	public HashSet<Banco> getBancos() {
		return bancos;
	}

	public void setBancos(HashSet<Banco> bancos) {
		this.bancos = bancos;
	}
	
	

}
