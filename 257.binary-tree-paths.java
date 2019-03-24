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
    public List<String> binaryTreePaths(TreeNode root) {
    	List<String> res = new LinkedList<>();
    	if (root == null) return res;
    	if (root.left == null && root.right == null) {
    		res.add(String.valueOf(root.val));
    		return res;
    	}
    	String prefix = String.valueOf(root.val) + "->";
    	for (String s : binaryTreePaths(root.left)) {
    		res.add(prefix + s);
    	}
    	for (String s: binaryTreePaths(root.right)) {
    		res.add(prefix + s);
    	}
    	return res;
    }
}
