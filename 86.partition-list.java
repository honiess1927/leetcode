/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0), greater = new ListNode(0);
        ListNode lcur = less, gcur = greater;
        while (head != null) {
        	if (head.val < x) {
        		lcur.next = head;
        		lcur = lcur.next;
        	} else {
        		gcur.next = head;
        		gcur = gcur.next;
        	}
        	head = head.next;
        }
        lcur.next = greater.next;
        gcur.next = null;
        return less.next;
    }
}
