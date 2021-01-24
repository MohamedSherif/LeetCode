package impl;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class PathSum {

	private class TreeNode {
		int val;
	    TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
		 	this.right = right;
		}
	}
	
	public boolean hasPathSum(TreeNode node, int sumSoFar, int sum){
        if(node == null) {
            return false;
        } else if(node.left == null && node.right == null && ((sumSoFar + node.val) == sum)) {
            return true;       
        } else {
            return hasPathSum(node.left, sumSoFar + node.val, sum) || hasPathSum(node.right, sumSoFar + node.val, sum);
        }
    }
    
    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSum(root, 0, sum);
    }
    
    
    public boolean hasPathSum2(TreeNode root, int sum) {
        if(root == null) {
        	return false;
        } else if(root.left == null && root.right == null && (sum - root.val == 0)) {
        	return true;
        } else {
        	return hasPathSum2(root.left, (sum - root.val)) || hasPathSum2(root.right, (sum - root.val));
        }
    }
		
}
