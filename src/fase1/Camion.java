package fase1;

public class Camion extends Vehiculo {

	int carga;
	Remolque remolque;
	
	

//	public Camion() {
//		
//	}
	
	public Camion(String marca, String modelo, String color,
			int anyoMatricula, int kilometros, int potencia, int cO2,
			String matricula, String bastidor, int numPlazas, int peso,
			Categoria categoria, Pieza[] piezas, Rueda[] ruedas, Propietario propietario, Remolque remolque) {
		
		super(marca, modelo, color, anyoMatricula, kilometros, potencia, cO2,
				matricula, bastidor, numPlazas, peso, categoria, piezas, ruedas, propietario);
		
		if(ruedas.length<6 || ruedas.length>12){
			System.out.println("[Camion]Warning!!!: el numero de ruedas debe ser entre 6 y 12");
		} else ruedas=new Rueda[6]; //creamos un cami�n de 6 ruedas por defecto
		
		this.remolque=remolque;
		
	}
	
	public Camion(String marca, String modelo, String color,
			int anyoMatricula, int kilometros, int potencia, int cO2,
			String matricula, String bastidor, int numPlazas, int peso,
			Categoria categoria, Pieza[] piezas, Rueda[] ruedas, Propietario propietario) {
		
		this(marca, modelo, color, anyoMatricula, kilometros, potencia, cO2,
				matricula, bastidor, numPlazas, peso, categoria, piezas, ruedas, propietario,null);
	}
	
	//m�todos getters and setters
	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}

	public void setRuedas(Rueda[] ruedas) {
		if (ruedas.length<6 || ruedas.length>12) {
			System.out.println("[Camion]Warning!!!: el numero de ruedas debe ser entre 6 y 12");
			return;
		}
		this.ruedas = ruedas;
	}

	
	public Remolque getRemolque() {
		return remolque;
	}

	public void setRemolque(Remolque remolque) {
		this.remolque = remolque;
	}
	
	/**
	 * Metodo para revisar las piezas del camion. 
	 * Ademas de las comunes del vehiculo (llamda al metodo revisar de la clase vehiculo)
	 * se deben ademas  el remolque
	 */
	public boolean revisar() {
		if(super.revisar()){
			//debemos revisar adem�s el remolque
			if(remolque==null || remolque.revisar()){
				return true;
			}
		}
		return false;
	}
}
