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
    	int[] res = robIt(root);
    	return Math.max(res[0], res[1]);
    }

    public int[] robIt(TreeNode root) {
    	if (root == null) return new int[2];
    	int[] left = robIt(root.left);
    	int[] right = robIt(root.right);

    	int[] res = new int[2];
    	//0 = cannot rob, 1 = can rob
    	res[0] = left[1] + right[1];
    	res[1] = Math.max(res[0], root.val + left[0] + right[0]);
    	return res;
    }

}
