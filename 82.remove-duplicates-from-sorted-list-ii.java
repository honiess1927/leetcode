/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) return null;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy, next = head.next;
		while (cur != null && next != null) {
			if (cur.next.val == next.val) {
				while (next != null && cur.next.val == next.val) {
					next = next.next;
				}
				cur.next = next;
			} else {
				cur = cur.next;
			}
			if (next != null) next = next.next;
		}
		return dummy.next;
	}
}
