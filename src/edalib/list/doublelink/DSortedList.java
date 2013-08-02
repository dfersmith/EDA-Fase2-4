package edalib.list.doublelink;

import edalib.list.ISortedList;

/**
 * A double-linked list class with sentinel nodes
 */

public class DSortedList<E extends Comparable<E>> implements ISortedList<E> {

	DNode<E> header;
	DNode<E> trailer;

	public DSortedList() {
		header = new DNode<E>(null);
		trailer = new DNode<E>(null);
		header.nextNode = trailer;
		trailer.previousNode = header;
	}

	@Override
	public void add(E newElem) {
		DNode<E> newNode = new DNode<E>(newElem);
		DNode<E> auxNode = trailer;
		for (DNode<E> nodeIt = header.nextNode; nodeIt != trailer; 
				nodeIt = nodeIt.nextNode) {
			// if (nodeIt.getElement() > newElem) {
			if (nodeIt.getElement().compareTo(newElem) > 0) {
				auxNode = nodeIt;
				break;
			}
		}
		//
		newNode.nextNode = auxNode;
		newNode.previousNode = auxNode.previousNode;
		auxNode.previousNode.nextNode = newNode;
		auxNode.previousNode = newNode;
	}
	

	@Override
	public boolean isEmpty() {
		return (header.nextNode == trailer);
	}

	@Override
	public boolean contains(E elem) {
		for (DNode<E> nodeIt = header.nextNode; nodeIt != trailer; nodeIt = nodeIt.nextNode) {
			if (nodeIt.getElement().equals(elem)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int getIndexOf(E elem) {
		int index = 0;
		for (DNode<E> nodeIt = header.nextNode; nodeIt != trailer; nodeIt = nodeIt.nextNode) {
			if (nodeIt.getElement().equals(elem)) {
				return index;
			}
			++index;
		}
		return -1;
	}

	@Override
	public void removeFirst() {
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return;
		}
		header.nextNode = header.nextNode.nextNode;
		header.nextNode.previousNode = header;
	}

	@Override
	public void removeLast() {
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return;
		}
		trailer.previousNode = trailer.previousNode.previousNode;
		trailer.previousNode.nextNode = trailer;
	}

	@Override
	public void removeAll(E elem) {
		for (DNode<E> nodeIt = header.nextNode; nodeIt != trailer; nodeIt = nodeIt.nextNode) {
			if (nodeIt.getElement().equals(elem)) {
				nodeIt.previousNode.nextNode = nodeIt.nextNode;
				nodeIt.nextNode.previousNode = nodeIt.previousNode;
			}
		}
	}

	@Override
	public void removeAt(int index) {
		int i = 0;
		for (DNode<E> nodeIt = header.nextNode; nodeIt != trailer; nodeIt = nodeIt.nextNode) {
			if (i == index) {
				nodeIt.previousNode.nextNode = nodeIt.nextNode;
				nodeIt.nextNode.previousNode = nodeIt.previousNode;
				return;
			}
			++i;
		}
		System.out.println("DList: Deletion out of bounds");
	}

	@Override
	public int getSize() {
		int size = 0;
		for (DNode<E> nodeIt = header.nextNode; nodeIt != trailer; nodeIt = nodeIt.nextNode) {
			++size;
		}
		return size;
	}

	@Override
	public E getFirst() {
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return null;
		}
		return header.nextNode.getElement();
	}

	@Override
	public E getLast() {
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return null;
		}
		return trailer.previousNode.getElement();
	}

	@Override
	public E getAt(int index) {
		int i = 0;
		for (DNode<E> nodeIt = header.nextNode; nodeIt != trailer; nodeIt = nodeIt.nextNode) {
			if (i == index) {
				return nodeIt.getElement();
			}
			++i;
		}
		System.out.println("DList: Get out of bounds");
		return null;
	}

	@Override
	public String toString() {
		String result = null;
		for (DNode<E> node = header.nextNode; node != trailer; 
				node = node.nextNode) {
			if (result == null) {
				result = node.getElement().toString();
			} else {
				result += "," + node.getElement().toString();
			}
		}
		return result == null ? "empty" : result;
	}

	public DNode<E> getFirstNode() {
		return header.nextNode;
	}

	public DNode<E> getLastNode() {
		return trailer.previousNode;
	}

	public DNode<E> getHeader() {
		return header;
	}

	public DNode<E> getTrailer() {
		return trailer;
	}

	public static void main(String[] args) {
		DSortedList<Integer> list = new DSortedList<Integer>();
		list.add(2);
		list.add(1);
		list.add(4);
		list.add(3);
		System.out.println(list);
	}
}
