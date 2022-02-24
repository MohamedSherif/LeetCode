package microsoft;

import java.util.HashMap;

public class BuildTree {

	public static class Node {
		Node left;
		Node right;
		char value;

		public Node(char value) {
			this.value = value;
		}
	}

	Node root;
	private static int preIndex = 0;

	// An optimization to store the inOrder traversal in HashTable so that search
	// can
	// be done in O(1) time instead of O(n)
	private static HashMap<Character, Integer> inMap = new HashMap<Character, Integer>();

	public BuildTree() {
		// TODO Auto-generated constructor stub
	}

	public static Node buildTree(char[] inOrder, char[] preOrder) {
		int len = inOrder.length;

		for (int i = 0; i < len; i++) {
			inMap.put(inOrder[i], i);
		}

		return buildTree(inOrder, preOrder, 0, len - 1);
	}

	/*
	 * Recursive function to construct binary of size len from Inorder traversal
	 * in[] and Preorder traversal pre[]. Initial values of inStrt and inEnd should
	 * be 0 and len -1. The function doesn't do any error checking for cases where
	 * inorder and preorder do not form a tree
	 */
	public static Node buildTree(char[] inorder, char[] preorder, int inStart, int inEnd) {
		if (inStart > inEnd) {
			return null;
		}

		/*
		 * Pick current node from Preorder traversal using preIndex and increment
		 * preIndex
		 */
		char currChar = preorder[preIndex++];

		Node node = new Node(currChar);

		/* If this node has no children then return */
		if (inStart == inEnd) {
			return node;
		}

		/* Else find the index of this node in Inorder traversal */

//		int inIndex = inSearch(inorder, inStart, inEnd, currChar);

		int inIndex = inMap.get(currChar);

		/*
		 * Using index in Inorder traversal, construct left and right subtrees
		 */
		node.left = buildTree(inorder, preorder, inStart, inIndex - 1);
		node.right = buildTree(inorder, preorder, inIndex + 1, inEnd);

		return node;
	}

	private static int inSearch(char[] str, int start, int end, char value) {
		for (int i = start; i <= end; i++) {
			if (str[i] == value)
				return i;
		}
		return -1;
	}

	private static void printInOrder(Node node) {
		if (node == null)
			return;

		printInOrder(node.left);
		System.out.print(node.value + " ");
		printInOrder(node.right);
	}

	public static void main(String[] args) {
//		BuildTree tree = new BuildTree();
		char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
		char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };

		int len = in.length;

//		Node root = buildTree(in, pre, 0, len - 1);
		Node root = buildTree(in, pre);
		// building the tree by printing inorder traversal
		System.out.println("Inorder traversal of constructed tree is : ");
		printInOrder(root);
	}
}
