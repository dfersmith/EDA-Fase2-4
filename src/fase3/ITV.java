/**
 * @authors 
 * Danay Fernandez Martinez 100303618 
 * Luis Antonio Gonzalez Martin 100303620
 */
package fase3;

import fase1.Empleado;
import fase1.Vehiculo;
import fase3.Puesto.estado;

public class ITV implements IITV {
    
        private int NpuestosMoto;
        private int Npuestos3500;
        private int NpuestosNormal;
        private ColaITV citaCITV;
        private ColaITV NocitaCITV;
        private Puesto[] pmotos;
        private Puesto[] pnormal;
        private Puesto[] n3500;
    
        /*Se introduce el numero de puestos en int y automaticamente la calse puestos se crea las colas correspondientes para cada N puestos
        al igual que se crean las colas exteriores
        */
	public ITV(int NpuestosMoto, int Npuestos3500, int NpuestosNormal) {
        
        this.NpuestosMoto = NpuestosMoto;
        this.Npuestos3500 = Npuestos3500;
        this.NpuestosNormal = NpuestosNormal;
        
            //Control de que sean creados un puesto de cada modalidad :
            if(NpuestosMoto < 1) {
                System.out.println("Como minimo tiene que haber un puesto de moto, se creara  uno");
                this.NpuestosMoto = 1;
            }
            
            if(Npuestos3500 < 1) {
                System.out.println("Como minimo tiene que haber un puesto de 3500, se creara  uno");
                this.Npuestos3500 = 1;
            }
            
            if(NpuestosNormal < 1) {
                System.out.println("Como minimo tiene que haber un puesto de Normal, se creara  uno");
                this.NpuestosNormal = 1;
            }
            
        this.pmotos=new Puesto[NpuestosMoto];
        for(int i=0;i<NpuestosMoto;i++) {
        	
        	pmotos[i]=new Puesto(Vehiculo.Categoria.Motocicleta, Puesto.estado.cerrado);
        }
        
        this.pnormal=new Puesto[NpuestosNormal];
        for(int i=0;i<NpuestosNormal;i++) {
        	
        	pnormal[i]=new Puesto(Vehiculo.Categoria.Coche, Puesto.estado.cerrado);
        }
        
        this.n3500=new Puesto[Npuestos3500];
        for(int i=0;i<Npuestos3500;i++) {
        	
        	n3500[i]=new Puesto(Vehiculo.Categoria.Camion, Puesto.estado.cerrado);
        }
        citaCITV=new ColaITV();
        NocitaCITV=new ColaITV();
		
	}

    
    @Override
    public void ingresarVehiculo(Vehiculo ve, boolean cita) {
    
    	if(cita){
    		citaCITV.enqueue(ve);
    	}else {
    		NocitaCITV.enqueue(ve);
    	}
    }

    @Override
    /*Como hay diferentes tipos de puestos (motos, camiones, coches), 
    He determinaod que a la hora de abrir un puesto, se abre el puesto correspondiente
    al tipo de vehiculo que hay en la cola de Cita Previa y si está vacia en el tipo de vehiculo de la cola de sin cita.
    En caso de que no haya puestos creados suficientemente se indicara por System.out.println("No hay puestos suficientes");
    */
    public void abrirPuesto(Empleado emp) {
        
    	if(citaCITV.getSize()<=0)   //Si no hay en la cola de cita previa
    	{
    		
    		if(NocitaCITV.getSize()<=0)  //se mira en la de sin cinta 
    		{
    			System.out.println("No  hay vehiculos en las colas");  //Si no hay en ninguna, ni en la cita ni en la de sin cita
    		}
    		else { //Si si hay en la de Si Cita
    			
    			Vehiculo.Categoria cat=NocitaCITV.front().getCategoria();
    			
    			if(Vehiculo.Categoria.Motocicleta.equals(cat)) {
    				
    				boolean tiene=false; //variable para que se asigne una vez y para ver si hay puesto de esa categoria cerrado para abrir
    				for(int i=0;i<pmotos.length;i++) {
    					if(pmotos[i].getEstado().equals(Puesto.estado.cerrado) && !tiene) {
    						pmotos[i].setEst(Puesto.estado.abiertoOcupado);
    						pmotos[i].setEmp(emp);
    						tiene=true;
    						//Add de colaITV a puesto
    						pmotos[i].getCp().enqueue(NocitaCITV.dequeue());
    					}
    				}
    				if(!tiene) System.out.println("No hay puestos disponibles para abrir");
    				
    			}
    			
    			if(Vehiculo.Categoria.Camion.equals(cat)) {
    				
    				boolean tiene=false; //variable para que se asigne una vez y para ver si hay puesto de esa categoria cerrado para abrir
    				for(int i=0;i<n3500.length;i++) {
    					if(n3500[i].getEstado().equals(Puesto.estado.cerrado) && !tiene) {
    						n3500[i].setEst(Puesto.estado.abiertoOcupado);
    						n3500[i].setEmp(emp);
    						tiene=true;
    						//Add de colaITV a puesto
    						n3500[i].getCp().enqueue(NocitaCITV.dequeue());
    					}
    				}
    				if(!tiene) System.out.println("No hay puestos disponibles para abrir");
    			}
    			
    			if(Vehiculo.Categoria.Coche.equals(cat)) {
    				
    				boolean tiene=false; //variable para que se asigne una vez y para ver si hay puesto de esa categoria cerrado para abrir
    				for(int i=0;i<pnormal.length;i++) {
    					if(pnormal[i].getEstado().equals(Puesto.estado.cerrado) && !tiene) {
    						pnormal[i].setEst(Puesto.estado.abiertoOcupado);
    						pnormal[i].setEmp(emp);
    						tiene=true;
    						//Add de colaITV a puesto
    						pnormal[i].getCp().enqueue(NocitaCITV.dequeue());
    					}
    				}
    				if(!tiene) System.out.println("No hay puestos disponibles para abrir");
	
    			}

    			 	 
    		}
    		
    		
    	}else { //Si si hay en la de cita previa
    		
    		Vehiculo.Categoria cat=citaCITV.front().getCategoria();
			
			if(Vehiculo.Categoria.Motocicleta.equals(cat)) {
				
				boolean tiene=false; //variable para que se asigne una vez y para ver si hay puesto de esa categoria cerrado para abrir
				for(int i=0;i<pmotos.length;i++) {
					if(pmotos[i].getEstado().equals(Puesto.estado.cerrado) && !tiene) {
						pmotos[i].setEst(Puesto.estado.abiertoOcupado);
						pmotos[i].setEmp(emp);
						tiene=true;
						//Add de colaITV a puesto
						pmotos[i].getCp().enqueue(citaCITV.dequeue());
					}
				}
				if(!tiene) System.out.println("No hay puestos disponibles para abrir");
				
			}
			
			if(Vehiculo.Categoria.Camion.equals(cat)) {
				
				boolean tiene=false; //variable para que se asigne una vez y para ver si hay puesto de esa categoria cerrado para abrir
				for(int i=0;i<n3500.length;i++) {
					if(n3500[i].getEstado().equals(Puesto.estado.cerrado) && !tiene) {
						n3500[i].setEst(Puesto.estado.abiertoOcupado);
						n3500[i].setEmp(emp);
						tiene=true;
						//Add de colaITV a puesto
						n3500[i].getCp().enqueue(citaCITV.dequeue());
					}
				}
				if(!tiene) System.out.println("No hay puestos disponibles para abrir");
			}
			
			if(Vehiculo.Categoria.Coche.equals(cat)) {
				
				boolean tiene=false; //variable para que se asigne una vez y para ver si hay puesto de esa categoria cerrado para abrir
				for(int i=0;i<pnormal.length;i++) {
					if(pnormal[i].getEstado().equals(Puesto.estado.cerrado) && !tiene) {
						pnormal[i].setEst(Puesto.estado.abiertoOcupado);
						pnormal[i].setEmp(emp);
						tiene=true;
						//Add de colaITV a puesto
						pnormal[i].getCp().enqueue(citaCITV.dequeue());
					}
				}
				if(!tiene) System.out.println("No hay puestos disponibles para abrir");

			}
    		
    		
    	}
    	
    }

    
    
    @Override
    public void cerrarPuesto(Puesto p) {
    
    	boolean sePuede=true;
    	if(!NocitaCITV.isEmpty() || !citaCITV.isEmpty()) {
    		System.out.println("La colas de cita previa y sin cita No estan vacias");
    		sePuede=false;
    	}
    	if(p.getEstado().equals(Puesto.estado.cerrado) ){
    		System.out.println("El puesto ya estaba cerrado");
    		sePuede=false;
    	}
    	if(p.getEstado().equals(Puesto.estado.abiertoOcupado) ){
    		System.out.println("El puesto esta ocupado");
    		sePuede=false;
    	}
    	
    	if(sePuede ) {
    		
    		if(p.getCateg().equals(Vehiculo.Categoria.Motocicleta)) {
    			for(int i=0;i<pmotos.length;i++) {
    				if(!pmotos[i].getEstado().equals(Puesto.estado.cerrado)&& !p.getCp().isEmpty() ) {
    		    			for(int j=0;j<pmotos[i].getCp().getSize();j++) {
    		    				pmotos[i].getCp().enqueue(p.getCp().dequeue());
    		    			}
    						
    				}
    			}
    		}
    		
    		if(p.getCateg().equals(Vehiculo.Categoria.Camion) || p.getCateg().equals(Vehiculo.Categoria.Furgoneta)) {
    			for(int i=0;i<n3500.length;i++) {
    				if(!n3500[i].getEstado().equals(Puesto.estado.cerrado)&& !p.getCp().isEmpty()) {
    					for(int j=0;j<n3500[i].getCp().getSize();j++) {
    						n3500[i].getCp().enqueue(p.getCp().dequeue());
		    			}
    					
    				}
    			}
    		}
    		
    		if(p.getCateg().equals(Vehiculo.Categoria.Coche)) {
    			for(int i=0;i<pnormal.length;i++) {
    				if(!pnormal[i].getEstado().equals(Puesto.estado.cerrado)&& !p.getCp().isEmpty()) {
    					for(int j=0;j<pnormal[i].getCp().getSize();j++) {
    						pnormal[i].getCp().enqueue(p.getCp().dequeue());
		    			}
    				}
    			}
    		}
    		
    		
    		if(p.getCp().getSize()==0) {
    			p.setEst(estado.cerrado);
        		System.out.println("El puesto ha sido cerrado");
    		}else {
    			System.out.println("El puesto No ha sido cerrado no hay hueco en las colas de los demas puestos");
    		}
    		
    	}
    	
    }

    public int getNpuestosMoto() {
		return NpuestosMoto;
	}


	public void setNpuestosMoto(int npuestosMoto) {
		NpuestosMoto = npuestosMoto;
	}


	public int getNpuestos3500() {
		return Npuestos3500;
	}


	public void setNpuestos3500(int npuestos3500) {
		Npuestos3500 = npuestos3500;
	}


	public int getNpuestosNormal() {
		return NpuestosNormal;
	}


	public void setNpuestosNormal(int npuestosNormal) {
		NpuestosNormal = npuestosNormal;
	}


	public ColaITV getCitaCITV() {
		return citaCITV;
	}


	public void setCitaCITV(ColaITV citaCITV) {
		this.citaCITV = citaCITV;
	}


	public ColaITV getNocitaCITV() {
		return NocitaCITV;
	}


	public void setNocitaCITV(ColaITV nocitaCITV) {
		NocitaCITV = nocitaCITV;
	}


	public Puesto[] getPmotos() {
		return pmotos;
	}


	public void setPmotos(Puesto[] pmotos) {
		this.pmotos = pmotos;
	}


	public Puesto[] getPnormal() {
		return pnormal;
	}


	public void setPnormal(Puesto[] pnormal) {
		this.pnormal = pnormal;
	}


	public Puesto[] getN3500() {
		return n3500;
	}


	public void setN3500(Puesto[] n3500) {
		this.n3500 = n3500;
	}


	@Override
    public void moverVehiculosAColasPuestos() {
    	
    	
    	
    	//Primero se gestiona la cola con CitaPrevia
    	
    	for(int i=0;i<citaCITV.getSize();i++) {
    		
    		//Si  es moto
    		if(citaCITV.front().getCategoria().equals(Vehiculo.Categoria.Motocicleta)) {
    			
    			boolean hecho=false;
    			for(int j=0;j<pmotos.length;j++) {
    				
    				if(pmotos[j].getEstado().equals(Puesto.estado.abiertoVacio) && !hecho) {
    					
    					pmotos[j].getCp().enqueue(citaCITV.dequeue());
    					hecho=true;
    				}
    			}
    		}
    		
    		//Si  es de mas de 3500 kg, es decir coche o furgo
    		if(citaCITV.front().getCategoria().equals(Vehiculo.Categoria.Camion) || citaCITV.front().getCategoria().equals(Vehiculo.Categoria.Furgoneta) ) {
    			
    			boolean hecho=false;
    			for(int j=0;j<n3500.length;j++) {
    				
    				if(n3500[j].getEstado().equals(Puesto.estado.abiertoVacio) && !hecho) {
    					
    					n3500[j].getCp().enqueue(citaCITV.dequeue());
    					hecho=true;
    				}
    			}
    		}
    		
    		//Si es un coche
    		if(citaCITV.front().getCategoria().equals(Vehiculo.Categoria.Coche) ) {
    			
    			boolean hecho=false;
    			for(int j=0;j<pnormal.length;j++) {
    				
    				if(pnormal[j].getEstado().equals(Puesto.estado.abiertoVacio) && !hecho) {
    					
    					pnormal[j].getCp().enqueue(citaCITV.dequeue());
    					hecho=true;
    				}
    			}
    		}
    		
    	}
    	
    	
    	//Ahora los que no tiene cita previa
    	
    	for(int i=0;i<NocitaCITV.getSize();i++) {
    		
    		//Si  es moto
    		if(NocitaCITV.front().getCategoria().equals(Vehiculo.Categoria.Motocicleta)) {
    			
    			boolean hecho=false;
    			for(int j=0;j<pmotos.length;j++) {
    				
    				if(pmotos[j].getEstado().equals(Puesto.estado.abiertoVacio) && !hecho) {
    					
    					pmotos[j].getCp().enqueue(NocitaCITV.dequeue());
    					hecho=true;
    				}
    			}
    		}
    		
    		//Si  es de mas de 3500 kg, es decir coche o furgo
    		if(NocitaCITV.front().getCategoria().equals(Vehiculo.Categoria.Camion) || NocitaCITV.front().getCategoria().equals(Vehiculo.Categoria.Furgoneta) ) {
    			
    			boolean hecho=false;
    			for(int j=0;j<n3500.length;j++) {
    				
    				if(n3500[j].getEstado().equals(Puesto.estado.abiertoVacio) && !hecho) {
    					
    					n3500[j].getCp().enqueue(NocitaCITV.dequeue());
    					hecho=true;
    				}
    			}
    		}
    		
    		//Si es un coche
    		if(NocitaCITV.front().getCategoria().equals(Vehiculo.Categoria.Coche) ) {
    			
    			boolean hecho=false;
    			for(int j=0;j<pnormal.length;j++) {
    				
    				if(pnormal[j].getEstado().equals(Puesto.estado.abiertoVacio) && !hecho) {
    					
    					pnormal[j].getCp().enqueue(NocitaCITV.dequeue());
    					hecho=true;
    				}
    			}
    		}
    	}
       
    }

    @Override
    public void obtenerColaPuestoConEspacio() {
       
    	
    	for(int i=0;i<pmotos.length;i++) {
    		//System.out.println(pmotos[i].getCp().getSize());
    		if(pmotos[i].getCp().getSize()!=3) {
    			System.out.println("En el puesto de motos "+i+" hay "+(pmotos[i].getCp().getSize()-3)*-1+" plazas libres en su cola");
    		}
    	}
    
    	for(int i=0;i<n3500.length;i++) {
    		//System.out.println(pmotos[i].getCp().getSize());
    		if(n3500[i].getCp().getSize()!=3) {
    			System.out.println("En el puesto de Transporte  "+i+" hay "+(n3500[i].getCp().getSize()-3)*-1+" plazas libres en su cola");
    		}
    	}
    	
    	for(int i=0;i<pnormal.length;i++) {
    		//System.out.println(pmotos[i].getCp().getSize());
    		if(pnormal[i].getCp().getSize()!=3) {
    			System.out.println("En el puesto de coches "+i+" hay "+(pnormal[i].getCp().getSize()-3)*-1+" plazas libres en su cola");
    		}
    	}
    
    
    
    }

    @Override
    public void rellenarColasPuestos() {
    	//es igualq que el siguiente metodo:
    	moverVehiculosAColasPuestos();
       
    }

    @Override
    public int obtenerNumeroVehiculosRestantes() {
       int cont=0;
    	for(int i=0;i<pmotos.length;i++) {
    	   if(pmotos[i].getEstado().equals(Puesto.estado.abiertoOcupado)) {
    		   cont++;
    		 
    	   }
       }
    	
    	for(int i=0;i<pnormal.length;i++) {
     	   if(pnormal[i].getEstado().equals(Puesto.estado.abiertoOcupado)) {
     		   cont++;
     		 
     	   }
        }
    	
    	for(int i=0;i<n3500.length;i++) {
      	   if(n3500[i].getEstado().equals(Puesto.estado.abiertoOcupado)) {
      		   cont++;
      		 
      	   }
         }
    	
    	cont+=citaCITV.getSize();
    	cont+=NocitaCITV.getSize();
    	
    	
    	return cont;
    }

    @Override
    //Se el pasa el puesto que queremos  que revise el siguiente vehiculo y add el nuevo vehiculo a revisar
    public void revisarSiguienteVehiculo(Puesto p) {
    	
       if(p.getEstado().equals(Puesto.estado.abiertoOcupado)) System.out.println("El puesto esta ocupado") ;
      
       if(p.getEstado().equals(Puesto.estado.cerrado)) System.out.println("El puesto esta cerrado") ;
       
       if(!p.getEstado().equals(Puesto.estado.abiertoVacio)) {
    	   
    	   if(p.getCp().isEmpty()) {
    		   moverVehiculosAColasPuestos();
    	   }
    	   
       }
       
    }

    @Override
    public void vaciarITV() {
    	
    	boolean sePuede=true;
    	
    	for(int i=0;i<pnormal.length;i++) {
    		if(pnormal[i].getEstado().equals(estado.abiertoOcupado)) {
    			System.out.println("El puesto Nº :"+i+ " de Coches esta ocupado, primero debe ser revisado el coche y despues cerrado el puesto");
    			sePuede=false;
    		}
    	}
    	for(int i=0;i<pmotos.length;i++) {
    		if(pmotos[i].getEstado().equals(estado.abiertoOcupado)) {
    			System.out.println("El puesto Nº :"+i+ " de Motos esta ocupado, primero debe ser revisado el coche y despues cerrado el puesto");
    			sePuede=false;
    		}
    	}
    	for(int i=0;i<n3500.length;i++) {
    		if(n3500[i].getEstado().equals(estado.abiertoOcupado)) {
    			System.out.println("El puesto Nº :"+i+ " de + de 3500kG esta ocupado, primero debe ser revisado el coche y despues cerrado el puesto");
    			sePuede=false;
    		}
    	}
    	
    	if(sePuede) {
    		for(int i=0;i<pnormal.length;i++) {
    				for(int j=0;j<pnormal[i].getCp().getSize();j++) {
    					pnormal[i].getCp().dequeue();
    				}
    		}
    		
    		for(int i=0;i<pmotos.length;i++) {
    			for(int j=0;j<pmotos[i].getCp().getSize();j++) {
    				pmotos[i].getCp().dequeue();
				}
    		}
    		
    		for(int i=0;i<n3500.length;i++) {
    			for(int j=0;j<n3500[i].getCp().getSize();j++) {
    				n3500[i].getCp().dequeue();
				}
    		}

    		for(int i=0;i<citaCITV.getSize();i++) {
    			citaCITV.dequeue();
    		}

    		for(int i=0;i<NocitaCITV.getSize();i++) {
    			NocitaCITV.dequeue();
    		}
    	}
        
    }

  /*Hacer revision de los vehiculos que esten en puestos, pero sin pasar nuevos vehiculos
   para cerrar puestos completamente para el cierre de la ITV, es decir antes de que salgan
   los vehiculos uno a  uno por orden, primero cierro los puestos de los vehiculos sin que entre
   uno mas ni se ordenen porque ya van a salir todos */
	@Override
	public void hacerRevisionParaCerrar() {
		for(int i=0;i<pnormal.length;i++) {
    		pnormal[i].setEst(estado.cerrado); 
    			System.out.println("El puesto Nº :"+i+ " de Coches ha sido cerrado los coches de su colan van ir saliendo en orden");
    		
    	}
    	for(int i=0;i<pmotos.length;i++) {
    		pmotos[i].setEst(estado.cerrado); 
			System.out.println("El puesto Nº :"+i+ " de Motos ha sido cerrado los coches de su colan van ir saliendo en orden");
    	}
    	for(int i=0;i<n3500.length;i++) {
    		n3500[i].setEst(estado.cerrado); 
			System.out.println("El puesto Nº :"+i+ " de +3500Kg ha sido cerrado los coches de su colan van ir saliendo en orden");
    	}
		
	}


	

}
