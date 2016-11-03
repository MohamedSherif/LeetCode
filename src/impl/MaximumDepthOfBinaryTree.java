package impl;

import trees.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 * 
 * 
 * @author MohamedSherif
 *
 */
public class MaximumDepthOfBinaryTree {
	
	public int maxDepth(TreeNode root) {
		int depth = 0;
		if(root == null){
			return 0;
		}
		depth = 1+ Math.max(maxDepth(root.left), maxDepth(root.right));
		return depth;
	}
}
