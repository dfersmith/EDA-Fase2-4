package fase1;

public class Motocicleta extends Vehiculo {

	Cadena cadena;
	

	public Motocicleta(String marca, String modelo, String color,
			int anyoMatricula, int kilometros, int potencia, int cO2,
			String matricula, String bastidor, int peso,
			Categoria categoria, Pieza[] piezas, Rueda[] ruedas, Cadena c, int plazas,  Propietario propietario)  {
		
		super(marca, modelo, color, anyoMatricula, kilometros, potencia, cO2,
				matricula, bastidor, plazas, peso, categoria, piezas, ruedas, propietario);
		if(plazas!=2){
			System.out.println("[Motocicleta] Warning!!! Numero de plazas inadecuado");
		}
		if (ruedas.length!=2) {
			System.out.println("[Motocicleta] Warning!!! Numero de ruedas inadecuado");
		}
		
		this.cadena = c;

	}

	public Cadena getCadena() {
		return cadena;
	}

	public void setCadena(Cadena cadena) {
		this.cadena = cadena;
	}

	public void setRuedas(Rueda[] ruedas) {
		if (ruedas.length!=2) {
			System.out.println("[Motocicleta] Warning!!!: la motocicleta debe tener 2 ruedas");
			return;
		}
		this.ruedas = ruedas;
	}
	
	
	public boolean revisar() {
		return cadena.revisar() && super.revisar();
	}
}
