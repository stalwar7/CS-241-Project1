/**
 * @author Sana Talwar
 * Interface for a Binary Search Tree
 * @version 1.0
 */
public interface BinarySearchTreeInterface<T> {
	/**
	 * traverses through a list of values and arranges them as root, left then right
	 */
	public void preOrder();
	/**
	 *  traverses through a list of values and arranges them as left, root then right
	 */
	public void inOrder();
	/**
	 *  traverses through a list of values and arranges them as left, right then root
	 */
	public void postOrder();
	/**
	 * checks to see if data is within the root tree node
	 * @param data
	 * @return true or false
	 */
	public boolean contains(T data);
	/**
	 * finds if the specific data is in the root node
	 * @param node for the tree
	 * @param data 
	 * @return data if found and null if not
	 */
	public T findEntry(BinaryTreeNode<T> node, T data);
	/**
	 * adds newEntry to the existing tree
	 * if root is null, then newEntry is root
	 * @param newEntry
	 */
	public void add(T newEntry);
	/**
	 * removes newEntry from the root node tree
	 * @param data
	 */
	public void remove(T data);
	/**
	 * @return the root node of the tree
	 */
	public BinaryTreeNode<T> getRootNode();
	
} // end interface
