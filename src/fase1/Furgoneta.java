package fase1;

public class Furgoneta extends Vehiculo {

	int carga;
	
	
	public Furgoneta(String marca, String modelo, String color,
			int anyoMatricula, int kilometros, int potencia, int cO2,
			String matricula, String bastidor, int numPlazas, int peso,
			Categoria categoria, Pieza[] piezas, Rueda[] ruedas, int carga, Propietario propietario)  {
		
		super(marca, modelo, color, anyoMatricula, kilometros, potencia, cO2,
				matricula, bastidor, numPlazas, peso, categoria, piezas, ruedas, propietario);
		
		this.carga = carga;
		if (ruedas.length!=4) {
			System.out.println("[Furgo]Warning!!! numero de ruedas incorrecto");
		} else ruedas=new Rueda[4]; //creamos 4 ruedas por defecto
	}
	
	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}
	
	public void setRuedas(Rueda[] ruedas) {
		if (ruedas.length!=4) {
			System.out.println("[Furgo]Warning!!!: la furgoneta debe tener 4 ruedas");
			return;
		}
		this.ruedas = ruedas;
	}


}
