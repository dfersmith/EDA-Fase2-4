package edalib.tree.bstree;

import edalib.list.IList;
public interface ITree <K extends Comparable<K>, E>{
    public INode<K,E> getRoot();
    public void insert(K key, E element);
}
