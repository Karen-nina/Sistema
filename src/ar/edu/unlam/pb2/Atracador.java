package ar.edu.unlam.pb2;

public class Atracador extends Persona implements Comparable<Atracador> {
	
	private Banda banda;
	private String apodo;
	
	public Atracador(Integer dni, String nombre, String apellido, String apodo, Banda banda, TipoDePersona tipo) {
		super(dni, nombre, apellido, tipo);
		this.banda = banda;
		this.apodo = apodo;
	}
	
	public Banda getBanda() {
		return banda;
	}
	public void setBanda(Banda banda) {
		this.banda = banda;
	}
	public String getApodo() {
		return apodo;
	}
	public void setApodo(String apodo) {
		this.apodo = apodo;
	}
	@Override
	public int compareTo(Atracador o) {
		
		return this.apodo.compareTo(o.apodo);
	}

	
	
}
