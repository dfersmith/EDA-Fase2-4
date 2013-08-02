package fase1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Persona {

	String nombre;
	String apellidos;
	String dni;
	String fechaNacimiento;
	
	public Persona() {
		super();
	}
	
	public Persona(String nombre, String apellidos, String dni,
			String fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Persona){
			Persona p = (Persona) obj;
			if(nombre.equalsIgnoreCase(p.getNombre()) && apellidos.equalsIgnoreCase(p.getApellidos()) &&
					dni.equalsIgnoreCase(p.getDni()) && fechaNacimiento.equalsIgnoreCase(p.getFechaNacimiento())){
				return true;
			}
		}
		return false;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void imprimir(){
		System.out.print("Persona: ");
		System.out.print(nombre + "");
		System.out.print(apellidos + "");
		System.out.print(dni + "");
		System.out.println(fechaNacimiento + "");
	}
	
	/**
	 * Consideramos que dos propietarios son iguales si tienen el mismo dni
	 * @param p
	 * @return
	 */
	public boolean equals(Persona p ) {
		return dni.equals(p.dni);
	}
	
	public int getEdad(){
		String fecha = this.getFechaNacimiento();
		int d = Integer.parseInt(fecha.substring(0, 2));
		int m = Integer.parseInt(fecha.substring(2, 4));
		int a = Integer.parseInt(fecha.substring(4));

		Date fechaActual = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String hoy = formato.format(fechaActual);
		String[] dat2 = hoy.split("/");
		int anos = Integer.parseInt(dat2[2]) - a;
		int mes = Integer.parseInt(dat2[1]) - m;
		if (mes < 0) {
			anos = anos - 1;
		} else if (mes == 0) {
			int dia = Integer.parseInt(dat2[0]) - d;
			if (dia > 0) {
				anos = anos - 1;
			}
		}
		return anos;
	}

}
