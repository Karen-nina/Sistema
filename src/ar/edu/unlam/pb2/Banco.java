package ar.edu.unlam.pb2;

public class Banco {

	private String nombre;
	private Integer idBanco;

	
	public Banco(Integer idBanco, String nombre) {
		super();
		this.nombre = nombre;
		this.idBanco = idBanco;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(Integer idBanco) {
		this.idBanco = idBanco;
	}

	
}
