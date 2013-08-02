/**
 * @authors 
 * Danay Fernandez Martinez 100303618 
 * Luis Antonio Gonzalez Martin 100303620
 */
package fase2;


import edalib.list.singlelink.SList;
import fase1.*;

public class Casilla implements Icasilla {

	String etiqueta;
	SList<Ficha> lista= new SList<>();
	
	public Casilla() {
		
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	//Metodo que guarda la ficha al final sin ordenar
	@Override
	public void guardarFicha(Ficha f) {
		lista.addLast(f);
		
	}

	
	/*Para insertar la ficha ordenadamente, el metodo que utlizo es introducirla al final 
	 * y luego mediante el metodo ordenar ficha se ordenan todas las fichas
	*/
	@Override
	public void guardarFichaOrdenada(Ficha f) {
		
		//add la ficha al final
		guardarFicha(f);
		//ahora la ordenamos SI PROCEDE
		if(lista.getSize()>1) {
			ordenarLista();
		}
		
	}
	
	//Metodo interno para saber cual es la primera del abecedario de la lista
private Ficha elPrimero(SList<Ficha> lficha){
		
		Ficha b= new Ficha();
		int indice=0;
		b=lficha.getFirst();
		
		for(int i=0;i<lficha.getSize();i++) {
					
					if(b.getVehiculo().getPropietario().getApellidos().compareToIgnoreCase(lficha.getAt(i).getVehiculo().getPropietario().getApellidos()) > 1 ) {
						b=lficha.getAt(i);
						indice=i;
					}
				}
				
				lficha.removeAt(indice);
				return b;
	}

	@Override
	public void ordenarLista() {
		
		SList<Ficha> aux=new SList<Ficha>();
		
		if(lista.getSize()==0) {
			System.out.println("No hay ninguna ficha no es necesario ordenar");
			
		}
		if(lista.getSize()==1) {
			System.out.println("Solo hay una ficha no es necesario ordenar");
		}
		if(lista.getSize()>1) {
			
		int numeroApellidos=lista.getSize();
			
			for(int i=0;i<numeroApellidos;i++) {
				aux.addLast(elPrimero(lista));  //Con el metodo el primero vamos add los apellidos en orden
			}
		}
		lista=aux; 
		
	}
	@Override
	public Ficha buscarFicha(String apellidos, String matricula) {
		
		for(int i=0;i<lista.getSize();i++) {
			if(lista.getAt(i).getEmpleado().getApellidos().equals(matricula) && lista.getAt(i).getVehiculo().getMatricula().equals(matricula)) {
				return lista.getAt(i);
			}
		}
		return null;
	}

	@Override
	public SList<Ficha> obtenerFichas() {
		
		return lista;
	}

	

}
