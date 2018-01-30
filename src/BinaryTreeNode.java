/*
 * Author - Sana Talwar
 * CS 241 - project 1
 * Description: implement a binary node for the binary search tree
 */
public class BinaryTreeNode<T> {

	private BinaryTreeNode<T> rightChild;
	private BinaryTreeNode<T> leftChild;
	private T data;

	// make constructors
	/* default constructor*/
	public BinaryTreeNode() {
		rightChild = null;
		leftChild = null;
		data = null;
	}
	/* set data value from modified constructor*/
	public BinaryTreeNode(T dat) {
		rightChild = null;
		leftChild = null;
		data = dat;
	}

	/* set all variables with modified constructor */
	public BinaryTreeNode(BinaryTreeNode<T> right, BinaryTreeNode<T> left, T dat) {
		rightChild = right;
		leftChild = left;
		data = dat;
	}
	// make accessor methods - get and set methods
	/*
	 * returns right child
	 */
	public BinaryTreeNode<T> getRightChild() {
		return rightChild; 
	}
	
	/*
	 * takes in a node and sets it as the right child
	 */
	public void setRightChild(BinaryTreeNode<T> right) {
		rightChild = right;
	}
	/*
	 * returns the left child
	 */
	public BinaryTreeNode<T> getLeftChild() {
		return leftChild;
	}
	/*
	 * takes in a node and sets it as a left child
	 */
	public void setLeftChild(BinaryTreeNode<T> left) {
		leftChild = left;
	}
	/*
	 * returns data 
	 */
	public T getData() {
		return data;
	}
	/*
	 * takes in a value and sets it as data
	 */
	public void setData(T value) {
		data = value;
	}
	
	/*
	 * takes in a node and returns the leftmost child from the given node
	 */
	public BinaryTreeNode<T> getLeftmostChild(BinaryTreeNode<T> node) {
		BinaryTreeNode<T> leaf = node;
		while (leaf.getLeftChild() != null) {
			leaf = leaf.getLeftChild();
		}
		return leaf;
	}
	/*
	 * takes in a node and returns the leftmost child from the given node
	 */
	public BinaryTreeNode<T> getRightmostChild(BinaryTreeNode<T> node) {
		BinaryTreeNode<T> leaf = node;
		while (leaf.getRightChild() != null) {
			leaf = leaf.getRightChild();
		}
		return leaf;
	}
}
