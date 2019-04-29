class Solution {
	int n, m;
	final int[][] POS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
		int original = grid[r0][c0];
		if (original == color) return grid;
		n = grid.length;
		m = grid[0].length;
		int[][] res = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				res[i][j] = grid[i][j];
		}
		dfs(grid, res, r0, c0, color, original);
		return res;
	}

	private boolean dfs(int[][] grid, int[][] res, int x, int y, int color, int original) {
		if (x < 0 || x >= n || y < 0 || y >= m) return true;
		if (grid[x][y] == 1001) return true;
		if (grid[x][y] == 0) return false;
		if (grid[x][y] != original) {
			grid[x][y] = 1001;
			return true;
		}
		grid[x][y] = 0;
		for (int[] p : POS) {
			if (dfs(grid, res, x + p[0], y + p[1], color, original)) res[x][y] = color;
		}
		return false;
	}
}
