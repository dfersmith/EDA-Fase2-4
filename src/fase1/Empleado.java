package fase1;

public class Empleado extends Persona {

	String id;
	String fechaAlta;

	public Empleado() {
		super();
	}

	public Empleado(String nombre, String apellidos, String dni,
			String fechaNacimiento, String id, String fechaAlta) {
		super(nombre, apellidos, dni, fechaNacimiento);
		this.id=id;
		this.fechaAlta = fechaAlta;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	
}
