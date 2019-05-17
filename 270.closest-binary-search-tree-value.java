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
    public int closestValue(TreeNode root, double target) {
    	int res = 0;
    	double minDiff = Double.MAX_VALUE;
    	while (root != null) {
    		double diff = Math.abs(target - root.val);
    		if (diff < minDiff) {
    			minDiff = diff;
    			res = root.val;
    		}
    		if (root.val > target) root = root.left;
    		else if (root.val < target) root = root.right;
    		else break;
    	}
    	return res;
    }
}
