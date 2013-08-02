package edalib.tree.bstree;


public class AvlNode<K extends Comparable<K>, E> extends BSTNode<K, E> {
	public AvlNode(K key, E elem) {
		super(key, elem);
	}

	@Override
	public AvlNode<K, E> getLeftChild() {
		return (AvlNode<K, E>) leftChild;
	}

	@Override
	public AvlNode<K, E> getRightChild() {
		return (AvlNode<K, E>) rightChild;
	}

	/*
	 * Height management
	 */

	int height = 0;

	void updateHeight() {
		height = 0;
		if (leftChild != null) {
			height = Math.max(height, 1 + getLeftChild().height);
		}
		if (rightChild != null) {
			height = Math.max(height, 1 + getRightChild().height);
		}
	}
}
