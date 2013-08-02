/**
 * 
 */
package fase1;

/**
 * @author Mery
 *
 */
public class Remolque extends Vehiculo {
	
	int carga;
	

	//Vamos a suponer que los remolques solo tienen carga y ruedas
	public Remolque(int carga, Rueda[] ruedas) {
		this.carga = carga;
		this.ruedas=ruedas;
	}

	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}

	

}
