/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        // 1,2,3,4,5
        // 1,2,3
        // 1,3,5

        // 1,2,3,4
        // 1,2,3
        // 1,3,null
        ListNode cur = head;
        while (cur != null && cur.next != null) {
        	head = head.next;
        	cur = cur.next.next;
        }
        return head;
    }
}
