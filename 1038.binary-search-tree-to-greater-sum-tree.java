/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode bstToGst(TreeNode root) {
        helper(root, 0);
        return root;
    }

    private int helper(TreeNode root, int carry) {
        if (root == null) return 0;
        int sumRight = helper(root.right, carry);
        int newRoot = root.val + sumRight + carry;
        int sumLeft = helper(root.left, newRoot);
        int res = root.val + sumLeft + sumRight;
        root.val = newRoot;
        return res;
    }
}
