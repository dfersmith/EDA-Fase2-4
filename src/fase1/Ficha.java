package fase1;


public class Ficha {
	
	Vehiculo vehiculo;
	String fechaRevision;
	Empleado empleado;
	

	public Ficha(Vehiculo vehiculo, String fechaRevision, Empleado empleado) {
		super();
		this.vehiculo = vehiculo;
		this.fechaRevision = fechaRevision;
		this.empleado = empleado;
	}


	public Ficha() {
		super();
	}


	public String getFechaRevision() {
		return fechaRevision;
	}

	public void setFechaRevision(String fechaRevision) {
		this.fechaRevision = fechaRevision;
	}



	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	
	/**
	 * Metodo que imprime la ficha
	 */
	public void imprimir() {
		System.out.print("Ficha: ");
		System.out.print(" Marca: " + this.vehiculo.marca);
		System.out.print(", Modelo: " + vehiculo.modelo);
		System.out.print(", Matricula: " + vehiculo.matricula);
		System.out.print(", Bastidor: " + vehiculo.bastidor);
		System.out.print(", DNI propietario " + vehiculo.propietario.getDni() + " ");
		System.out.println(", Fecha Revision " + this.fechaRevision);

		System.out.print("\tRevisado por " + empleado.getDni() );
		System.out.println();
		
			vehiculo.revisar();
		
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
}
