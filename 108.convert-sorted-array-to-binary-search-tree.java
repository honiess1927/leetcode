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
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int l, int r) {
    	// System.out.println(l + ":" + r);
    	if (l > r) return null;
    	int mid = (r + l) / 2;
    	TreeNode root = new TreeNode(nums[mid]);
    	root.left = buildTree(nums, l, mid - 1);
    	root.right = buildTree(nums, mid + 1, r);
    	return root;
    }
}
