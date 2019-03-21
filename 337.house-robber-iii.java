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
    public int rob(TreeNode root) {
        return rob(root, true);
    }

    public int rob(TreeNode root, boolean canRob) {
    	if (root == null) return 0;
    	if (canRob) {
    		return Math.max(root.val + rob(root.left, false) + rob(root.right, false), rob(root.left, true) + rob(root.right, true));
    	} else {
    		return rob(root.right, true) + rob(root.left, true);
    	}
    }
}
