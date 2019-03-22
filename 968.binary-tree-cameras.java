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
    public int minCameraCover(TreeNode root) {
        int[] res = cam(root);
        return minn(res[1], res[2]);
    }

    private int[] cam(TreeNode root) {
    	int[] res = new int[3];
    	if (root == null) {
    		res[2] = 2000;
    		res[0] = 2000;
    		return res;
    	}
    	int[] left = cam(root.left);
    	int[] right = cam(root.right);
    	res[0] = left[1] + right[1];
    	res[1] = minn(left[1] + right[2], left[2] + right[2], left[2] + right[1]);
    	res[2] = minn(left) + minn(right) + 1;
    	return res;
    }

    private int minn(int... nums) {
    	int min = Integer.MAX_VALUE;
    	for (int num : nums) min = Math.min(min, num);
    	return min;
    }
}
