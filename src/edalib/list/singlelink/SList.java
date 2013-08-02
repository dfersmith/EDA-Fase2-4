package edalib.list.singlelink;

import edalib.list.IList;

public class SList<E> implements IList<E> {

	protected SNode<E> firstNode = null;

	@Override
	public void addFirst(E newElem) {
		SNode<E> newNode = new SNode<E>(newElem);
		newNode.nextNode = firstNode;
		firstNode = newNode;
	}

	@Override
	public void addLast(E newElem) {
		SNode<E> node = new SNode<E>(newElem);
		SNode<E> lastNode = null;
		for (SNode<E> nodeIt = firstNode; nodeIt != null; nodeIt = nodeIt.nextNode) {
			lastNode = nodeIt;
		}
		
		if (lastNode == null) {
			firstNode = node;
		} else {
			lastNode.nextNode = node;
		}
	}

	@Override
	public void insertAt(int index, E newElem) {
		SNode<E> newNode = new SNode<E>(newElem);
		if (index == 0) {
			newNode.nextNode = firstNode;
			firstNode = newNode;
		} else {
			int i = 1;
			for (SNode<E> nodeIt = firstNode; nodeIt != null; nodeIt = nodeIt.nextNode) {
				if (i == index) {
					newNode.nextNode = nodeIt.nextNode;
					nodeIt.nextNode = newNode;
					return;
				}
				++i;
			}
			System.out.println("SList: Insertion out of bounds");
		}
	}

	@Override
	public boolean isEmpty() {
		return (firstNode == null);
	}

	@Override
	public boolean contains(E elem) {
		for (SNode<E> nodeIt = firstNode; nodeIt != null; nodeIt = nodeIt.nextNode) {
			if (nodeIt.getElement().equals(elem)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void removeFirst() {
		if (firstNode != null) {
			firstNode = firstNode.nextNode;
		}
	}

	@Override
	public void removeLast() {
		SNode<E> lastNode = null;
		SNode<E> previousNode = null;
		for (SNode<E> nodeIt = firstNode; nodeIt != null; nodeIt = nodeIt.nextNode) {
			previousNode = lastNode;
			lastNode = nodeIt;
		}
		if (previousNode == null) {
			firstNode = null;
		} else {
			previousNode.nextNode = null;
		}
	}

	@Override
	public void removeAll(E elem) {
		SNode<E> previousNode = null;
		for (SNode<E> nodeIt = firstNode; nodeIt != null; nodeIt = nodeIt.nextNode) {
			if (nodeIt.getElement().equals(elem)) {
				if (previousNode == null) {
					firstNode = nodeIt.nextNode;
				} else {
					previousNode.nextNode = nodeIt.nextNode;
				}
			} else {
				previousNode = nodeIt;
			}
		}
	}

	@Override
	public void removeAt(int index) {
		int i = 0;
		SNode<E> previousNode = null;
		for (SNode<E> nodeIt = firstNode; nodeIt != null; nodeIt = nodeIt.nextNode) {
			if (i == index) {
				if (previousNode == null) {
					firstNode = nodeIt.nextNode;
				} else {
					previousNode.nextNode = nodeIt.nextNode;
				}
				return;
			}
			++i;
			previousNode = nodeIt;
		}
		System.out.println("SList: Deletion out of bounds");
	}

	@Override
	public int getSize() {
		int size = 0;
		for (SNode<E> node = firstNode; node != null; node = node.nextNode) {
			++size;
		}
		return size;
	}

	@Override
	public int getIndexOf(E elem) {
		int index = 0;
		for (SNode<E> node = firstNode; node != null; node = node.nextNode) {
			if (node.getElement().equals(elem)) {
				return index;
			}
			++index;
		}
		return -1;
	}

	@Override
	public E getFirst() {
		if (firstNode == null) {
			System.out.println("SList: List is empty");
			return null;
		}
		return firstNode.getElement();
	}

	@Override
	public E getLast() {
		SNode<E> lastNode = null;
		for (SNode<E> node = firstNode; node != null; node = node.nextNode) {
			lastNode = node;
		}
		if (lastNode == null) {
			System.out.println("SList: List is empty");
			return null;
		}
		return lastNode.getElement();
	}

	@Override
	public E getAt(int index) {
		int i = 0;
		for (SNode<E> nodeIt = firstNode; nodeIt != null; nodeIt = nodeIt.nextNode) {
			if (i == index) {
				return nodeIt.getElement();
			}
			++i;
		}
		System.out.println("SList: Get out of bounds");
		return null;
	}

	@Override
	public String toString() {
		String result = null;
		for (SNode<E> nodeIt = firstNode; nodeIt != null; nodeIt = nodeIt.nextNode) {
			if (result == null) {
				result = nodeIt.getElement().toString();
			} else {
				result += "," + nodeIt.getElement().toString();
			}
		}
		return result == null ? "empty" : result;
	}

	public SNode<E> getFirstNode() {
		return firstNode;
	}

	public static void main(String[] args) {
		// incomplete test
		IList<String> list = new SList<String>();
		System.out.println(list);
		list.addLast("1");
		System.out.println(list);
		list.addFirst("2");
		System.out.println(list);
		list.addFirst("3");
		System.out.println(list);
		list.addLast("4");
		System.out.println(list);
		list.insertAt(2, "5");
		System.out.println(list);
		list.insertAt(5, "6");
		System.out.println(list);
		list.insertAt(0, "7");
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
		list.removeFirst();
		System.out.println(list);
		list.removeFirst();
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
		list.removeFirst();
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
	}
}
