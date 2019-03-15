/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
    	if (head == null) return true;
        ListNode head1 = new ListNode(0);
        head1.next = head;
        ListNode p = head1, q = head1;

        // Find mid point.
        // For odd list. p = 1/2 * (length + 1);
        // For even list. p = 1/2 * length;
        while (q != null && q.next != null) {
        	p = p.next;
        	q = q.next.next;
        }

        // q is at the first node of the second half.
        q = p.next;
        p.next = null;

        // construct second list.
        ListNode head2 = new ListNode(0);
        while (q != null) {
        	ListNode next = q.next;
        	q.next = head2.next;
        	head2.next = q;
        	q = next;
        }

        // conpare two lists list1(head1), list2(head2)
        // for odd list. list1.length = list2.length + 1
        p = head1;
        q = head2;
        while (q != null) {
        	if (p.val != q.val) return false;
        	p = p.next;
        	q = q.next;
        }

        return true;
    }
}
