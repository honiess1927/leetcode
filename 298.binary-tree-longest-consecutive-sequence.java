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
    public int longestConsecutive(TreeNode root) {
    	if (root == null) return 0;
        return helper(root, root.val, 0);
    }

    private int helper (TreeNode root, int pre, int len) {
    	if (root == null) return len;
    	int curLen = len;
    	if (root.val != pre + 1) curLen = 0;
    	int left = helper(root.left, root.val, curLen + 1);
    	int right = helper(root.right, root.val, curLen + 1);
    	return Math.max(len, Math.max(left, right));
    }
}
