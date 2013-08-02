/**
 * @authors 
 * Danay Fernandez Martinez 100303618 
 * Luis Antonio Gonzalez Martin 100303620
 */
package fase3;
import edalib.list.singlelink.SNode;
import fase1.Vehiculo;

public class ColaITV  implements IColaITV<Vehiculo> {

	private SNode<Vehiculo> frontNode;
	private SNode<Vehiculo> tailNode;
	
	public ColaITV(){
		
	}

	@Override
	public boolean isEmpty() {
		return frontNode == null;
	}

	@Override
	public void enqueue(Vehiculo elem) {
		SNode<Vehiculo> node = new SNode<Vehiculo>(elem);
		if (tailNode == null) {
			frontNode = node;
		} else {
			tailNode.nextNode = node;
		}
		tailNode = node;
		
	}

	@Override
	public Vehiculo dequeue() {
		if (frontNode == null) {
			return null;
		} else {
			Vehiculo firstObj = frontNode.getElement();
			frontNode = frontNode.nextNode;
			if (frontNode == null) {
				tailNode = null;
			}
			return firstObj;
		}
	}

	@Override
	public Vehiculo front() {
		return frontNode.getElement();
	}
	
	public int getSize(){
		int s = 0;
		for (SNode<Vehiculo> nodeIt = frontNode; nodeIt!=null; nodeIt = nodeIt.nextNode) {
			s++;
		}
		return s;
	}


}
