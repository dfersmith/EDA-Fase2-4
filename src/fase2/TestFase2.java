/**
 * @authors 
 * Danay Fernandez Martinez 100303618 
 * Luis Antonio Gonzalez Martin 100303620
 */
package fase2;

import java.text.SimpleDateFormat;
import java.util.Date;

import edalib.list.singlelink.*;
import fase1.Empleado;
import fase1.Ficha;
import fase1.Test;

public class TestFase2 {

	private PilaFichas pilaUno = new PilaFichas();
	private PilaFichas pilaDos = new PilaFichas();
	public static TestFase2 t2;
	static Armario armario = new Armario();

	public TestFase2() {
		// TODO Auto-generated constructor stub
	}

	public void ponerFichasEnPilas() {

		// ejecutamos el test1 para add vehiculos y propietarios en fichas
		Test t1 = new Test();
		t1.anyadirVehiculos();
		// Se han comentado los System.out.print de la fase1

		Empleado emp1 = new Empleado("Paloma", "Marinez Fernandez",
				"83543213A", "02/09/1968", "01", "02/09/1992");
		Date fechaActual = new Date();
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		String hoy = f.format(fechaActual);

		// por el momento todos los revisa el primer empleado (pro simplificar)
		for (int i = 0; i < t1.coleccionVehiculos.getTamanyo(); i++) {

			Ficha ficha = new Ficha(t1.coleccionVehiculos.getVehiculos()[i],
					hoy, emp1);
			// Se add las fichas a la cola de fichas desordenada

			pilaUno.push(ficha);

		}
	}

	public void ponerFichasEnArmario() {
		TestFase2 t2 = new TestFase2();
		t2.ponerFichasEnPilas();

		PilaFichas aux = t2.pilaUno;
		int veces1 = aux.getSize();
		for (int i = 0; i < veces1; i++) {
			armario.guardarFicha(t2.pilaUno.pop());
		}
		PilaFichas aux2 = t2.pilaDos;

		int veces2 = aux2.getSize();
		for (int i = 0; i < veces2; i++) {

			armario.guardarFicha(t2.pilaDos.pop());
		}

	}

	public void ordenarElimprimirFichas() {

		System.out.println("\t\tFICHAS CON PROPIETARIOS ORDENADOS\n");

		// aqui no solo pruebo que se vacia el armario si que ademas se vacia
		// ordenandolo en la lista fiar
		SList<Ficha> fiar = armario.obtenerListaArmario();
		Casilla nc = new Casilla();
		for (int i = 0; i < fiar.getSize(); i++) {
			nc.guardarFichaOrdenada(fiar.getAt(i));
		}

		// Para ordenar la lista utiliza la clase casillas que ya tiene
		// implementado el metodo ordenar
		nc.obtenerFichas();
		for (int i = 0; i < nc.lista.getSize(); i++) {

			System.out.println("\n\tPROPIETARIO :"
					+ nc.lista.getAt(i).getVehiculo().getPropietario()
							.getApellidos() + "\n");
			nc.lista.getAt(i).imprimir();
		}
	}

	public void buscarFichaEnPilasPorPropietario(String nombre) {
		
		t2.pilaDos= new PilaFichas();
		while(t2.pilaUno.getSize()>0 && !t2.pilaUno.top().getVehiculo().getPropietario().getNombre().equalsIgnoreCase(nombre)){
			t2.pilaDos.push(t2.pilaUno.pop());
		}
		if (t2.pilaUno.getSize()==0){
			while(t2.pilaDos.getSize()>0 && !t2.pilaDos.top().getVehiculo().getPropietario().getNombre().equalsIgnoreCase(nombre)){
				t2.pilaUno.push(t2.pilaDos.pop());
			}

		}
	}

	public static void main(String[] args) {

		t2 = new TestFase2();

		t2.ponerFichasEnArmario();
		t2.ordenarElimprimirFichas();
		t2.buscarFichaEnPilasPorPropietario("Pedro");

	}

}
