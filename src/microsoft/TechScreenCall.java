package microsoft;

public class TechScreenCall {

	public static void main(String[] args) {
		BST tree = new BST();

		tree.insert(6);
		tree.insert(2);
		tree.insert(8);
		tree.insert(0);
		tree.insert(1);

		tree.inOrderTraversal(tree.root);
	}
}
