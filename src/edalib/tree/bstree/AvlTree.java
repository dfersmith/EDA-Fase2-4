
package edalib.tree.bstree;


public class AvlTree<K extends Comparable<K>, E> implements IAvITree<K, E> {
	@Override
	public AvlNode<K, E> getRoot() {
		return (AvlNode<K, E>) root;
	}

	@Override
	public void insert(K key, E elem) {
		root = insertRec((AvlNode<K, E>) root, key, elem);
	}

	/*
	 * Recursive AVL insertion, (AVL deletion not implemented!!!)
	 */

	private AvlNode<K, E> insertRec(AvlNode<K, E> node, K key, E elem) {
		if (node == null) {
			AvlNode<K, E> newNode = new AvlNode<K, E>(key, elem);
			return newNode;
		} else {
			int cmp = key.compareTo(node.getKey());
			if (cmp > 0) {
				node.rightChild = insertRec(node.getRightChild(), key, elem);
				node.updateHeight();
				node = balanceRight(node);
			} else if (cmp < 0) {
				node.leftChild = insertRec(node.getLeftChild(), key, elem);
				node.updateHeight();
				node = balanceLeft(node);
			} else {
				// throw new Exception("key already exists");
			}
			return node;
		}
	}

	private AvlNode<K, E> balanceLeft(AvlNode<K, E> node) {
		AvlNode<K, E> leftChild = (AvlNode<K, E>) node.leftChild;
		AvlNode<K, E> rightChild = (AvlNode<K, E>) node.rightChild;
		int leftHeight = (leftChild == null) ? 0 : leftChild.height;
		int rightHeight = (rightChild == null) ? 0 : rightChild.height;
		if (leftHeight > rightHeight + 1) {
			AvlNode<K, E> leftLeftChild = (AvlNode<K, E>) leftChild.leftChild;
			AvlNode<K, E> leftRightChild = (AvlNode<K, E>) leftChild.rightChild;
			int leftLeftHeight = (leftLeftChild == null) ? 0
					: leftLeftChild.height;
			int leftRightHeight = (leftRightChild == null) ? 0
					: leftRightChild.height;
			if (leftLeftHeight > leftRightHeight) {
				node = balanceLeftLeft(node);
			} else {
				node = balanceLeftRight(node);
			}
		}
		return node;
	}

	private AvlNode<K, E> balanceRight(AvlNode<K, E> node) {
		AvlNode<K, E> leftChild = (AvlNode<K, E>) node.leftChild;
		AvlNode<K, E> rightChild = (AvlNode<K, E>) node.rightChild;
		int leftHeight = (leftChild == null) ? 0 : leftChild.height;
		int rightHeight = (rightChild == null) ? 0 : rightChild.height;
		if (rightHeight > leftHeight + 1) {
			AvlNode<K, E> rightLeftChild = (AvlNode<K, E>) rightChild.leftChild;
			AvlNode<K, E> rightRightRight = (AvlNode<K, E>) rightChild.rightChild;
			int rightLeftHeight = (rightLeftChild == null) ? 0
					: rightLeftChild.height;
			int rightRightHeight = (rightRightRight == null) ? 0
					: rightRightRight.height;
			if (rightLeftHeight > rightRightHeight) {
				node = balanceRightLeft(node);
			} else {
				node = balanceRightRight(node);
			}
		}
		return node;
	}

	private AvlNode<K, E> balanceLeftLeft(AvlNode<K, E> node) {
		AvlNode<K, E> node6 = node;
		AvlNode<K, E> node4 = (AvlNode<K, E>) node6.leftChild;
		AvlNode<K, E> node2 = (AvlNode<K, E>) node4.leftChild;
		AvlNode<K, E> node7 = (AvlNode<K, E>) node6.rightChild;
		AvlNode<K, E> node5 = (AvlNode<K, E>) node4.rightChild;
		AvlNode<K, E> node3 = (AvlNode<K, E>) node2.rightChild;
		AvlNode<K, E> node1 = (AvlNode<K, E>) node2.leftChild;
		node2.leftChild = node1;
		node2.rightChild = node3;
		node2.updateHeight();
		node6.leftChild = node5;
		node6.rightChild = node7;
		node6.updateHeight();
		node4.leftChild = node2;
		node4.rightChild = node6;
		node4.updateHeight();
		return node4;
	}

	private AvlNode<K, E> balanceLeftRight(AvlNode<K, E> node) {
		AvlNode<K, E> node6 = node;
		AvlNode<K, E> node2 = (AvlNode<K, E>) node6.leftChild;
		AvlNode<K, E> node4 = (AvlNode<K, E>) node2.rightChild;
		AvlNode<K, E> node7 = (AvlNode<K, E>) node6.rightChild;
		AvlNode<K, E> node5 = (AvlNode<K, E>) node4.rightChild;
		AvlNode<K, E> node3 = (AvlNode<K, E>) node4.leftChild;
		AvlNode<K, E> node1 = (AvlNode<K, E>) node2.leftChild;
		node2.leftChild = node1;
		node2.rightChild = node3;
		node2.updateHeight();
		node6.leftChild = node5;
		node6.rightChild = node7;
		node6.updateHeight();
		node4.leftChild = node2;
		node4.rightChild = node6;
		node4.updateHeight();
		return node4;
	}

	private AvlNode<K, E> balanceRightLeft(AvlNode<K, E> node) {
		AvlNode<K, E> node2 = node;
		AvlNode<K, E> node6 = (AvlNode<K, E>) node2.rightChild;
		AvlNode<K, E> node4 = (AvlNode<K, E>) node6.leftChild;
		AvlNode<K, E> node1 = (AvlNode<K, E>) node2.leftChild;
		AvlNode<K, E> node3 = (AvlNode<K, E>) node4.leftChild;
		AvlNode<K, E> node5 = (AvlNode<K, E>) node4.rightChild;
		AvlNode<K, E> node7 = (AvlNode<K, E>) node6.rightChild;
		node2.leftChild = node1;
		node2.rightChild = node3;
		node2.updateHeight();
		node6.leftChild = node5;
		node6.rightChild = node7;
		node6.updateHeight();
		node4.leftChild = node2;
		node4.rightChild = node6;
		node4.updateHeight();
		return node4;
	}

	private AvlNode<K, E> balanceRightRight(AvlNode<K, E> node) {
		AvlNode<K, E> node2 = node;
		AvlNode<K, E> node4 = (AvlNode<K, E>) node2.rightChild;
		AvlNode<K, E> node6 = (AvlNode<K, E>) node4.rightChild;
		AvlNode<K, E> node1 = (AvlNode<K, E>) node2.leftChild;
		AvlNode<K, E> node3 = (AvlNode<K, E>) node4.leftChild;
		AvlNode<K, E> node5 = (AvlNode<K, E>) node6.leftChild;
		AvlNode<K, E> node7 = (AvlNode<K, E>) node6.rightChild;
		node2.leftChild = node1;
		node2.rightChild = node3;
		node2.updateHeight();
		node6.leftChild = node5;
		node6.rightChild = node7;
		node6.updateHeight();
		node4.leftChild = node2;
		node4.rightChild = node6;
		node4.updateHeight();
		return node4;
	}

}
