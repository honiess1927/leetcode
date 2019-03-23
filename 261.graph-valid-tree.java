class Solution {
    public boolean validTree(int n, int[][] edges) {
    	int[] union = new int[n];
    	for (int i = 0; i < n; i++) union[i] = i;
    	for (int[] edge : edges) {
    		int x = edge[0];
    		int y = edge[1];
    		while (y != union[y]) y = union[y];
    		while (x != union[x]) x = union[x];
    		if (x == y) return false;
    		else n--;
    		union[y] = x;
    	}
    	return n == 1;
    }
}
