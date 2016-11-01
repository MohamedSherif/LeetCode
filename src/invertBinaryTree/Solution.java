package invertBinaryTree;

import trees.TreeNode;

/**
 * Invert a binary tree.
		
		     4
		   /   \
		  2     7
		 / \   / \
		1   3 6   9

		to
		     4
		   /   \
		  7     2
		 / \   / \
		9   6 3   1
		
 * @author mohsherif
 *
 */
public class Solution {
	/**
	 * Recursive Solution.
	 * 
	 * @param root
	 * @return
	 */
	public TreeNode invertTree(TreeNode root) {
        TreeNode temp = null;
        if(root!= null){
        	if((root.left == null) && (root.right == null)){ // Leaf Node.
            	return root;
            }
            
            temp = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(temp);
        }
		return root;
    }
}
