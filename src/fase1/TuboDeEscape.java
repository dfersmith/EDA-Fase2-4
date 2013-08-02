package fase1;

public class TuboDeEscape extends Pieza {

	public TuboDeEscape() {
		super();
	}

	public TuboDeEscape(boolean estado) {
		super(estado,TipoPieza.TuboDeEscape);
	}

	/**
	 * Metodo que revisa el estado de la pieza
	 * @return el estado en el que se encuentra la pieza
	 */
	public boolean revisar(){
		System.out.println("Se esta revisando el tubo de escape");
		return super.revisar();
	}

}
