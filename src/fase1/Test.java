package fase1;

import fase1.Propietario.TipoCarnet;
import fase1.Vehiculo.Categoria;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Test {
	
	public ColeccionVehiculos coleccionVehiculos;
 
	public ColeccionPropietarios propietarios;
	

	public Test() {
		coleccionVehiculos = new ColeccionVehiculos(10);
		propietarios = new ColeccionPropietarios(20);
	}
	
	/**
	 * Metodo que prueba la revision de vehiculos
	 */
	@SuppressWarnings("unused")
	public void probarRevision() {
		//Para simplificar por el momento suponemos que sólo hay dos empleados que 
		//realizan las revisiones

		Empleado emp1 = new Empleado("Paloma","Martinez Fernandez", "83543213A","02/09/1968", "01", "02/09/1992");
		Empleado emp2 = new Empleado("Lourdes","Moreno", "99543214B","30/03/1969", "02", "30/09/2002");
		Date fechaActual = new Date();
		SimpleDateFormat f= new SimpleDateFormat("dd/MM/yyyy");
		String hoy = f.format(fechaActual);
		
		//por el momento todos los revisa el primer empleado (pro simplificar)
		for (int i=0; i<coleccionVehiculos.getTamanyo();i++) {
			
			Ficha	ficha=new Ficha(coleccionVehiculos.getVehiculos()[i], hoy,emp1);
				//ficha.imprimir();

			
		}	
	}

	public void anyadirVehiculos(){
        /**
		 * Creamos los diez propietarios
		 */
		Propietario pro1 = new Propietario("Pedro","Ponce Garcia", "43543213A","21111960", null, TipoCarnet.A, "28011980");
		Propietario pro2 = new Propietario("Marta", "Lppez Munoz", "97634289P","01091982", null, TipoCarnet.B, "15022009");
		Propietario pro3 = new Propietario("Juan", "Ruiz Gonzalez", "23145763D","15041950", null, TipoCarnet.BTV, "09071970");
		Propietario pro4 = new Propietario("Olga", "Martinez Segura", "98760988U","28101940", null, TipoCarnet.B, "10031965");
		Propietario pro5 = new Propietario("Sofia", "Diaz Iglesia", "87453621F","05051990", null, TipoCarnet.A, "22082009");
		Propietario pro6 = new Propietario("Antonio", "Sanchez Perea", "56437897K","10091980", null, TipoCarnet.BTV, "06092010");
		Propietario pro7 = new Propietario("Ignacio", "Cuadra Albacete", "21389876L","12071967", null, TipoCarnet.B, "15101985");
		Propietario pro8 = new Propietario("Lucia", "Perez Suarez", "90879765N","18081948", null, TipoCarnet.A, "02111970");
		Propietario pro9 = new Propietario("Mercedes", "Hidalgo Romero", "33786908I","25041977", null, TipoCarnet.B, "08031996");
		Propietario pro10 = new Propietario("Julian", "Rodriguez Peralta", "65453987G","30011987", null, TipoCarnet.BTV, "13122005");
		propietarios.anyadirPropietario(pro1);
		propietarios.anyadirPropietario(pro2);
		propietarios.anyadirPropietario(pro3);
		propietarios.anyadirPropietario(pro4);
		propietarios.anyadirPropietario(pro5);
		propietarios.anyadirPropietario(pro6);
		propietarios.anyadirPropietario(pro7);
		propietarios.anyadirPropietario(pro8);
		propietarios.anyadirPropietario(pro9);
		propietarios.anyadirPropietario(pro10);

		/**
		 * Creamos los diez vehiculos
		 */

		//inicializamos un array con las piezas comunes a todos los veh�culos
		Pieza piezas[] ={new Direccion(true), new Freno(true), new Luz(true),  new Motor(true), new TuboDeEscape(true)};
		Rueda ruedas[] ={new Rueda(true), new Rueda(true), new Rueda(true),  new Rueda(true)};
		
		//el siguiente coche lo tendr� todo bien
		Vehiculo v1 = new Coche("Seat", "Ibiza", "Pistacho", 2006, 37098, 90, 112, "9876DRT", "6tdf34wsed2q", 5, 1123, Categoria.Coche, piezas, ruedas, pro1);
		coleccionVehiculos.anyadirVehiculo(v1);
		
	
		//Adem�s que tenga mal la segunda rueda
		ruedas[1].setEstado(false);
		
		Vehiculo v2 = new Coche("Opel", "Astra", "Azul", 1999, 132987, 150, 201, "M3456VG", "d43a2t5du78t", 4, 1324, Categoria.Coche, piezas, ruedas,pro2);
		coleccionVehiculos.anyadirVehiculo(v2);

		//Que lo tenga todo mal
		Pieza[] piezasMal ={new Direccion(false), new Freno(false), new Luz(false),  new Motor(false), new TuboDeEscape(false)};
		Rueda[] ruedasMal ={new Rueda(true), new Rueda(true), new Rueda(true),  new Rueda(true)};
		Vehiculo v3 = new Coche("Seat", "Leon", "Rojo", 1999, 140987, 170, 199, "B0936VG", "e0k8j7h987e3", 5, 1200, Categoria.Coche, piezasMal, ruedasMal, pro3);
		coleccionVehiculos.anyadirVehiculo(v3);
		
//		//Todo mal menos la direcci�n y la primera rueda
		piezasMal[0].setEstado(true);
		ruedasMal[0].setEstado(true);
		
		Vehiculo v4 = new Coche("Opel", "Vectra", "Verde", 2003, 99987, 90, 112, "9853VJG", "76g4ds43267h", 5, 1140, Categoria.Coche, piezas, ruedas, pro4);
		coleccionVehiculos.anyadirVehiculo(v4);
		
		//El cami�n va a tener 8 ruedas y todas van a estar mal
		Rueda[] ruedasCamion={new Rueda(true), new Rueda(true), new Rueda(true),  new Rueda(true), new Rueda(false), new Rueda(false)};
		Camion v5 = new Camion("Renault", "Gamme S180", "Blanco", 2000, 170438, 180, 201, "9876DFR", "987u678jh654", 3, 6110000, Categoria.Camion, piezas, ruedasCamion,pro5);
//		
//		//creamos un remolque de 4 ruedas (por defecto van a estar dos mal)
		Remolque r1 = new Remolque(1000,new Rueda[4]);
		//a�adimos el remolque al cami�n, antes de a�adirlo a la colecci�n
		v5.setRemolque(r1);
		coleccionVehiculos.anyadirVehiculo(v5);
//		
//		
//		Todas sus ruedas est�n mal
		Vehiculo v7 = new Furgoneta("Reanult", "Kangoo", "Blanco", 2007, 20987, 112, 197, "9876DTE", "98706bg43d12", 5, 1400, Categoria.Furgoneta, piezas, ruedas, 1500,pro7);
		coleccionVehiculos.anyadirVehiculo(v7);
		
		//cami�n tiene todo bien excepto motor y tubo de escape. 
		//Todas sus ruedas est�n mal
		Vehiculo v8 = new Camion("Mercedes", "1215C", "Blanco", 1997, 70984, 125, 205, "Z2314TG", "09876yu6b43x", 3, 200000, Categoria.Camion, piezas, ruedasCamion, pro8);
		coleccionVehiculos.anyadirVehiculo(v8);
//		
		//cami�n tiene todo bien excepto motor y tubo de escape. 
		//ruedas mal excepto la primera
		Vehiculo v9 = new Coche("Seat", "Ibiza", "Negro", 2000, 18796, 90, 197, "4656CVG", "2314t6yuhg87", 5, 1000, Categoria.Coche, piezas, ruedasMal, pro9);
		coleccionVehiculos.anyadirVehiculo(v9);
		
//		//las dos ruedas mal por defecto
		Rueda[] ruedasMoto={new Rueda(true), new Rueda(true)};
		Cadena c2 = new Cadena(true);//su cadena tambi�n
		Vehiculo v10 = new Motocicleta("Honda", "Transalp", "Gris", 2012, 5000, 60, 150, "6758HAX", "231467h65g4f", 30, Categoria.Motocicleta, piezas, ruedasMoto, c2, 2,pro10);
		coleccionVehiculos.anyadirVehiculo(v10);
//		
		
		//mostramos la colecci�n
	//	coleccionVehiculos.mostrar();
			
	}
		
	public void probarBusquedas(){

		
		System.out.println("Buscamos coches del propietario");
		coleccionVehiculos.buscarPropietario(propietarios.obtenerPropietario(0));
		System.out.println("-----------------------------------------------------");
		
		System.out.println("Buscamos rango de edad 18-28");
		coleccionVehiculos.buscarPropietarioPorEdad(18, 28);
		System.out.println("-----------------------------------------------------");

		System.out.println("Buscamos rango de edad 0-134");
		coleccionVehiculos.buscarPropietarioPorEdad(0, 134);
		System.out.println("-----------------------------------------------------");

		System.out.println("Buscamos pizas motor");
		coleccionVehiculos.buscarPiezaTipo(Pieza.TipoPieza.Motor);
		System.out.println("-----------------------------------------------------");
		
		System.out.println("Buscamos pizas direcci�n");
		coleccionVehiculos.buscarPiezaTipo(Pieza.TipoPieza.Direccion);
		System.out.println("-----------------------------------------------------");
		
		System.out.println("Buscamos pizas tubo de escape");
		coleccionVehiculos.buscarPiezaTipo(Pieza.TipoPieza.TuboDeEscape);
		System.out.println("-----------------------------------------------------");
		
		System.out.println("Buscamos pizas ruedas");
		coleccionVehiculos.buscarPiezaTipo(Pieza.TipoPieza.Rueda);
		System.out.println("-----------------------------------------------------");
		System.out.println("Buscamos año 1999");
		coleccionVehiculos.buscarVehiculoPorAnyo(1999);
		System.out.println("-----------------------------------------------------");
		
		System.out.println("Buscamos año 1345");
		coleccionVehiculos.buscarVehiculoPorAnyo(1345);
		System.out.println("-----------------------------------------------------");
	}
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Test t1 = new Test();
		t1.anyadirVehiculos();
		System.out.println("B�squedas....");
		t1.probarBusquedas();
		System.out.println("Revisión....");
		t1.probarRevision();
	}

}
