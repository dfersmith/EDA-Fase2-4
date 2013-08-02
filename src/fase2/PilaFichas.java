/**
 * @authors 
 * Danay Fernandez Martinez 100303618 
 * Luis Antonio Gonzalez Martin 100303620
 */
package fase2;

import edalib.list.singlelink.SNode;
import fase1.Ficha;

public class PilaFichas implements IPilaFichas {

	SNode<Ficha> topNode = null;

	@Override
	public boolean isEmpty() {
		return topNode == null;
	}

	@Override
	public void push(Ficha elem) {
		SNode<Ficha> newNode = new SNode<Ficha>(elem);
		newNode.nextNode = topNode;
		topNode = newNode;

	}

	public Ficha pop() {
		if (topNode == null) {
			return null;
		}
		Ficha elem = topNode.getElement();
		topNode = topNode.nextNode;
		return elem;
	}

	public Ficha top() {
		if (topNode == null) {
			return null;
		}
		return topNode.getElement();
	}

	public int getSize() {
		int s = 0;
		for (SNode<Ficha> nodeIt = topNode; nodeIt != null; nodeIt = nodeIt.nextNode) {
			s++;
		}
		return s;
	}

}
