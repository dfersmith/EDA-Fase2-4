/**
 * @authors 
 * Danay Fernandez Martinez 100303618 
 * Luis Antonio Gonzalez Martin 100303620
 */
package fase2;

import edalib.list.singlelink.*;
import fase1.*;

public class Armario implements Iarmario<Ficha> {

    private Casilla casillas[] = new Casilla[27];

    public Armario() {

        String eti[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        for (int i = 0; i < casillas.length; i++) {
            Casilla casi = new Casilla();
            casi.setEtiqueta(eti[i]);
            casillas[i] = casi;
        }

    }

    public Casilla[] getCasillas() {
        return casillas;
    }

    public void setCasillas(Casilla[] casillas) {
        this.casillas = casillas;
    }

    @Override
    public void guardarFicha(Ficha f) {
        String eti = String.valueOf(f.getVehiculo().getPropietario().getApellidos().charAt(0));
        eti = eti.toUpperCase();

        switch (eti) {
            case "A":
                casillas[0].guardarFicha(f);
                break;
            case "B":
                casillas[1].guardarFicha(f);
                break;
            case "C":
                casillas[2].guardarFicha(f);
                break;
            case "D":
                casillas[3].guardarFicha(f);
                break;
            case "E":
                casillas[4].guardarFicha(f);
                break;
            case "F":
                casillas[5].guardarFicha(f);
                break;
            case "G":
                casillas[6].guardarFicha(f);
                break;
            case "H":
                casillas[7].guardarFicha(f);
                break;
            case "I":
                casillas[8].guardarFicha(f);
                break;
            case "J":
                casillas[9].guardarFicha(f);
                break;
            case "K":
                casillas[10].guardarFicha(f);
                break;
            case "L":
                casillas[11].guardarFicha(f);
                break;
            case "M":
                casillas[12].guardarFicha(f);
                break;
            case "N":
                casillas[13].guardarFicha(f);
                break;
            case "Ñ":
                casillas[14].guardarFicha(f);
                break;
            case "O":
                casillas[15].guardarFicha(f);
                break;
            case "P":
                casillas[16].guardarFicha(f);
                break;
            case "Q":
                casillas[17].guardarFicha(f);
                break;
            case "R":
                casillas[18].guardarFicha(f);
                break;
            case "S":
                casillas[19].guardarFicha(f);
                break;
            case "T":
                casillas[20].guardarFicha(f);
                break;
            case "U":
                casillas[21].guardarFicha(f);
                break;
            case "V":
                casillas[22].guardarFicha(f);
                break;
            case "W":
                casillas[23].guardarFicha(f);
                break;
            case "X":
                casillas[24].guardarFicha(f);
                break;
            case "Y":
                casillas[25].guardarFicha(f);
                break;
            case "Z":
                casillas[26].guardarFicha(f);
                break;

        }


    }

    @Override
    public void ponerFichaOrdenada(Ficha f) {

        String eti = String.valueOf(f.getVehiculo().getPropietario().getApellidos().charAt(0));
        eti = eti.toUpperCase();

        switch (eti) {
            case "A":
                casillas[0].guardarFichaOrdenada(f);
                break;
            case "B":
                casillas[1].guardarFichaOrdenada(f);
                break;
            case "C":
                casillas[2].guardarFichaOrdenada(f);
                break;
            case "D":
                casillas[3].guardarFichaOrdenada(f);
                break;
            case "E":
                casillas[4].guardarFichaOrdenada(f);
                break;
            case "F":
                casillas[5].guardarFichaOrdenada(f);
                break;
            case "G":
                casillas[6].guardarFichaOrdenada(f);
                break;
            case "H":
                casillas[7].guardarFichaOrdenada(f);
                break;
            case "I":
                casillas[8].guardarFichaOrdenada(f);
                break;
            case "J":
                casillas[9].guardarFichaOrdenada(f);
                break;
            case "K":
                casillas[10].guardarFichaOrdenada(f);
                break;
            case "L":
                casillas[11].guardarFichaOrdenada(f);
                break;
            case "M":
                casillas[12].guardarFichaOrdenada(f);
                break;
            case "N":
                casillas[13].guardarFichaOrdenada(f);
                break;
            case "Ñ":
                casillas[14].guardarFichaOrdenada(f);
                break;
            case "O":
                casillas[15].guardarFichaOrdenada(f);
                break;
            case "P":
                casillas[16].guardarFichaOrdenada(f);
                break;
            case "Q":
                casillas[17].guardarFichaOrdenada(f);
                break;
            case "R":
                casillas[18].guardarFichaOrdenada(f);
                break;
            case "S":
                casillas[19].guardarFichaOrdenada(f);
                break;
            case "T":
                casillas[20].guardarFichaOrdenada(f);
                break;
            case "U":
                casillas[21].guardarFichaOrdenada(f);
                break;
            case "V":
                casillas[22].guardarFichaOrdenada(f);
                break;
            case "W":
                casillas[23].guardarFichaOrdenada(f);
                break;
            case "X":
                casillas[24].guardarFichaOrdenada(f);
                break;
            case "Y":
                casillas[25].guardarFichaOrdenada(f);
                break;
            case "Z":
                casillas[26].guardarFichaOrdenada(f);
                break;

        }

    }

    @Override
    public Ficha buscarFicha(String apellido, String matricula) {

        String eti = String.valueOf(apellido.charAt(0));
        eti = eti.toUpperCase();

        switch (eti) {
            case "A":
                for (int i = 0; i < casillas[0].lista.getSize(); i++) {
                    if (apellido.equals(casillas[0].lista.getAt(i).getEmpleado().getApellidos()) && matricula.equals(casillas[0].lista.getAt(i).getVehiculo().getMatricula())) {
                        return casillas[0].lista.getAt(i);
                    }
                }

                break;
            case "B":
                for (int i = 0; i < casillas[1].lista.getSize(); i++) {
                    if (apellido.equals(casillas[1].lista.getAt(i).getEmpleado().getApellidos()) && matricula.equals(casillas[1].lista.getAt(i).getVehiculo().getMatricula())) {
                        return casillas[1].lista.getAt(i);
                    }
                }
                break;
            case "C":
                for (int i = 0; i < casillas[2].lista.getSize(); i++) {
                    if (apellido.equals(casillas[2].lista.getAt(i).getEmpleado().getApellidos()) && matricula.equals(casillas[2].lista.getAt(i).getVehiculo().getMatricula())) {
                        return casillas[2].lista.getAt(i);
                    }
                }
                break;
            case "D":
                for (int i = 0; i < casillas[3].lista.getSize(); i++) {
                    if (apellido.equals(casillas[3].lista.getAt(i).getEmpleado().getApellidos()) && matricula.equals(casillas[3].lista.getAt(i).getVehiculo().getMatricula())) {
                        return casillas[3].lista.getAt(i);
                    }
                }
                break;
            case "E":
                for (int i = 0; i < casillas[4].lista.getSize(); i++) {
                    if (apellido.equals(casillas[4].lista.getAt(i).getEmpleado().getApellidos()) && matricula.equals(casillas[4].lista.getAt(i).getVehiculo().getMatricula())) {
                        return casillas[4].lista.getAt(i);
                    }
                }
                break;
            case "F":
                for (int i = 0; i < casillas[5].lista.getSize(); i++) {
                    if (apellido.equals(casillas[5].lista.getAt(i).getEmpleado().getApellidos()) && matricula.equals(casillas[5].lista.getAt(i).getVehiculo().getMatricula())) {
                        return casillas[5].lista.getAt(i);
                    }
                }
                break;
            case "G":
                for (int i = 0; i < casillas[6].lista.getSize(); i++) {
                    if (apellido.equals(casillas[6].lista.getAt(i).getEmpleado().getApellidos()) && matricula.equals(casillas[6].lista.getAt(i).getVehiculo().getMatricula())) {
                        return casillas[6].lista.getAt(i);
                    }
                }
                break;
            case "H":
                for (int i = 0; i < casillas[7].lista.getSize(); i++) {
                    if (apellido.equals(casillas[7].lista.getAt(i).getEmpleado().getApellidos()) && matricula.equals(casillas[7].lista.getAt(i).getVehiculo().getMatricula())) {
                        return casillas[7].lista.getAt(i);
                    }
                }
                break;
            case "I":
                for (int i = 0; i < casillas[8].lista.getSize(); i++) {
                    if (apellido.equals(casillas[8].lista.getAt(i).getEmpleado().getApellidos()) && matricula.equals(casillas[8].lista.getAt(i).getVehiculo().getMatricula())) {
                        return casillas[8].lista.getAt(i);
                    }
                }
                break;
            case "J":
                for (int i = 0; i < casillas[9].lista.getSize(); i++) {
                    if (apellido.equals(casillas[9].lista.getAt(i).getEmpleado().getApellidos()) && matricula.equals(casillas[9].lista.getAt(i).getVehiculo().getMatricula())) {
                        return casillas[9].lista.getAt(i);
                    }
                }
                break;
            case "K":
                for (int i = 0; i < casillas[10].lista.getSize(); i++) {
                    if (apellido.equals(casillas[10].lista.getAt(i).getEmpleado().getApellidos()) && matricula.equals(casillas[10].lista.getAt(i).getVehiculo().getMatricula())) {
                        return casillas[10].lista.getAt(i);
                    }
                }
                break;
            case "L":
                for (int i = 0; i < casillas[11].lista.getSize(); i++) {
                    if (apellido.equals(casillas[11].lista.getAt(i).getEmpleado().getApellidos()) && matricula.equals(casillas[11].lista.getAt(i).getVehiculo().getMatricula())) {
                        return casillas[11].lista.getAt(i);
                    }
                }
                break;
            case "M":
                for (int i = 0; i < casillas[12].lista.getSize(); i++) {
                    if (apellido.equals(casillas[12].lista.getAt(i).getEmpleado().getApellidos()) && matricula.equals(casillas[12].lista.getAt(i).getVehiculo().getMatricula())) {
                        return casillas[12].lista.getAt(i);
                    }
                }
                break;
            case "N":
                for (int i = 0; i < casillas[13].lista.getSize(); i++) {
                    if (apellido.equals(casillas[13].lista.getAt(i).getEmpleado().getApellidos()) && matricula.equals(casillas[13].lista.getAt(i).getVehiculo().getMatricula())) {
                        return casillas[13].lista.getAt(i);
                    }
                }
                break;
            case "Ñ":
                for (int i = 0; i < casillas[14].lista.getSize(); i++) {
                    if (apellido.equals(casillas[14].lista.getAt(i).getEmpleado().getApellidos()) && matricula.equals(casillas[14].lista.getAt(i).getVehiculo().getMatricula())) {
                        return casillas[14].lista.getAt(i);
                    }
                }
                break;
            case "O":
                for (int i = 0; i < casillas[15].lista.getSize(); i++) {
                    if (apellido.equals(casillas[15].lista.getAt(i).getEmpleado().getApellidos()) && matricula.equals(casillas[15].lista.getAt(i).getVehiculo().getMatricula())) {
                        return casillas[15].lista.getAt(i);
                    }
                }
                break;
            case "P":
                for (int i = 0; i < casillas[16].lista.getSize(); i++) {
                    if (apellido.equals(casillas[16].lista.getAt(i).getEmpleado().getApellidos()) && matricula.equals(casillas[16].lista.getAt(i).getVehiculo().getMatricula())) {
                        return casillas[16].lista.getAt(i);
                    }
                }
                break;
            case "Q":
                for (int i = 0; i < casillas[17].lista.getSize(); i++) {
                    if (apellido.equals(casillas[17].lista.getAt(i).getEmpleado().getApellidos()) && matricula.equals(casillas[17].lista.getAt(i).getVehiculo().getMatricula())) {
                        return casillas[17].lista.getAt(i);
                    }
                }
                break;
            case "R":
                for (int i = 0; i < casillas[18].lista.getSize(); i++) {
                    if (apellido.equals(casillas[18].lista.getAt(i).getEmpleado().getApellidos()) && matricula.equals(casillas[18].lista.getAt(i).getVehiculo().getMatricula())) {
                        return casillas[18].lista.getAt(i);
                    }
                }
                break;
            case "S":
                for (int i = 0; i < casillas[19].lista.getSize(); i++) {
                    if (apellido.equals(casillas[19].lista.getAt(i).getEmpleado().getApellidos()) && matricula.equals(casillas[19].lista.getAt(i).getVehiculo().getMatricula())) {
                        return casillas[19].lista.getAt(i);
                    }
                }
                break;
            case "T":
                for (int i = 0; i < casillas[20].lista.getSize(); i++) {
                    if (apellido.equals(casillas[20].lista.getAt(i).getEmpleado().getApellidos()) && matricula.equals(casillas[20].lista.getAt(i).getVehiculo().getMatricula())) {
                        return casillas[20].lista.getAt(i);
                    }
                }
                break;
            case "U":
                for (int i = 0; i < casillas[21].lista.getSize(); i++) {
                    if (apellido.equals(casillas[21].lista.getAt(i).getEmpleado().getApellidos()) && matricula.equals(casillas[21].lista.getAt(i).getVehiculo().getMatricula())) {
                        return casillas[21].lista.getAt(i);
                    }
                }
                break;
            case "V":
                for (int i = 0; i < casillas[22].lista.getSize(); i++) {
                    if (apellido.equals(casillas[22].lista.getAt(i).getEmpleado().getApellidos()) && matricula.equals(casillas[22].lista.getAt(i).getVehiculo().getMatricula())) {
                        return casillas[22].lista.getAt(i);
                    }
                }
                break;
            case "W":
                for (int i = 0; i < casillas[23].lista.getSize(); i++) {
                    if (apellido.equals(casillas[23].lista.getAt(i).getEmpleado().getApellidos()) && matricula.equals(casillas[23].lista.getAt(i).getVehiculo().getMatricula())) {
                        return casillas[23].lista.getAt(i);
                    }
                }
                break;
            case "X":
                for (int i = 0; i < casillas[24].lista.getSize(); i++) {
                    if (apellido.equals(casillas[24].lista.getAt(i).getEmpleado().getApellidos()) && matricula.equals(casillas[24].lista.getAt(i).getVehiculo().getMatricula())) {
                        return casillas[24].lista.getAt(i);
                    }
                }
                break;
            case "Y":
                for (int i = 0; i < casillas[25].lista.getSize(); i++) {
                    if (apellido.equals(casillas[25].lista.getAt(i).getEmpleado().getApellidos()) && matricula.equals(casillas[25].lista.getAt(i).getVehiculo().getMatricula())) {
                        return casillas[25].lista.getAt(i);
                    }
                }
                break;
            case "Z":
                for (int i = 0; i < casillas[26].lista.getSize(); i++) {
                    if (apellido.equals(casillas[26].lista.getAt(i).getEmpleado().getApellidos()) && matricula.equals(casillas[26].lista.getAt(i).getVehiculo().getMatricula())) {
                        return casillas[26].lista.getAt(i);
                    }
                }
                break;

        }
        return null;

    }

    //Para obtener las fichas de una casilla es necesario decir la etiqueta (Letra = a, b , c, d...)
    @Override
    public SList<Ficha> obtenerFicha(String eti) {

        eti = eti.toUpperCase();

        switch (eti) {
            case "A":
                return casillas[0].lista;
            case "B":
                return casillas[1].lista;
            case "C":
                return casillas[2].lista;
            case "D":
                return casillas[3].lista;
            case "E":
                return casillas[4].lista;
            case "F":
                return casillas[5].lista;
            case "G":
                return casillas[6].lista;
            case "H":
                return casillas[7].lista;
            case "I":
                return casillas[8].lista;
            case "J":
                return casillas[9].lista;
            case "K":
                return casillas[10].lista;
            case "L":
                return casillas[11].lista;
            case "M":
                return casillas[12].lista;
            case "N":
                return casillas[13].lista;
            case "Ñ":
                return casillas[14].lista;
            case "O":
                return casillas[15].lista;
            case "P":
                return casillas[16].lista;
            case "Q":
                return casillas[17].lista;
            case "R":
                return casillas[18].lista;
            case "S":
                return casillas[19].lista;
            case "T":
                return casillas[20].lista;
            case "U":
                return casillas[21].lista;
            case "V":
                return casillas[22].lista;
            case "W":
                return casillas[23].lista;
            case "X":
                return casillas[24].lista;
            case "Y":
                return casillas[25].lista;
            case "Z":
                return casillas[26].lista;

        }

        return null;
    }

    /**
     *
     * @return
     */
    public SList<Ficha> vaciarArmario() {
        SList<Ficha> granLista = new SList<Ficha>();

        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].lista.getSize(); j++) {
                granLista.addLast(casillas[i].lista.getAt(j));
            }
            SList<Ficha> enBlanco = new SList<>();
            casillas[i].lista = enBlanco;
        }

        return granLista;
    }

    public SList<Ficha> obtenerListaArmario() {
        SList<Ficha> granLista = new SList<Ficha>();


        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].lista.getSize(); j++) {
                granLista.addLast(casillas[i].lista.getAt(j));
            }
        }

        return granLista;

    }
}
