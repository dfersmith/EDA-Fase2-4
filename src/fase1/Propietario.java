package fase1;

public class Propietario extends Persona {

	public enum TipoCarnet {A,B,BTV};
	
	Vehiculo vehiculo;
	TipoCarnet tipoCarnet;
	String fechaObtencionCarnet;
	
	public Propietario() {
		super();
	}

	public Propietario(String nombre, String apellidos, String dni,
			String fechaNacimiento, Vehiculo v, TipoCarnet tipo, String fechaCarnet) {
		super(nombre,apellidos,dni,fechaNacimiento);
		vehiculo = v;
		tipoCarnet = tipo;
		fechaObtencionCarnet = fechaCarnet;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Propietario){
			Propietario p = (Propietario)obj;
			if(super.equals(obj)){
				if(fechaObtencionCarnet.equalsIgnoreCase(p.getFechaObtencionCarnet())){
					return true;
				}
			}
		}
		return false;
	}
	


	public TipoCarnet getTipoCarnet() {
		return tipoCarnet;
	}

	public void setTipoCarnet(TipoCarnet tipoCarnet) {
		this.tipoCarnet = tipoCarnet;
	}

	public String getFechaObtencionCarnet() {
		return fechaObtencionCarnet;
	}

	public void setFechaObtencionCarnet(String fechaObtencionCarnet) {
		this.fechaObtencionCarnet = fechaObtencionCarnet;
	}

	
}
