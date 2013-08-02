/**
 * @authors 
 * Danay Fernandez Martinez 100303618 
 * Luis Antonio Gonzalez Martin 100303620
 */
package fase3;

import fase1.*;

public interface IITV {
    
    
    //sacar sobrantes en orden -->Vaciar ITV
    
    //IngresarVehiculo(Cita true||false)
    public void ingresarVehiculo(Vehiculo ve, boolean cita);
    
    //Abrir puesto Inspeccion 
        //--Asignarle un empleado y tomar el vehiculo disponible para ser revilado y rellenar la cola del puesto
    public void abrirPuesto(Empleado emp);
    
    //CerrarPuesto
    public void cerrarPuesto(Puesto p);
    
    
    //Gestinonar moviento entre colas
    public void moverVehiculosAColasPuestos();
    
    //obtenerColaPuestoConEspacio
    public void obtenerColaPuestoConEspacio();
    
    //rellenarColasPuestos
    public void rellenarColasPuestos();
    
    
    //obtenerNumeroVehiculosRestantes
    public int obtenerNumeroVehiculosRestantes();
    
    //revisarSiguienteVehiculo
    public void revisarSiguienteVehiculo( Puesto p);
    
    //vaciarITV
    public void vaciarITV();
    
    
    //Hacer revision de los vehiculos que esten en puestos, pero sin pasar nuevos vehiculos
    //para cerrar puestos completamente para el cierre de la ITV, es decir antes de que salgan
    //los vehiculos uno a  uno por orden, primero cierro los puestos de los vehiculos sin que entre
    //uno mas ni se ordenen porque ya van a salir todos
    public void hacerRevisionParaCerrar();

}
