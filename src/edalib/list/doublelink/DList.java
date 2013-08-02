package edalib.list.doublelink;

import edalib.list.IList;

/**
 * A double-linked list class with sentinel nodes
 */

public class DList<E> implements IList<E> {

	DNode<E> header;
	DNode<E> trailer;

	public DList() {
		header = new DNode<E>(null);
		trailer = new DNode<E>(null);
		header.nextNode = trailer;
		trailer.previousNode = header;
	}

	@Override
	public void addFirst(E elem) {
		DNode<E> newNode = new DNode<E>(elem);
		newNode.nextNode = header.nextNode;
		newNode.previousNode = header;
		header.nextNode.previousNode = newNode;
		header.nextNode = newNode;
	}

	@Override
	public void addLast(E elem) {
		DNode<E> newNode = new DNode<E>(elem);
		newNode.nextNode = trailer;
		newNode.previousNode = trailer.previousNode;
		trailer.previousNode.nextNode = newNode;
		trailer.previousNode = newNode;
	}

	@Override
	public void insertAt(int index, E elem) {
		DNode<E> newNode = new DNode<E>(elem);
		int i = 0;
		for (DNode<E> nodeIt = header; nodeIt != trailer; nodeIt = nodeIt.nextNode) {
			if (i == index) {
				newNode.nextNode = nodeIt.nextNode;
				newNode.previousNode = nodeIt;
				nodeIt.nextNode.previousNode = newNode;
				nodeIt.nextNode = newNode;
				return;
			}
			++i;
		}
		System.out.println("DList: Insertion out of bounds");
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
		for (DNode<E> nodeIt = header.nextNode; nodeIt != trailer; nodeIt = nodeIt.nextNode) {
			if (result == null) {
				result = nodeIt.getElement().toString();
			} else {
				result += "," + nodeIt.getElement().toString();
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
		// incomplete test
		IList<String> list = new DList<String>();
		System.out.println(list);
		list.addLast("1");
		System.out.println(list);
		list.addFirst("2");
		System.out.println(list);
		list.addFirst("3");
		System.out.println(list);
		list.addLast("4");
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
		list.removeFirst();
		System.out.println(list);
		list.removeFirst();
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
	}
}
