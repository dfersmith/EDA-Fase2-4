package edalib.list.singlelink;

import edalib.list.IQueue;

public class SQueue<E> implements IQueue<E> {
	private SNode<E> frontNode;
	private SNode<E> tailNode;

	@Override
	public boolean isEmpty() {
		return frontNode == null;
	}

	@Override
	public void enqueue(E elem) {
		SNode<E> node = new SNode<E>(elem);
		if (tailNode == null) {
			frontNode = node;
		} else {
			tailNode.nextNode = node;
		}
		tailNode = node;
	}

	@Override
	public E dequeue() {
		if (frontNode == null) {
			return null;
		} else {
			E firstObj = frontNode.getElement();
			frontNode = frontNode.nextNode;
			if (frontNode == null) {
				tailNode = null;
			}
			return firstObj;
		}
	}

	@Override
	public E front() {
		return frontNode.getElement();
	}

	@Override
	public String toString() {
		String result = null;
		for (SNode<E> nodeIt = frontNode; nodeIt != null; nodeIt = nodeIt.nextNode) {
			if (result == null) {
				result = "[" + nodeIt.getElement().toString() + "]";
			} else {
				result += "," + nodeIt.getElement().toString();
			}
		}
		return result == null ? "empty" : result;
	}

	public SNode<E> getFrontNode() {
		return frontNode;
	}

	public SNode<E> getTailNode() {
		return tailNode;
	}
	public int getSize(){
		int s = 0;
		for (SNode<E> nodeIt = frontNode; nodeIt!=null; nodeIt = nodeIt.nextNode) {
			s++;
		}
		return s;
	}

}
