package ar.edu.unlam.pb2;

public  abstract class Persona {
	
	private Integer dni;
	private String nombre;
	private String apellido;
	private TipoDePersona tipo;
	
	public Persona(Integer dni, String nombre, String apellido, TipoDePersona tipo) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipo = tipo;
		
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public TipoDePersona getTipo() {
		return tipo;
	}

	public void setTipo(TipoDePersona tipo) {
		this.tipo = tipo;
	}
	 
	
}
