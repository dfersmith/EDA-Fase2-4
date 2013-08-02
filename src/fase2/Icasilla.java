/**
 * @authors 
 * Danay Fernandez Martinez 100303618 
 * Luis Antonio Gonzalez Martin 100303620
 */
package fase2;

import edalib.list.singlelink.*;
import fase1.Ficha;


public interface Icasilla {
	
	public String getEtiqueta();

	public void setEtiqueta(String etiqueta);
	
	public void guardarFicha(Ficha f);
	
	public void guardarFichaOrdenada(Ficha f);
	
	public Ficha buscarFicha(String apellidos, String matricula);
	
	public SList<Ficha> obtenerFichas();
	
	//Metodo para facilitar la ordenacion
	public void ordenarLista();

}
