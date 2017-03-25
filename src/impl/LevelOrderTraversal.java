package impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import trees.TreeNode;;

public class LevelOrderTraversal {

	static List<List<Integer>> printLevelOrderWithQueue(TreeNode root) {

		List<List<Integer>> result = new LinkedList<List<Integer>>();

		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root);

		while (!queue.isEmpty()) {
			// poll() removes the present head.
			TreeNode temp_node = queue.poll();

			System.out.print(temp_node.val + " ");

			// Enqueue Left Node
			if (temp_node.left != null) {
				queue.add(temp_node.left);
			}
			// Enqueue Right Node
			if (temp_node.right != null) {
				queue.add(temp_node.right);
			}
		}

		return result;
	}
	
	public static List<List<Integer>> levelOrder(TreeNode root){
		List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		if(root == null)
			return wrapList;
		
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			
			int levelNum = queue.size();
			
			List<Integer> subList = new LinkedList<Integer>();
			
			for (int i = 0; i < levelNum; i++) {
				if(queue.peek().left != null) queue.offer(queue.peek().left);
				if(queue.peek().right != null) queue.offer(queue.peek().right);
				
				subList.add(queue.poll().val);
			}
			wrapList.add(subList);
		}
		
		return wrapList;
	}
	
	
	/* Driver program to test above functions */
    public static void main(String args[])
    {
       TreeNode root = new TreeNode(1);
       root.left= new TreeNode(2);
       root.right= new TreeNode(3);
       root.left.left= new TreeNode(4);
       root.left.right= new TreeNode(5);
       root.right.left= new TreeNode(6);
       root.right.right= new TreeNode(7);
       
       root.right.left.left= new TreeNode(8);
       root.right.left.right= new TreeNode(9);
        
       System.out.println("Level order traversal of binary tree is ");
       System.out.println("");
       printLevelOrderWithQueue(root);
       
       System.out.println("");
       
       System.out.println("Level order traversal of binary tree is ");
       System.out.println("");
       List<List<Integer>> res = levelOrder(root);
       
       System.out.println("[");
       for (int i = 0; i < res.size(); i++) {
    	   List<Integer> sub = res.get(i);
    	   System.out.print("[");
    	   for (int j = 0; j < sub.size(); j++) {
    		   if(j < (sub.size()-1))
    			   System.out.print(sub.get(j) + ",");
    		   else
    			   System.out.print(sub.get(j));
    	   }
    	   System.out.print("]");
    	   System.out.println("");
       }
       System.out.println("]");
    }
}
