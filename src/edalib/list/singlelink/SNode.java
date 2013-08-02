package edalib.list.singlelink;

public class SNode<E> {

	public SNode<E> nextNode = null;

	E elem;

	public SNode<E> getNextNode() {
		return nextNode;
	}

	public E getElement() {
		return elem;
	}

	public SNode(E e) {
		elem = e;
	}

	public SNode(E elem, SNode<E> nextNode) {
		this.elem = elem;
		this.nextNode = nextNode;
	}

	
}
