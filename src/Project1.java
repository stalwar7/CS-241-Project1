
/*
 * @author - Sana Talwar
 * CS 241 - project 1
 * Description: driver class for the binary search tree
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Project1 {
	public static String bTree;

	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(); //binary search tree object 
		Scanner sc = new Scanner(System.in);	//to read user input
		System.out.println("Please enter the initial sequence of values: ");
		bTree = sc.nextLine();
		String[] nums = bTree.split(" ");
		int[] finalNums = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			finalNums[i] = Integer.parseInt(nums[i]);
		}
		//add provided values into the binary search tree
		for (int val : finalNums) {
			tree.add(val);
		}
		// print out traversals at the beginnings
		System.out.print("Pre-order: ");
		tree.preOrder();
		System.out.println();
		System.out.print("In-order: ");
		tree.inOrder();
		System.out.println();
		System.out.print("Post-order: ");
		tree.postOrder();
		System.out.println();
		// loop for the input commands
		boolean bool = true;
		String input;
		int val;
		/*
		 * while loop for the command sequence
		 * checks user input and follows through
		 */
		while (bool) {
			System.out.print("Command? ");
			input = sc.next().toUpperCase();
			// val = sc.nextInt();
			if (input.equals("I")) {
				val = sc.nextInt();
				if (tree.contains(val)) {
					System.out.println(val + " already exists, ignore.");
					// System.out.println();
				} else {
					tree.add(val);
					System.out.print("In-order: ");
					tree.inOrder();
					System.out.println();
				}
			} else if (input.equals("D")) {
				val = sc.nextInt();
				if (tree.contains(val)) {
					tree.remove(val);
					System.out.print("In-order: ");
					tree.inOrder();
					System.out.println();
				} else {
					System.out.println(val + " doesn't exist!");
					// System.out.println();
				}
			} else if (input.equals("P")) {
				BinaryTreeNode<Integer> rootNode = tree.getRootNode();
				val = sc.nextInt();
				System.out.println(getPredecessor(rootNode, val));

			} else if (input.equals("S")) {
				BinaryTreeNode<Integer> rootNode = tree.getRootNode();
				val = sc.nextInt();
				System.out.println(getSuccessor(rootNode, val));
			} else if (input.equals("E")) {
				System.out.println("Thank you for using my program!");
				bool = false;
			} else {
				printCommands();
				System.out.println();
			}
		}

	}
	/*
	 * prints specified commands
	 */
	public static void printCommands() {
		System.out.println("Please enter a command:");
		System.out.println("I   Insert a value");
		System.out.println("D   Delete a value");
		System.out.println("P   Find predecessor");
		System.out.println("S   Find Successor");
		System.out.println("E   Exit the program");
		System.out.println("H   Display this message");
	}
	/*
	 * adds the values of the proposed tree into an array
	 * returns the specified array
	 */
	private static ArrayList<Integer> inOrderArray(BinaryTreeNode<Integer> node, ArrayList<Integer> array) {
		if (node != null) {
			inOrderArray(node.getLeftChild(), array);
			array.add(node.getData());
			inOrderArray(node.getRightChild(), array);
		}
		return array;
	}
	/*
	 * takes in a node and a specified value
	 * to find the node after that in the in-order traversal
	 * makes an arraylist of the tree using in-order traversal
	 * converts it to an array and finds the given value 
	 * returns the data of the node after it
	 */
	private static int getSuccessor(BinaryTreeNode<Integer> node, int value) {
		int result = 0;
		ArrayList<Integer> array = new ArrayList<Integer>();
		array = inOrderArray(node, array);
		Integer[] arr = array.toArray(new Integer[array.size()]);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value)
				result = arr[i + 1];
		}
		return result;
	}
	/*
	 * takes in a node and a specified value
	 * to find the node before that in the in-order traversal
	 * makes an arraylist of the tree using in-order traversal
	 * converts it to an array and finds the given value 
	 * returns the data of the node before it
	 */
	private static int getPredecessor(BinaryTreeNode<Integer> node, int value) {
		int result = 0;
		ArrayList<Integer> array = new ArrayList<Integer>();
		array = inOrderArray(node, array);
		Integer[] arr = array.toArray(new Integer[array.size()]);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value)
				result = arr[i - 1];
		}
		return result;
	}

}
