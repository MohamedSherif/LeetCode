package microsoft;

/**
 * 1448. Count Good Nodes in Binary Tree
 * 
 * Given a binary tree root, a node X in the tree is named good if in the path
 * from root to X there are no nodes with a value greater than X.
 * 
 * Return the number of good nodes in the binary tree.
 * 
 * @author m.sherif
 *
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class GoodNodes {
	
	public static int goodNodes(TreeNode root) {
        int max = Integer.MIN_VALUE;
        
        return goodNodes(root, max);
    }
    
    public static int goodNodes(TreeNode root, int max) {
        if(root == null)
        	return 0;
        
        int isGood = 0;
        
        if(root.val >= max) {
        	max = root.val;
        	isGood ++;
        }
        
        return isGood + goodNodes(root.left, max) + goodNodes(root.right, max);
        
    }

    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(3);
        root.left=  new TreeNode(1);
        root.right=  new TreeNode(4);
        root.left.left=  new TreeNode(3);
        root.right.left=  new TreeNode(1);
        root.right.right=  new TreeNode(5);
        
        System.out.println(goodNodes(root)) ;
        
        System.out.println(Character.isUpperCase('K'));
	}
}
