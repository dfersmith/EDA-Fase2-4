package edalib.tree.bstree;

public interface INode <K extends Comparable<K>, E>{
    public IBSTNode<K, E> getLeftChild();
	public IBSTNode<K, E> getRightChild();
}
