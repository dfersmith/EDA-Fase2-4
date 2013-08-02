/**
 * @authors 
 * Danay Fernandez Martinez 100303618 
 * Luis Antonio Gonzalez Martin 100303620
 */
package fase4;

import edalib.list.singlelink.*;
import fase1.*;
import fase2.*;

public class ColeccionFichas extends SList<Ficha> {

	
    //Constructor que crea la lista a partir del armario de la fase 2
    public ColeccionFichas(Iarmario<Ficha> iArmario) {
       
        SList<Ficha> lista;
        lista = new SList<>();
        lista = iArmario.vaciarArmario();
        for (int i = 0; i < lista.getSize(); i++) {
        	this.addLast(lista.getAt(i));
        }
    	    	
    }
    public ColeccionFichas(){
        
    }

    //Metodo que imprime por pantalla todo el contenido de la coleccion
    public void mostrarFichas() {
    	for(int i=0; i<this.getSize();i++){
    		this.getAt(i).imprimir();
    	}
       
    }

    //Metodo que devuelve la lista de fichas creadas por el empleado
    public SList<Ficha> obtenerFichaPorEmpleado(Empleado empleado) {
        SList<Ficha> fichas;
        fichas = new SList<>();
        for(int i=0; i<this.getSize();i++){
        	if (this.getAt(i).getEmpleado().equals(empleado)) {
                fichas.addFirst(this.getAt(i));
            }
        }
        return fichas;
    }
}
