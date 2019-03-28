/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
        ListNode dummyHead = new ListNode(-1), cur = dummyHead;
        for (ListNode ln : lists) {
        	if (ln != null) pq.offer(ln);
        }
        while (!pq.isEmpty()) {
        	cur.next = pq.poll();
        	cur = cur.next;
        	if (cur.next != null) pq.offer(cur.next);
        	cur.next = null;
        }
        return dummyHead.next;
    }
}
