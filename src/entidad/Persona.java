package entidad;

public class Persona {
	
	private String Dni;
	private String Apellido;
	private String Nombre;
	public String getDni() {
		return Dni;
	}
	public void setDni(String dni) {
		Dni = dni;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	public Persona (String DNI, String Apellido, String Nombre) { 
		this.Dni = DNI; 
		this.Apellido = Apellido; 
		this.Nombre = Nombre;
	}
	

}
