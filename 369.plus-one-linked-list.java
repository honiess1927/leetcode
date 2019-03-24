/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        boolean needNewHead = plusOneB(head);
        if (needNewHead) {
        	ListNode newHead = new ListNode(1);
        	newHead.next = head;
        	head = newHead;
        }
        return head;
    }

    public boolean plusOneB(ListNode head) {
    	if (head == null) return true;
    	boolean carry = plusOneB(head.next);
    	if (carry) {
    		head.val++;
    		if (head.val >= 10) {
    			head.val = head.val - 10;
    			return true;
    		}
    	}
    	return false;
    }
}
