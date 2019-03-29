class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int[] treedis = new int[nuts.length];
        int treesum = 0;
        for (int i = 0; i < treedis.length; i++) {
        	treedis[i] = Math.abs(tree[0] - nuts[i][0]) + Math.abs(tree[1] - nuts[i][1]);
        	treesum += 2 * treedis[i];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nuts.length; i++) {
        	int dis = Math.abs(squirrel[0] - nuts[i][0]) + Math.abs(squirrel[1] - nuts[i][1]);
        	min = Math.min(min, dis - treedis[i]);
        }
        return treesum + min;
    }
}
