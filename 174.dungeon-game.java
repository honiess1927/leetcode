class Solution {
	public int calculateMinimumHP(int[][] dungeon) {
		int n = dungeon.length, m = dungeon[n - 1].length;
		int[][] f = new int[n + 1][m + 1];
		for (int i = 0; i < n + 1; i++) 
			f[i][m] = Integer.MAX_VALUE;
		for (int i = 0; i < m + 1; i++) 
			f[n][i] = Integer.MAX_VALUE;
		f[n][m-1] = 1;
		for (int x = n - 1; x >= 0; x--) {
			for (int y = m - 1; y >= 0; y--) {
				f[x][y] = Math.max(1, Math.min(f[x + 1][y], f[x][y + 1]) - dungeon[x][y]);
			}
		}
		return f[0][0];

	}
}

