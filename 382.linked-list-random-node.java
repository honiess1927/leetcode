/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    int size = 0;
    ListNode head;
    public Solution(ListNode head) {
    	this.head = head;
        ListNode cur = head;
        while (cur != null) {
        	size++;
        	cur = cur.next;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        Random rand = new Random();
        int next = rand.nextInt(size);
        ListNode cur = head;
        for (int i = 0; i < next; i++) {
        	cur = cur.next;
        }
        return cur.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
