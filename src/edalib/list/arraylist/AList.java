package edalib.list.arraylist;

import edalib.list.IList;

public class AList<E> implements IList<E> {

	@SuppressWarnings("unchecked")
	E[] array = (E[]) new Object[0];

	@Override
	public void addFirst(E elem) {
		insertAt(0, elem);
	}

	@Override
	public void addLast(E elem) {
		insertAt(array.length, elem);
	}

	@Override
	public void insertAt(int index, E elem) {
		if (index < 0 || index > array.length) {
			System.out.println("AList: Insertion out of bounds");
			return;
		}
		@SuppressWarnings("unchecked")
		E[] a = (E[]) new Object[array.length + 1];
		for (int i = 0; i < index; ++i) {
			a[i] = array[i];
		}
		a[index] = elem;
		for (int i = index; i < array.length; ++i) {
			a[i + 1] = array[i];
		}
		array = a;
	}

	@Override
	public int getSize() {
		return array.length;
	}

	@Override
	public boolean isEmpty() {
		return (array.length == 0);
	}

	@Override
	public boolean contains(E elem) {
		for (int i = 0; i < array.length; ++i) {
			if (array[i].equals(elem)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int getIndexOf(E elem) {
		for (int i = 0; i < array.length; ++i) {
			if (array[i].equals(elem)) {
				return i;
			}
		}
		System.out.println("AList: Not found");
		return -1;
	}

	@Override
	public E getFirst() {
		if (array.length == 0) {
			System.out.println("AList: List is empty");
			return null;
		}
		return (E) array[0];
	}

	@Override
	public E getLast() {
		if (array.length == 0) {
			System.out.println("AList: List is empty");
			return null;
		}
		return (E) array[array.length - 1];
	}

	@Override
	public E getAt(int index) {
		if (index < 0 || index >= array.length) {
			System.out.println("AList: Get out of bounds");
			return null;
		}
		return array[index];
	}

	@Override
	public void removeFirst() {
		removeAt(0);
	}

	@Override
	public void removeLast() {
		removeAt(array.length - 1);
	}

	@Override
	public void removeAt(int index) {
		if (index < 0 || index > array.length) {
			System.out.println("AList: Deletion out of bounds");
			return;
		}
		@SuppressWarnings("unchecked")
		E[] a = (E[]) new Object[array.length - 1];
		for (int i = 0; i < index; ++i) {
			a[i] = array[i];
		}
		for (int i = index + 1; i < array.length; ++i) {
			a[i - 1] = array[i];
		}
		array = a;
	}

	@Override
	public void removeAll(E elem) {
		for (int i = 0; i < array.length; ++i) {
			if (array[i].equals(elem)) {
				removeAt(i);
			}
		}
	}

	@Override
	public String toString() {
		String result = null;
		for (int i = 0; i < array.length; ++ i) {
			if (result == null) {
				result = array[i].toString();
			} else {
				result += "," + array[i].toString();
			}
		}
		return result == null ? "empty" : result;
	}

}
