package microsoft;

//you can also use imports, for example:
//import java.util.*;

class BSTNode {
	public int val;
	public BSTNode left;
	public BSTNode right;

	public BSTNode() {
	}
}

class BST {
	public BSTNode root;

	public BST() {

	}

// public BSTNode insert(int value) {
//     if(this.root == null) {
//         this.root = new BSTNode();
//         this.root.val = value;

//         return this.root;
//     }

//     if(this.root.val >= value) {
//         // new node should inserted to left subtree.
//         this.root.left = insertHelper(this.root.left, value);
//     } else {
//         // new node should inserted to right subtree.
//          this.root.right = insertHelper(this.root.right, value);
//     }

//     return this.root;
// }

	public void insert(int value) {
		this.root = insertHelper(this.root, value);
	}

	public BSTNode insertHelper(BSTNode node, int value) {
		if (node == null) {
			node = new BSTNode();
			node.val = value;
			return node;
		}

		if (node.val >= value) {
			node.left = insertHelper(node.left, value);
		} else {
			node.right = insertHelper(node.right, value);
		}
		return node;
	}

	public void inOrderTraversal(BSTNode node) {
		if (node == null) {
			return;
		}

		inOrderTraversal(node.left);
		System.out.print(node.val + " ");
		inOrderTraversal(node.right);
	}

}
