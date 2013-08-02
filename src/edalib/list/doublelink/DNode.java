package edalib.list.doublelink;

public class DNode<E> {

	DNode<E> previousNode = null;
	DNode<E> nextNode = null;

	E elem;

	public DNode<E> getPreviousNode() {
		return previousNode;
	}

	public DNode<E> getNextNode() {
		return nextNode;
	}

	public E getElement() {
		return elem;
	}

	public DNode(E elem) {
		this.elem = elem;
	}

}
