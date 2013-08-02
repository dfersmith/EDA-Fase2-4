/**
 * @authors 
 * Danay Fernandez Martinez 100303618 
 * Luis Antonio Gonzalez Martin 100303620
 */
package fase2;

import edalib.list.singlelink.*;
import fase1.*;

public interface Iarmario<E> {

    public void guardarFicha(E obj);

    public void ponerFichaOrdenada(E obj);

    public Ficha buscarFicha(String apellido, String matricula);

    public SList<Ficha> obtenerFicha(String eti);

    public SList<Ficha> vaciarArmario();
}
