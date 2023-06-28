package ar.edu.unlam.pb2;

public class Vigilante extends Persona {
	private Banco banco;

	public Vigilante(Integer dni, String nombre, String apellido, Banco banco, TipoDePersona tipo) {
		super(dni, nombre, apellido, tipo);
		this.banco = banco;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	
	
	
	

}
