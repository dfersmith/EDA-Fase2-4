/**
 * @authors 
 * Danay Fernandez Martinez 100303618 
 * Luis Antonio Gonzalez Martin 100303620
 */
package fase4;


import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.Test;

import edalib.tree.bstree.BSTNode;
import fase1.Direccion;
import fase1.Empleado;
import fase1.Ficha;
import fase1.Freno;
import fase1.Luz;
import fase1.Motor;
import fase1.Pieza;
import fase1.Propietario;
import fase1.Rueda;
import fase1.TuboDeEscape;
import fase1.Vehiculo;
import fase1.Propietario.TipoCarnet;
import fase1.Vehiculo.Categoria;
import fase2.Armario;


public class ArbolFichasPorPropietarioTest extends TestCase {
	public Armario armario;

	public Pieza piezas1[] = { new Direccion(true), new Freno(true),
			new Luz(true), new Motor(true), new TuboDeEscape(true) };
	public Rueda ruedas1[] = { new Rueda(true), new Rueda(true),
			new Rueda(true), new Rueda(true) };

	public Propietario pro1 = new Propietario("Pedro", "Ponce Garcia",
			"43543213A", "21111960", null, TipoCarnet.A, "28011980");
	public Propietario pro2 = new Propietario("Marta", "Lopez Munoz",
			"97634289P", "01091982", null, TipoCarnet.B, "15022009");
	public Propietario pro3 = new Propietario("Juan", "Ruiz Gonzalez",
			"23145763D", "15041950", null, TipoCarnet.BTV, "09071970");
	public Propietario pro4 = new Propietario("Olga", "Martinez Segura",
			"98760988U", "28101940", null, TipoCarnet.B, "10031965");
	public Propietario pro5 = new Propietario("Sofia", "Diaz Iglesia",
			"87453621F", "05051990", null, TipoCarnet.A, "22082009");

	public String fechaRevision1 = "15/02/2013";
	public Empleado emp1 = new Empleado("Paloma", "Martinez Fernandez",
			"83543213A", "02/09/1968", "01", "02/09/1992");
	public Empleado emp2 = new Empleado("Lourdes", "Moreno", "99543214B",
			"30/03/1969", "02", "30/09/2002");
	public Vehiculo vehiculo1 = new Vehiculo("Marca1", "Modelo1", "Color1",
			2012, 209999, 120, 21, "Matricula1", "Bastidor1", 4, 900,
			Categoria.Coche, piezas1, ruedas1, pro1);
	public Vehiculo vehiculo2 = new Vehiculo("Marca1", "Modelo1", "Color1",
			2012, 209999, 120, 21, "Matricula1", "Bastidor1", 4, 900,
			Categoria.Coche, piezas1, ruedas1, pro2);
	public Vehiculo vehiculo3 = new Vehiculo("Marca1", "Modelo1", "Color1",
			2012, 209999, 120, 21, "Matricula1", "Bastidor1", 4, 900,
			Categoria.Coche, piezas1, ruedas1, pro3);
	public Vehiculo vehiculo4 = new Vehiculo("Marca1", "Modelo1", "Color1",
			2012, 209999, 120, 21, "Matricula1", "Bastidor1", 4, 900,
			Categoria.Coche, piezas1, ruedas1, pro4);
	public Vehiculo vehiculo5 = new Vehiculo("Marca1", "Modelo1", "Color1",
			2012, 209999, 120, 21, "Matricula1", "Bastidor1", 4, 900,
			Categoria.Coche, piezas1, ruedas1, pro5);

	public Ficha ficha1 = new Ficha(vehiculo1, fechaRevision1, emp1);

	public Ficha ficha2 = new Ficha(vehiculo2, fechaRevision1, emp2);
	public Ficha ficha3 = new Ficha(vehiculo3, "12/01/2001", emp1);
	public Ficha ficha4 = new Ficha(vehiculo4, "12/03/2010", emp2);
	public Ficha ficha5 = new Ficha(vehiculo5, fechaRevision1, emp1);

	public ArbolFichasPorPropietarioTest(String string) {
		super(string);
		armario = new Armario();
		armario.guardarFicha(ficha1);
		armario.guardarFicha(ficha2);
		armario.guardarFicha(ficha3);
		armario.ponerFichaOrdenada(ficha4);
		armario.ponerFichaOrdenada(ficha5);
		
	}

	/**
	 * Test of mostrarArbol method, of class ArbolFichasPorPropietario.
	 */

	@Test
	public void testMostrarArbol() {
		System.out.println("mostrarArbol");
		ColeccionFichas cFichas = new ColeccionFichas(armario);
		ArbolFichasPorPropietario instance = new ArbolFichasPorPropietario(cFichas);
		BSTNode<String, Ficha> nodo = instance.getRoot();
		instance.mostrarArbol(nodo);
		
	}

	/**
	 * Test of mostrarFichasPropietario method, of class
	 * ArbolFichasPorPropietario.
	 */
	@Test
	public void testMostrarFichasPropietario() {
		System.out.println("mostrarFichasPropietario");
		ColeccionFichas cFichas = new ColeccionFichas(armario);
		String propietario = "Juan";
		ArbolFichasPorPropietario instance = new ArbolFichasPorPropietario(cFichas);
		BSTNode<String, Ficha> nodo = instance.getRoot();
		instance.mostrarFichasPropietario(nodo,propietario);
		
		
	}

	/**
	 * Test of mostrarFichasRango method, of class ArbolFichasPorPropietario.
	 */
	@Test
	public void testMostrarFichasRango() {
		System.out.println("mostrarFichasRango");
		int fecha1 = 2000;
		int fecha2 = 2010;
		ColeccionFichas cFichas = new ColeccionFichas(armario);
		ArbolFichasPorPropietario instance = new ArbolFichasPorPropietario(cFichas);
		ColeccionFichas result = instance.mostrarFichasRango(fecha1, fecha2);
		assertEquals(3, result.getSize());
		
	}

	public static TestSuite suite() {
		TestSuite suite = new TestSuite("ColeccionFichas");
		
		TestSuite suiteA = new TestSuite("suiteMostrarArbol");
		TestSuite suiteB = new TestSuite("suiteMostrarFichasPropietario");
		TestSuite suiteC = new TestSuite("suiteMostrarFichasRango");

		suiteA.addTest(new ArbolFichasPorPropietarioTest("testMostrarArbol"));
		suiteB.addTest(new ArbolFichasPorPropietarioTest(
				"testMostrarFichasPropietario"));
		suiteC.addTest(new ArbolFichasPorPropietarioTest(
				"testMostrarFichasRango"));
		suite.addTest(suiteA);
		suite.addTest(suiteB);
		suite.addTest(suiteC);
		return suite;
	}

}
