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
    public List<List<Integer>> findLeaves(TreeNode root) {
    	List<List<Integer>> res = new LinkedList<>();
    	deleteNodes(root, res);
    	return res;
    }

    public int deleteNodes(TreeNode root, List<List<Integer>> res) {
    	if (root == null) return -1;
    	int level = Math.max(deleteNodes(root.left, res), deleteNodes(root.right, res)) + 1;
    	if (res.size() < level + 1) res.add(new LinkedList<>());
    	res.get(level).add(root.val);
    	return level;
    }
}
