/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        Stack<ListNode> stack = new Stack<>();
        int sum = 0;
        ListNode p = new ListNode(0);
        p.next = head;
        head = p;

        while (p != null) {
            // print(map);
            // print(stack);
            // print("              ");
            sum += p.val;
            if (!map.containsKey(sum)) {
                map.put(sum, p);
                stack.push(p);
            } else {
                ListNode tmp = map.get(sum);
                sum -= p.val;
                while (stack.peek() != tmp) {
                    map.remove(sum);
                    sum -= stack.pop().val;
                }
                tmp.next = p.next;
            }
            p = p.next;
        }
        return head.next;
    }
    private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
}

// [   1, 2, -3, 3, 1]
// [0, 1, 3,  0, 3, 1]
