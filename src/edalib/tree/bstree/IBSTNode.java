package edalib.tree.bstree;

import edalib.list.IList;

public interface IBSTNode extends INode<K,E> {
	public K getKey();
	public E getElement();
	public IBSTNode<K, E> getParent();
	public boolean hasLeftChild();
	public boolean hasRightChild();
	public boolean isInternal();
	public boolean isExternal();
	public IBSTNode<K, E> getRoot();
	public boolean isRoot();
	public int getSize();
	public int getHeight();
	public int getDepth();
	public IList<IBSTNode<K, E>> getChildren();
	public IList<E> getPreorder();
}
