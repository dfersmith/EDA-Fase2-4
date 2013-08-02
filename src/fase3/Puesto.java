/**
 * @authors 
 * Danay Fernandez Martinez 100303618 
 * Luis Antonio Gonzalez Martin 100303620
 */
package fase3;
import fase1.*;


public class Puesto {

	
	private ColaPuesto cp;
	protected enum estado {cerrado, abiertoVacio, abiertoOcupado};
	protected Vehiculo.Categoria categ;
	private estado est;
	private Empleado emp; 
	
	public Puesto(Vehiculo.Categoria cat,estado est, Empleado emp) {
		
		this.categ=cat;
		this.est=est;
		this.cp=new ColaPuesto();
		this.emp=emp;
	}
	public Puesto(Vehiculo.Categoria cat,estado est) {
		
		this.categ=cat;
		this.est=est;
		this.cp=new ColaPuesto();
	
	}
	
	public estado getEstado() {
		return est;
	}
	public ColaPuesto getCp() {
		return cp;
	}
	public void setCp(ColaPuesto cp) {
		this.cp = cp;
	}
	public Vehiculo.Categoria getCateg() {
		return categ;
	}
	public void setCateg(Vehiculo.Categoria categ) {
		this.categ = categ;
	}
	
	public void setEst(estado est) {
		this.est = est;
	}
	public Empleado getEmp() {
		return emp;
	}
	public void setEmp(Empleado emp) {
		this.emp = emp;
	}

}
