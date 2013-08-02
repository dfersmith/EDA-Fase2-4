package fase1;

public class Coche extends Vehiculo {

	
	
	public Coche(String marca, String modelo, String color,
			int anyoMatricula, int kilometros, int potencia, int cO2,
			String matricula, String bastidor, int numPlazas, int peso,
			Categoria categoria, Pieza[] piezas, Rueda[] ruedas, Propietario propietario) {
		
		super(marca, modelo, color, anyoMatricula, kilometros, potencia, cO2,
				matricula, bastidor, numPlazas, peso, categoria, piezas, ruedas, propietario);
		
		//comprobamos la integridad de los datos
		if(numPlazas<2 || numPlazas>7){
			System.out.println("[Coche]Warning!!!: el coche no puede tener este numero de plazas");
			return;
		}
		if (ruedas.length!=4) {
			System.out.println("[Coche]Warning!!!: el coche debe tener 4 ruedas");
		} else ruedas=new Rueda[4]; //creamos 4 ruedas por defecto
	}

	public void setNumPlazas(int numPlazas) {
		if(numPlazas<2 || numPlazas>7){
			System.out.println("[Coche]Warning!!!: el coche no puede tener este numero de plazas");
			return;
		}
		this.numPlazas = numPlazas;
	}
	
	public void setRuedas(Rueda[] ruedas) {
		if (ruedas.length!=4) {
			System.out.println("[Coche]Warning!!!: el coche debe tener 4 ruedas");
			return;
		}
		this.ruedas = ruedas;
	}


}
