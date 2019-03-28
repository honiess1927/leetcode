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
        int[] res = helper(root);
        return res[2];
    }

    public int[] helper(TreeNode root) {
    	int[] res = new int[3];
    	if (root == null) return res;
    	int[] left = helper(root.left);
    	int[] right = helper(root.right);
    	int leftUp = 0, leftDown = 0, rightUp = 0, rightDown = 0, zig = 1;
    	if (root.left != null) {
    		if (root.left.val + 1 == root.val) leftUp = left[0];
    		else if (root.left.val - 1 == root.val) leftDown = left[1];
    	}
    	if (root.right != null) {
    		if (root.right.val + 1 == root.val) rightUp = right[0];
    		else if (root.right.val - 1 == root.val) rightDown = right[1];
    	}
    	if (root.left != null && root.right != null) {
    		if (root.left.val + 1 == root.val && root.right.val - 1 == root.val) zig = left[0] + right[1] + 1;
    		else if (root.left.val - 1 == root.val && root.right.val + 1 == root.val) zig = left[1] + right[0] + 1;
    	}
    	res[0] = Math.max(leftUp, rightUp) + 1;
    	res[1] = Math.max(leftDown, rightDown) + 1;
    	res[2] = Math.max(zig, Math.max(left[2], right[2]));
    	res[2] = Math.max(res[2], Math.max(res[0], res[1]));
    	// System.out.println(root.val + " " + Arrays.toString(res));
    	return res;
    }
}
