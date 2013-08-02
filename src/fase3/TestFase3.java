/**
 * @authors 
 * Danay Fernandez Martinez 100303618 
 * Luis Antonio Gonzalez Martin 100303620
 */
package fase3;

import fase1.*;
import fase1.Coche;
import fase1.Direccion;
import fase1.Empleado;
import fase1.Freno;
import fase1.Luz;
import fase1.Motocicleta;
import fase1.Motor;
import fase1.Pieza;
import fase1.Propietario;
import fase1.Rueda;
import fase1.TuboDeEscape;
import fase1.Vehiculo;
import fase1.Propietario.TipoCarnet;
import fase1.Vehiculo.Categoria;


public class TestFase3 {

	public TestFase3() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ITV it=new ITV(2, 3,2);
		
		
		Pieza piezas[] ={new Direccion(true), new Freno(true), new Luz(true),  new Motor(true), new TuboDeEscape(true)};
		Propietario pro9 = new Propietario("Mercedes", "Hidalgo Romero", "33786908I","25041977", null, TipoCarnet.B, "08031996");
		Propietario pro10 = new Propietario("Julián", "Rodriguez Peralta", "65453987G","30011987", null, TipoCarnet.BTV, "13122005");
		Rueda[] ruedasMoto={new Rueda(true), new Rueda(true)};
		Rueda[] ruedasMal ={new Rueda(true), new Rueda(true), new Rueda(true),  new Rueda(true)};
		Cadena c2 = new Cadena(true);//su cadena tambien
		Vehiculo v10 = new Motocicleta("Honda", "Transalp", "Gris", 2012, 5000, 60, 150, "6758HAX", "231467h65g4f", 30, Categoria.Motocicleta, piezas, ruedasMoto, c2, 2,pro10);
		Vehiculo v9 = new Coche("Seat", "Ibiza", "Negro", 2000, 18796, 90, 197, "4656CVG", "2314t6yuhg87", 5, 1000, Categoria.Coche, piezas, ruedasMal, pro9);
		it.ingresarVehiculo(v10, true);
		Empleado emp1 = new Empleado("Paloma","Martínez Fernández", "83543213A","02/09/1968", "01", "02/09/1992");
		it.abrirPuesto(emp1);
		
		it.ingresarVehiculo(v9, true);
		it.abrirPuesto(emp1);
		it.ingresarVehiculo(v10, true);
		it.abrirPuesto(emp1);
		
		it.obtenerColaPuestoConEspacio();
		System.out.print("Numero de coches en la ITV "+it.obtenerNumeroVehiculosRestantes());
		it.moverVehiculosAColasPuestos();
		Puesto prueba[]=it.getPmotos();
		prueba[1].setEst(Puesto.estado.abiertoVacio);
		it.cerrarPuesto(prueba[1]);
		it.obtenerColaPuestoConEspacio();
		it.vaciarITV();
		it.obtenerColaPuestoConEspacio();
		//Cambio estado de puestos a cerrado,
		it.hacerRevisionParaCerrar();
		it.vaciarITV();
		it.obtenerColaPuestoConEspacio();
	}
	
}
