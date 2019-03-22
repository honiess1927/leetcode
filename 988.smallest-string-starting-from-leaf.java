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
	String res = null;
    public String smallestFromLeaf(TreeNode root) {
    	helper("", root);
    	return res;
    }

    public void helper(String succ, TreeNode root) {
    	if (root == null) return;
    	String str = (char)(97 + root.val) + succ;
    	if (root.left == null && root.right == null) {
    		if (res == null || str.compareTo(res) < 0) res = str;
    	}
    	helper(str, root.left);
    	helper(str, root.right);
    }
}
