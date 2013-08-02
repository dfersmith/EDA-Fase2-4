package fase1;



public class ColeccionPropietarios{

	Propietario[] propietarios;
	/**
	 * Posicion donde se debe almacenar el proximo propietario
	 */
	int indice;



	public ColeccionPropietarios(int N) {
		propietarios = new Propietario[N];
		indice = 0;
	}

//	public Coleccionpropietarios(Vehiculo[] propietarios) {
//		super();
//		this.propietarios = propietarios;
//	}

	public int getTamanyo(){
		return indice;
	}
	
	public void anyadirPropietario(Propietario v){
		if(indice==propietarios.length){
			System.out.println("ERROR: No caben mass propietarios en la coleccion");
		}
		else{
			propietarios[indice]=v;
			indice++;
		}
	}

	public Propietario obtenerPropietario(int posicion){
		if(posicion>this.getTamanyo() || posicion<0){
			System.out.println("ERROR: la posicion no es valida para el tamano de la coleccion");
			return null;
		}
		return propietarios[posicion];
		
	}

	
	
		
	public Propietario[] getpropietarios() {
		return propietarios;
	}

	public void setPropietarios(Propietario[] propietarios) {
		this.propietarios = propietarios;
	}
	
}
