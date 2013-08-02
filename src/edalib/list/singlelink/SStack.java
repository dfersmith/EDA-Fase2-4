package edalib.list.singlelink;

import edalib.list.IStack;

public class SStack<E> implements IStack<E> {
	SNode<E> topNode = null;

	@Override
	public boolean isEmpty() {
		return topNode == null;
	}

	@Override
	public void push(E newElem) {
		SNode<E> newNode = new SNode<E>(newElem);
		newNode.nextNode = topNode;
		topNode = newNode;
	}

	@Override
	public E pop() {
		if (topNode == null) {
			return null;
		}
		E elem = topNode.getElement();
		topNode = topNode.nextNode;
		return elem;
	}

	@Override
	public E top() {
		if (topNode == null) {
			return null;
		}
		return topNode.getElement();
	}

	@Override
	public String toString() {
		String result = null;
		for (SNode<E> nodeIt = topNode; nodeIt != null; nodeIt = nodeIt.nextNode) {
			if (result == null) {
				result = "[" + nodeIt.getElement().toString() + "]";
			} else {
				result += "," + nodeIt.getElement().toString();
			}
		}
		return result == null ? "empty" : result;
	}

	public SNode<E> getTopNode() {
		return topNode;
	}

	public int getSize() {
		int s = 0;
		for (SNode<E> nodeIt = topNode; nodeIt != null; nodeIt = nodeIt.nextNode) {
			s++;
		}
		return s;
	}

}
