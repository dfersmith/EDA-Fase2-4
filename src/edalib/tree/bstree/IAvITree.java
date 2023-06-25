package edalib.tree.bstree;
public interface IAvITree extends ITree<K ,E>{
    AvlNode<K, E> insertRec(AvlNode<K, E> node, K key, E elem);
    AvlNode<K, E> balanceLeft(AvlNode<K, E> node);
    AvlNode<K, E> balanceRight(AvlNode<K, E> node);
    AvlNode<K, E> balanceLeftLeft(AvlNode<K, E> node);
    AvlNode<K, E> balanceLeftRight(AvlNode<K, E> node);
    AvlNode<K, E> balanceRightLeft(AvlNode<K, E> node);
    AvlNode<K, E> balanceRightRight(AvlNode<K, E> node);
}
