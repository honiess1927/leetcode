class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] u = new int[n];
        for (int i = 0; i < n; i++) u[i] = i;
        for (int[] edge : edges) {
        	int x = edge[0], y = edge[1];
        	while (x != u[x]) x = u[x];
        	while (y != u[y]) y = u[y];
        	if (x != y) {
        		u[y] = u[x];
        		n--;
        	}
        }
        return n;
    }
}
