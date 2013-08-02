/**
 * @authors 
 * Danay Fernandez Martinez 100303618 
 * Luis Antonio Gonzalez Martin 100303620
 */
package fase4;

import edalib.tree.bstree.*;
import fase1.*;

public class ArbolFichasPorPropietario extends BSTree<String, Ficha> {

    //Constructor que recibe una coleccion de fichas e inserta cada ficha en un arbol
    public ArbolFichasPorPropietario(ColeccionFichas cFichas) {
    	//Primero ordenar la coleccion de fichas
    	if (cFichas != null) {
    		Ficha aux = null;
    			for(int i=0, j=1;i<cFichas.getSize()&&j<cFichas.getSize()-1;i++, j++){
    				if(cFichas.getAt(i).getVehiculo().getPropietario().getNombre().compareTo(cFichas.getAt(j).getVehiculo().getPropietario().getNombre().toString())>1){
    					//string1 greater than string2
    					aux=cFichas.getAt(i);
    					cFichas.removeAt(i);
    					cFichas.insertAt(i, cFichas.getAt(j));
    					cFichas.removeAt(j);
    					cFichas.insertAt(j, aux); 					
    					
    				}
        		     	}
        	for(int i=0;i<cFichas.getSize();i++){
        		this.insert(cFichas.getAt(i).getVehiculo().getPropietario().getDni().toString(), cFichas.getAt(i));
        	}
           
        }
    }

    //Metodo recursivo que muestra por pantalla el arbol
    public void mostrarArbol(BSTNode<String, Ficha> nodo) {
       nodo.getElement().imprimir();//Mostramos el primer nodo y cada uno de los siguientes
        if (nodo.hasLeftChild()) {//si tiene un hijo izquierdo, recorre el lado izquierdo
            mostrarArbol(nodo.getLeftChild());
        }
        if (nodo.hasRightChild()) {//si tiene un hijo derecho, recorre el lado derecho
            mostrarArbol(nodo.getRightChild());
        }
    }

    //Metodo recursivo que busca las fichas de un propietario. Se le pasa un nodo (la primera llamada con el primero nodo)
    public void mostrarFichasPropietario(BSTNode<String, Ficha> nodo, String propietario) {
              
        if(propietario.compareTo(nodo.getKey())>1&&nodo.hasRightChild()){
        	mostrarFichasPropietario(nodo.getRightChild(), propietario);
        }
        else if(propietario.compareTo(nodo.getKey())<1&&nodo.hasLeftChild()){
        	mostrarFichasPropietario(nodo.getLeftChild(), propietario);
        }
        else { //equal string
        	nodo.getElement().imprimir();
        	if(nodo.hasRightChild()){
            	mostrarFichasPropietario(nodo.getRightChild(), propietario);
            }
            else if(nodo.hasLeftChild()){
            	mostrarFichasPropietario(nodo.getLeftChild(), propietario);
            }
            
        }
        	
               

    }

    //Metodo iterativo que devuelve una coleccion de fichas de busqueda por rango de fecha
    public ColeccionFichas mostrarFichasRango(int fecha1, int fecha2) {
        ColeccionFichas fichas = new ColeccionFichas();
        if (fecha1 > fecha2) {
            int fechaaux = fecha1;
            fecha1 = fecha2;
            fecha2 = fechaaux;
        } //else (fecha1<fecha2)
        //sobrecarga del metodo recursivo
        return mostrarFichasRango(this.root, fichas, fecha1, fecha2);

    }

    private ColeccionFichas mostrarFichasRango(BSTNode<String, Ficha> nodo, ColeccionFichas fichas, int fecha1, int fecha2) {
        int fecha = Integer.parseInt(nodo.getElement().getFechaRevision().substring(nodo.getElement().getFechaRevision().length()-4));
        if (fecha >= fecha1 && fecha <= fecha2) {
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
