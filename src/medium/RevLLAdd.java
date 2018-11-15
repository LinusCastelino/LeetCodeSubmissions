/*
 * https://leetcode.com/problems/add-two-numbers/description/
 */

package medium;

public class RevLLAdd {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		int carry = 0, digit;
		ListNode head = null;
		ListNode tail = null;    // maintaining a tail pointer to reduce time complexity of adding
		while(l1 != null && l2 != null) {
			digit = carry + l1.val + l2.val;
			if(digit > 9) {
				digit -= 10;
				carry = 1;
			}
			else {
				carry = 0;
			}
			ListNode node = new ListNode(digit);
			if(head == null) {
				head = node;
				tail = head;
			}
			else {
				tail.next = node;
				tail = node;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		
		while(l1 != null) {
			digit = carry + l1.val;
			if(digit > 9) {
				digit -= 10;
				carry = 1;
			}
			else {
				carry = 0;
			}
			ListNode node = new ListNode(digit);
			tail.next = node;
			tail = node;
			l1 = l1.next;
			
		}
		while(l2 != null) {
			digit = carry + l2.val;
			if(digit > 9) {
				digit -= 10;
				carry = 1;
			}
			else {
				carry = 0;
			}
			ListNode node = new ListNode(digit);
			tail.next = node;
			tail = node;
			l2 = l2.next;
		}
		
		if(carry > 0)
			tail.next = new ListNode(carry);
		return head;
    }
	
}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }