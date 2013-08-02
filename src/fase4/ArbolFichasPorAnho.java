/**
 * @authors 
 * Danay Fernandez Martinez 100303618 
 * Luis Antonio Gonzalez Martin 100303620
 */
package fase4;


import edalib.tree.bstree.*;
import fase1.*;


public class ArbolFichasPorAnho extends BSTree<String, Ficha> {

    //Constructor
    public ArbolFichasPorAnho(ColeccionFichas cFichas) {
      
      //Primero ordenar la coleccion de fichas
    	if (cFichas != null) {
    		Ficha aux = null;
    			for(int i=0, j=1;i<cFichas.getSize()&&j<cFichas.getSize()-1;i++, j++){
    				if(cFichas.getAt(i).getVehiculo().getAnyoMatricula()>cFichas.getAt(j).getVehiculo().getAnyoMatricula()){
    					//string1 greater than string2
    					aux=cFichas.getAt(i);
    					cFichas.removeAt(i);
    					cFichas.insertAt(i, cFichas.getAt(j));
    					cFichas.removeAt(j);
    					cFichas.insertAt(j, aux); 					
    					
    				}
        		     	}
    			
/*    		AUNQUE NO SE ESPECIFICA, COMO CLAVE, USAMOS EL DNI DEL PROPIETARIO, QUE ES UN IDENTIFICADOR UNICO Y A TRAVES DE EL SE HARA 
    		LA BUSQUEDA POR PROPIETARIO*/
        	for(int i=0;i<cFichas.getSize();i++){
        		this.insert(cFichas.getAt(i).getVehiculo().getPropietario().getDni().toString(), cFichas.getAt(i));
        	}
           
        }
    }

    //metodo recursivo que muestra por pantalla el arbol
    public void mostrarArbol(BSTNode<String, Ficha> nodo) {
    	nodo.getElement().imprimir();//Empezamos por el primer nodo
        if (nodo.hasLeftChild()) {//si existe, el hijo de la izquierda
            mostrarArbol(nodo.getLeftChild());//iteracion y recorremos por la izquierda
        }
        if (nodo.hasRightChild()) {//iteracion y recorremos por la derecha
            mostrarArbol(nodo.getRightChild());
        }
    }

    //Metodo que busca las fichas SUPONIENDO QUE EL STRING (PARAMETRO) ES EL DNI
    public boolean mostrarFichasPropietario(BSTNode<String, Ficha> nodo, String propietario) {
        boolean returnValue = false;
        if (nodo.getElement().getVehiculo().getPropietario().toString().equalsIgnoreCase(propietario)) {
            nodo.getElement().imprimir();
            returnValue = true;
        }
        if (returnValue == false) {
            if (nodo.hasLeftChild()) {
                mostrarFichasPropietario(nodo.getLeftChild(), propietario);
            } else {
                if (nodo.hasRightChild()) {
                    mostrarFichasPropietario(nodo.getRightChild(), propietario);
                }
            }
        }
        return returnValue;

    }

    //Metodo iterativo que devuelve una coleccion de fichas de busqueda por rango de fecha
    public ColeccionFichas mostrarFichasRango(int fecha1, int fecha2) {
        ColeccionFichas fichas = new ColeccionFichas();
        if (fecha1 > fecha2) {
            int fechaaux = fecha1;
            fecha1 = fecha2;
            fecha2 = fechaaux;
        } // else (fecha1<fecha2)
        return mostrarFichasRango(this.root, fichas, fecha1, fecha2);
    }

    private ColeccionFichas mostrarFichasRango(BSTNode<String, Ficha> nodo, ColeccionFichas fichas, int fecha1, int fecha2) {
        int fecha = Integer.parseInt(nodo.getElement().getFechaRevision());
        if (fecha > fecha1 && fecha < fecha2) {
            fichas.addFirst((nodo.getElement()));
        }
        if (nodo.hasLeftChild()) {
            mostrarFichasRango(nodo.getLeftChild(), fichas, fecha1, fecha2);
        }
        if (nodo.hasRightChild()) {
            mostrarFichasRango(nodo.getRightChild(), fichas, fecha1, fecha2);
        }

        return fichas;
    }
}
