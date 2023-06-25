package edalib.tree.bstree;

import edalib.list.IList;

public interface IBSTree extends ITree<K ,E>{

	public void remove(K key);
	
	public E getElementByKey (K key);
	
	public IList<E> getPreorder();

	public boolean containsKey(K key);

	public boolean containsElement(E element);

}
