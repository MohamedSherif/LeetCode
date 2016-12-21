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
		ListNode newHead = reverseList(head.next);
		
		nextNode.next = head;
		
		head.next = null;
		
		return newHead;
	}
}
