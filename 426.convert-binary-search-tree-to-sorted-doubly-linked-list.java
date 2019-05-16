/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        Node head = null, pre = null;
        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root == null) {
                root = stack.pop();
                root.left = pre;
                if (pre != null) {
                    pre.right = root;
                }
                pre = root;
                if (head == null) head = root;
                root = root.right;
            } else {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
            }
        }
        if (head != null) head.left = pre;
        if (pre != null) pre.right = head;
        return head;
    }
}
