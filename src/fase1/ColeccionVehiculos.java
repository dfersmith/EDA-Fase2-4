package fase1;

import fase1.Pieza.TipoPieza;


public class ColeccionVehiculos{

	Vehiculo[] vehiculos;
	/**
	 * atributo que almacena la posicon donde se debe almacenar el siguiente vehiculo
	 */
	int indice;


	public ColeccionVehiculos(int N) {
		vehiculos = new Vehiculo[N];
		indice = 0;
	}

/**
 * Devuelve el numero de veh�culos en la colecci�n
 * @return
 */
	public int getTamanyo(){
		return indice;
	}
	
	public void anyadirVehiculo(Vehiculo v){
		if(indice==vehiculos.length){
			System.out.println("ERROR: No caben mas vehiculos en la colección");
		}
		else{
			vehiculos[indice]=v;
			indice++;
		}
	}

	public Vehiculo obtenerVehiculo(int posicion){
		Vehiculo v = null;
		if(posicion>=vehiculos.length || posicion<0){
			System.out.println("ERROR: la posición no es válida para el tamaño de la colección");
			return null;
		}
		v = vehiculos[posicion];
		return v;
	}

	
	/**
	 * M�todo que muestra todos los veh�culos cuyo a�o de matriculaci�n 
	 * coincide con el valor del argumento
	 * @param anyo
	 */
	public void buscarVehiculoPorAnyo(int anyo){
		int numFounds=0;
		for (int i = 0; i < this.indice; i++) {
			if(vehiculos[i].getAnyoMatricula()==anyo){
				System.out.println(vehiculos[i].toString());
				numFounds++;
			}
		}
		
		if (numFounds==0) {
			System.out.println("No existen coches matriculadso en el a�o " + anyo);
		}
	}

	/**
	 * M�todo que recorre la lista y muestra aquellos veh�culos cuyo propietario coincide con el propietario
	 * pasado por argumento
	 * @param p
	 */
	public void buscarPropietario(Propietario p){
		for (int i = 0; i < this.indice; i++) {
			if(vehiculos[i].getPropietario().equals(p)){
				System.out.println(vehiculos[i].toString());
			}
		}
	}
	
	/**
	 * Muestra las piezas de un determinado tipo de todos los veh�culos (adme�s mostramos 
	 * su estado)
	 * @param tipo
	 */
	public void buscarPiezaTipo(Pieza.TipoPieza tipo){
		
		for (int i = 0; i < this.indice; i++) {
			
			if (vehiculos[i].getMatricula().equals("6758HAX")) {
				System.out.println("Paraaaa");
			}
			Pieza piezas[];
			if (tipo.equals(TipoPieza.Rueda)) {
				 piezas= vehiculos[i].ruedas;
			} else piezas = vehiculos[i].piezas;
			
			
			for (int j = 0; j < piezas.length; j++) {
					if (piezas[j].getTipo().equals(tipo)) {
						System.out.print(vehiculos[i].getMatricula() + " " + tipo + " ");
						if (piezas[j].getEstado()) {
							System.out.println(" en buen estado");
						} else System.out.println(" en mal estado");
					}
			}
		}
	}
	/**
	 * Mostramos los veh�culos cuyos propietarios est�n en un determinado rango de edad
	 * @param edadMin
	 * @param edadMax
	 */
	public void buscarPropietarioPorEdad(int edadMin, int edadMax){
		for (int i = 0; i < this.indice; i++) {
			int ed = (vehiculos[i].getPropietario()).getEdad();
			if(ed>edadMin && ed<edadMax){
				System.out.println(vehiculos[i].toString());
			}
		}
	}

		
	public Vehiculo[] getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(Vehiculo[] vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	
	public void mostrar() {
		for (int i=0; i<this.getTamanyo();i++) {
			System.out.println(this.getVehiculos()[i].toString());
		}
	}
	
	
}
