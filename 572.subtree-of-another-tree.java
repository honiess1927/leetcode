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
    public boolean isSubtree(TreeNode s, TreeNode t) {
    	if (isSameTree(s, t)) return true;
    	if (s == null || t == null) return false;
    	return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSameTree(TreeNode s, TreeNode t) {
    	if (s == null || t == null) {
        	return s == null && t == null;
        }
        if (s.val == t.val) return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        return false;
    }
}
