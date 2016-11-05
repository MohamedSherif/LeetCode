package impl;

import lists.ListNode;

public class AddTwoNumbers {
//	public static ListNode addTwoNumbersOld(ListNode l1, ListNode l2) {
//		ListNode result = new ListNode(0);
//		int currentDigitSum = 0;
//		int modulo10 = 0;
//		int remainingSum = 0;
//		
//		ListNode currentL1Digit = l1;
//		ListNode currentL2Digit = l2;
//		
//		ListNode currentResultDigit = result;
//		while (currentL1Digit != null){
//			if(currentL2Digit != null){
//				currentDigitSum = (currentL1Digit.getVal() + currentL2Digit.getVal() + remainingSum);
//				remainingSum = 0;
//				modulo10 = currentDigitSum%10;
//				
//				currentL2Digit = currentL2Digit.getNext();
//			}else{
//				currentDigitSum = (currentL1Digit.getVal() + remainingSum);
//				remainingSum = 0;
//				modulo10 = currentDigitSum%10;
//			}
//			
//			if(currentDigitSum >= 10){
//				remainingSum = 1;
//			}
//			currentResultDigit.setVal(modulo10);
//			
//			currentL1Digit = currentL1Digit.getNext();
//			
//			if(currentL1Digit != null)
//				currentResultDigit.setNext(new ListNode(0));
//			
//			currentResultDigit = currentResultDigit.getNext();
//		}
//		
//		
//		return result;
//	}
	
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;
            
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }

	
	public static void main(String[] args) {
		ListNode l1_2 = new ListNode(2);
		ListNode l1_4 = new ListNode(4);
		ListNode l1_3 = new ListNode(3);
		
		l1_2.next = l1_4;
		l1_4.next = l1_3;
		
		ListNode l2_5 = new ListNode(5);
		ListNode l2_6 = new ListNode(6);
		ListNode l2_4 = new ListNode(4);
		
		l2_5.next = l2_6;
		l2_6.next = l2_4;
		
		ListNode res = addTwoNumbers(l1_2, l2_5);
		
		while(res != null){
			System.out.println(res.val);
			res = res.next;
		}
		
	}
}
