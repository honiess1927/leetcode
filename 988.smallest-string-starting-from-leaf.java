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
    public String smallestFromLeaf(TreeNode root) {
    	return helper("", root);
    }

    public String helper(String succ, TreeNode root) {
    	if (root == null) return "" + (char)('z' + 1);
    	String str = (char)(97 + root.val) + succ;
    	if (root.left == null && root.right == null) {
    		return str;
    	}
    	String left = helper(str, root.left);
    	String right = helper(str, root.right);
    	return left.compareTo(right) < 0 ? left : right;
    }
}
