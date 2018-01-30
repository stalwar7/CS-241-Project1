/*
 * Author - Sana Talwar
 * CS 241 - project 1
 * Description: implement a binary search tree
 */
public class BinarySearchTree<T extends Comparable<? super T>> implements BinarySearchTreeInterface<T> {

	BinaryTreeNode<T> root; // main variable to set the root node of the search tree

	// implement constructors
	/* default constructor */
	public BinarySearchTree() {
		this.root = null;
	}

	public BinarySearchTree(BinaryTreeNode<T> node) {
		this.root = node;
	}

	// pre-order traversal
	public void preOrder() {
		preOrder(root);
	}

	public void preOrder(BinaryTreeNode<T> node) {
		if (node != null) {
			System.out.print(node.getData() + " ");
			preOrder(node.getLeftChild());
			preOrder(node.getRightChild());

		}
	}

	// in-order traversal
	public void inOrder() {
		inOrder(root);
	}

	public void inOrder(BinaryTreeNode<T> node) {
		if (node != null) {
			inOrder(node.getLeftChild());
			System.out.print(node.getData() + " ");
			inOrder(node.getRightChild());
		}
	}

	// post-order traversal
	public void postOrder() {
		postOrder(root);
	}

	public void postOrder(BinaryTreeNode<T> node) {
		if (node != null) {
			postOrder(node.getLeftChild());
			postOrder(node.getRightChild());
			System.out.print(node.getData() + " ");
		}
	}

	/*
	 * takes in a value and call findEntry method returns true or false
	 */
	public boolean contains(T data) {
		return findEntry(this.root, data) != null;
	}

	/*
	 * takes in a binary node and a data value checks within the node to find the
	 * value returns the data if found null if not
	 */
	public T findEntry(BinaryTreeNode<T> node, T newEntry) {
		T result = null;
		if (node != null) {
			T nodeData = node.getData();
			if (newEntry.equals(nodeData)) {
				result = nodeData;
			} else if (newEntry.compareTo(nodeData) < 0) {
				result = findEntry((BinaryTreeNode<T>) node.getLeftChild(), newEntry);
			} else {
				result = findEntry((BinaryTreeNode<T>) node.getRightChild(), newEntry);
			}
		}
		return result;
	}

	// insert a value
	/*
	 * takes a new values
	 * adds it to root if the tree is empty
	 * else uses recursive add Entry to add to the tree
	 */
	public void add(T newEntry) {
		if (root == null) {
			root = new BinaryTreeNode<T>(newEntry);
		} else {
			addEntry(root, newEntry);
		}
	}

	// recursive add
	/*
	 * takes in a node and a data value
	 * traverses through the tree to recursively add the new data value
	 */
	private void addEntry(BinaryTreeNode<T> rootNode, T newEntry) {
		if (newEntry.compareTo(rootNode.getData()) < 0) {
			if (rootNode.getLeftChild() != null) {
				addEntry(rootNode.getLeftChild(), newEntry);
			} else {
				rootNode.setLeftChild(new BinaryTreeNode<T>(newEntry));
			}
		} else {
			if (rootNode.getRightChild() != null) {
				addEntry(rootNode.getRightChild(), newEntry);
			} else {
				rootNode.setRightChild(new BinaryTreeNode<T>(newEntry));
			}
		}
	}

	// removing an entry
	/*
	 * takes in a binary node and a data value
	 * recursively removes the specified data value from the given node
	 * returns the replaced node
	 */
	private BinaryTreeNode<T> removeEntry(BinaryTreeNode<T> rootNode, T newEntry) {
		if (rootNode != null) {
			if (newEntry.compareTo(rootNode.getData()) < 0) {
				rootNode.setLeftChild(removeEntry(rootNode.getLeftChild(), newEntry));
			} else if (newEntry.compareTo(rootNode.getData()) > 0) {
				rootNode.setRightChild(removeEntry(rootNode.getRightChild(), newEntry));
			} else {
				if (rootNode.getLeftChild() == null) {
					return rootNode.getRightChild();
				} else if (rootNode.getRightChild() == null) {
					return rootNode.getLeftChild();
				}
				T newData = getSuccessor(rootNode);
				rootNode.setData(newData);
				rootNode.setRightChild(removeEntry(rootNode.getRightChild(), rootNode.getData()));
			}
		}
		return rootNode;
	}

	/*
	 * takes in a data value traverses through the tree and calls itself recursively
	 * and the remove entry method to remove the specific data value considers all
	 * the cases and reorders the tree
	 */
	public void remove(T data) {
		if (data.compareTo(root.getData()) == 0) {
			if (root.getLeftChild() != null) {
				T temp = root.getRightmostChild(root.getLeftChild()).getData();
				remove(temp);
				root.setData(temp);
			} else if (root.getRightChild() != null) {
				T temp = root.getLeftmostChild(root.getRightChild()).getData();
				remove(temp);
				root.setData(temp);
			} else {
				root.setData(null);
				root = null;
			}
		} else {
			removeEntry(root, data);
		}
	}

	// helper method for the remove functionality
	public T getSuccessor(BinaryTreeNode<T> node) {
		if (node.getRightChild() != null) {
			return node.getLeftmostChild(node.getRightChild()).getData();
		}
		BinaryTreeNode<T> before = null;
		BinaryTreeNode<T> current = root;
		while (current != null && node.getData().compareTo(current.getData()) != 0) {
			if (node.getData().compareTo(current.getData()) > 0) {
				current = current.getRightChild();
			} else {
				before = current;
				current = current.getLeftChild();
			}
		}
		if (before != null && before.getRightChild() != null) {
			if (node.getData().compareTo(root.getLeftmostChild(before.getRightChild()).getData()) > 0) {
				return before.getData();
			} else {
				return root.getLeftmostChild(before.getRightChild()).getData();
			}
		} else {
			return before.getData();
		}
	}
	/*
	 * returns the root of the tree
	 */
	public BinaryTreeNode<T> getRootNode() {
		return this.root;
	}

}