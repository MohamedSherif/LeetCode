package impl;

import lists.ListNode;

public class ListManipulation {

	/**
	 * Write a function to delete a node (except the tail) in a singly linked
	 * list, given only access to that node.
	 * 
	 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third
	 * node with value 3, the linked list should become 1 -> 2 -> 4 after
	 * calling your function.
	 * 
	 * 
	 * @param node
	 */
	public void deleteNode(ListNode node) {
		
		if(node.next != null){
    		node.val = node.next.val; // Changes this node's value with the next value. (Old value is erased)
    		node.next = node.next.next; // Cut off the next node from the list.
        }
		
		
		/*
		 * The wrong answer.
				if(node.next == null){
					return;
				}
				node.val = node.next.val;
				node.next = node.next.next;
				
				deleteNode(node.next);
		
		 * No need for the recursive thinking to solve this problem.
		 * All what you need is to
		 * - Change the node value with the next value.
		 * - And then cut off the next node from the list to be erased with the garbage collector.
		 */
	}
}
