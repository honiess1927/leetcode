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
        int res = 0;
        TreeNode realRoot = root;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root == null) {
                root = stack.pop();
                res += root.val;
                root.val = res;
                root = root.left;
            } else {
                while (root != null) {
                    stack.push(root);
                    root = root.right;
                }
            }
        }
        return realRoot;
    }
}

// Solution 2:
// class Solution {
//     public TreeNode bstToGst(TreeNode root) {
//         helper(root, 0);
//         return root;
//     }
//
//     private int helper(TreeNode root, int carry) {
//         if (root == null) return carry;
//         int sum = helper(root.right, carry);
//         root.val += sum;
//         return helper(root.left, root.val);
//     }
// }

// Solution 1:
// class Solution {
//     public TreeNode bstToGst(TreeNode root) {
//         helper(root, 0);
//         return root;
//     }
//
//     private int helper(TreeNode root, int carry) {
//         if (root == null) return 0;
//         int sumRight = helper(root.right, carry);
//         int newRoot = root.val + sumRight + carry;
//         int sumLeft = helper(root.left, newRoot);
//         int res = root.val + sumLeft + sumRight;
//         root.val = newRoot;
//         return res;
//     }
// }
