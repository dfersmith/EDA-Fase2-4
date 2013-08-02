package fase1;

public class Pieza {

	public enum TipoPieza {Cadena, Direccion, Freno, Luz, Motor, Rueda, TuboDeEscape}

	/**
	 * Variable que define el estado de la pieza, true ok, false mal estado
	 */
	protected boolean estado;
	
	protected TipoPieza tipo;
	/**
	 * Constructor por defecto que establece estado a false
	 */
	public Pieza() {
		estado = false;
	}


	
	/**
	 * Constructor con parametros
	 * @param estado estado que aplica a la pieza creada
	 */
	public Pieza(boolean estado, TipoPieza tipo) {
		this.estado = estado;
		this.tipo=tipo;
	}
	

	/**
	 * Metodo que revisa el estado de la pieza
	 * @return el estado en el que se encuentra la pieza
	 */
	public boolean revisar(){
		System.out.print("\tEstado del " + tipo.toString() + ":  ");
		if (estado) System.out.println("OK");
		else System.out.println("FALLO");
		
		return estado;
	}

	public TipoPieza getTipo() {
		return tipo;
	}

	public void setTipo(TipoPieza tipo) {
		this.tipo = tipo;
	}
	
	public void setEstado(boolean estado) {
		this.estado=estado;
	}
	
	public boolean getEstado() {
		return estado;
	}
}
