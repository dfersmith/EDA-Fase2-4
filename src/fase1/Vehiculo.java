package fase1;

public class Vehiculo {

	
	public enum Categoria {Motocicleta, Coche, Furgoneta, Camion, Remolque}
	
	String marca;
	String modelo;
	String color;
	int anyoMatricula;
	int kilometros;
	int potencia;
	int CO2;
	String matricula;
	String bastidor;
	int numPlazas;
	int peso;
	Categoria categoria;
	
	/**
	 * Atributo que almacena el propietario del vehiculo
	 */
	Propietario propietario;
	/**
	 * Atributos  Array de piezas del vehiculo
	 */
	Pieza piezas[];
	/**
	 * Atributo para almacenar las ruedas del vehiculo
	 */
	Rueda ruedas[];


	//Necesitamos este constructor para permitir crear un remolque (que no tiene
	//el resto de atributos)
	public Vehiculo() {
	}

	public Vehiculo(String marca, String modelo, String color,
			int anyoMatricula, int kilometros, int potencia, int cO2,
			String matricula, String bastidor, int numPlazas, int peso,
			Categoria categoria, Pieza piezas[], Rueda[] ruedas, Propietario propietario) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.anyoMatricula = anyoMatricula;
		this.kilometros = kilometros;
		this.potencia = potencia;
		CO2 = cO2;
		this.matricula = matricula;
		this.bastidor = bastidor;
		this.numPlazas = numPlazas;
		this.peso = peso;
		this.categoria = categoria;
		this.piezas = piezas;
		this.ruedas=ruedas;
		this.propietario = propietario;
	}

	/**
	 * Metodo que muestra por pantalla los principales datos del vehiculo
	 */
	public void imprimir(){
		System.out.print("Vehiculo: ");
		System.out.print(marca + " ");
		System.out.print(modelo + " ");
		System.out.print(matricula + " ");
		System.out.print(bastidor + " ");
		System.out.print(categoria + " ");
		System.out.print(propietario.getDni() );
		
		System.out.println();
		propietario.imprimir();
	}
	/**
	 * Metodo que concatena los principales campos de un vehiuclo y lo devuelve como string
	 */
	public String toString() {
		return this.matricula + " " + this.marca+ " " +this.modelo + " " + this.bastidor + " " + this.categoria + " " + this.propietario.getDni();
	}
	/**
	 * Metodo que revisa cada una de las piezas del vehiculo. Si alguna pieza esta mal
	 * devuelve directamente false.
	 * @return
	 */
	public boolean revisar(){
		System.out.println("Estado de las piezas del vehiculo:" + this.matricula );
		for(int i=0;i<piezas.length;i++){
			if(!piezas[i].revisar()){
				return false;
			}
		}
		//revisamos tambien las ruedas
		for (int i = 0; i < ruedas.length; i++) {
			if(!ruedas[i].revisar()){
				return false;
			}
		}
		return true;
	}
	
	
	//Getters and setters
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAnyoMatricula() {
		return anyoMatricula;
	}

	public void setAnyoMatricula(int anyoMatricula) {
		this.anyoMatricula = anyoMatricula;
	}

	public int getKilometros() {
		return kilometros;
	}

	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public int getCO2() {
		return CO2;
	}

	public void setCO2(int cO2) {
		CO2 = cO2;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getBastidor() {
		return bastidor;
	}

	public void setBastidor(String bastidor) {
		this.bastidor = bastidor;
	}

	public int getNumPlazas() {
		return numPlazas;
	}

	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Pieza[] getPiezas() {
		return piezas;
	}

	public void setPiezas(Pieza[] piezas) {
		this.piezas = piezas;
	}

	public Pieza[] getRuedas() {
		return ruedas;
	}

	public void setRuedas(Rueda[] ruedas) {
		this.ruedas = ruedas;
	}
	
	public Persona getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	
}
