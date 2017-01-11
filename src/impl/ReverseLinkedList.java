package impl;

import lists.ListNode;

/**
 * Reverse a singly linked list
 * Hint:
 * 	A linked list can be reversed either iteratively or recursively. Could you implement both?
 * 
 * @author Mohamed Sherif.
 *
 */
public class ReverseLinkedList {
	/**
	 * Recursive Solution
	 */
	public ListNode reverseList(ListNode head) {
		
		if(head == null || head.next == null)
			return head;
		
		ListNode nextNode = head.next;
		ListNode newHead = reverseList(nextNode);
		
		nextNode.next = head;
		
		head.next = null;
		
		return newHead;
	}
	
	/**
	 * Iterative Solution
	 */
	public ListNode reverseList2(ListNode head) {
		
		ListNode nextNode = null;
		ListNode newHead = null;
		
		while(head != null && head.next != null){
			nextNode = head.next;
			newHead = head.next;
			
			nextNode.next = head;
			
			head.next = null;
		}
		
		return newHead;
	}
}
