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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxLevel = 1, maxSum = Integer.MIN_VALUE, curLevel = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            int sum = 0;
            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            if (sum > maxSum) {
                maxLevel = curLevel;
                maxSum = sum;
            }
            curLevel++;
        }
        return maxLevel;
    }
    private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
}
