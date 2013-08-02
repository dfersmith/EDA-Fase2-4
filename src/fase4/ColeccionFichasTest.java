/**
 * @authors 
 * Danay Fernandez Martinez 100303618 
 * Luis Antonio Gonzalez Martin 100303620
 */
package fase4;

import junit.framework.TestCase;

import org.junit.Test;

import edalib.list.singlelink.*;
import fase1.*;
import fase1.Propietario.TipoCarnet;
import fase1.Vehiculo.Categoria;
import fase2.*;


public class ColeccionFichasTest  extends TestCase {

	
	public Armario armario;
	
	public Pieza piezas1[] ={new Direccion(true), new Freno(true), new Luz(true),  new Motor(true), new TuboDeEscape(true)};
	public Rueda ruedas1[] ={new Rueda(true), new Rueda(true), new Rueda(true),  new Rueda(true)};
	
	public Propietario pro1 = new Propietario("Pedro","Ponce Garcia", "43543213A","21111960", null, TipoCarnet.A, "28011980");
	public Propietario pro2 = new Propietario("Marta", "Lopez Munoz", "97634289P","01091982", null, TipoCarnet.B, "15022009");
	public Propietario pro3 = new Propietario("Juan", "Ruiz Gonzalez", "23145763D","15041950", null, TipoCarnet.BTV, "09071970");
	public Propietario pro4 = new Propietario("Olga", "Martinez Segura", "98760988U","28101940", null, TipoCarnet.B, "10031965");
	public Propietario pro5 = new Propietario("Sofia", "Diaz Iglesia", "87453621F","05051990", null, TipoCarnet.A, "22082009");
	
	public String fechaRevision1 = "15/02/2013";
	public Empleado emp1 = new Empleado("Paloma","Martinez Fernandez", "83543213A","02/09/1968", "01", "02/09/1992");
	public Empleado emp2 = new Empleado("Lourdes","Moreno", "99543214B","30/03/1969", "02", "30/09/2002");
	public Vehiculo vehiculo1= new Vehiculo("Marca1","Modelo1","Color1", 2012, 209999, 120, 21, "Matricula1", "Bastidor1", 4, 900, Categoria.Coche, piezas1, ruedas1, pro1);
	public Vehiculo vehiculo2= new Vehiculo("Marca1","Modelo1","Color1", 2012, 209999, 120, 21, "Matricula1", "Bastidor1", 4, 900, Categoria.Coche, piezas1, ruedas1, pro2);
	public Vehiculo vehiculo3= new Vehiculo("Marca1","Modelo1","Color1", 2012, 209999, 120, 21, "Matricula1", "Bastidor1", 4, 900, Categoria.Coche, piezas1, ruedas1, pro3);
	public Vehiculo vehiculo4= new Vehiculo("Marca1","Modelo1","Color1", 2012, 209999, 120, 21, "Matricula1", "Bastidor1", 4, 900, Categoria.Coche, piezas1, ruedas1, pro4);
	public Vehiculo vehiculo5= new Vehiculo("Marca1","Modelo1","Color1", 2012, 209999, 120, 21, "Matricula1", "Bastidor1", 4, 900, Categoria.Coche, piezas1, ruedas1, pro5);
	
	public Ficha ficha1 = new Ficha(vehiculo1, fechaRevision1, emp1);
	
	public Ficha ficha2 = new Ficha(vehiculo2, fechaRevision1, emp2);
	public Ficha ficha3 = new Ficha(vehiculo3, "12/01/2001", emp1);
	public Ficha ficha4 = new Ficha(vehiculo4, "12/03/2010", emp2);
	public Ficha ficha5 = new Ficha(vehiculo5, fechaRevision1, emp1);
	
	
	public ColeccionFichasTest(String string) {
		super(string);
		armario = new Armario();
		armario.guardarFicha(ficha1);
		armario.guardarFicha(ficha2);
		armario.guardarFicha(ficha3);
		armario.ponerFichaOrdenada(ficha4);
		armario.ponerFichaOrdenada(ficha5);
	}
	/**
     * Test of mostrarFichas method, of class ColeccionFichas.
     */
    @Test
    public void testMostrarFichas() {
        System.out.println("mostrarFichas");
        ColeccionFichas instance = new ColeccionFichas(armario);
        instance.mostrarFichas();
        
        
    }

    /**
     * Test of obtenerFichaPorEmpleado method, of class ColeccionFichas.
     */
    @Test
    public void testObtenerFichaPorEmpleado() {
        System.out.println("obtenerFichaPorEmpleado");
        ColeccionFichas instance = new ColeccionFichas(armario);
       SList<Ficha> expResult = new SList<>();;
        expResult.addLast(ficha1);
        expResult.addLast(ficha3);
        expResult.addLast(ficha5);
       SList<Ficha> result = instance.obtenerFichaPorEmpleado(emp1);
        assertEquals(expResult.getSize(), result.getSize());
        
    }

}
