class Solution {
	public int numIslands(char[][] grid) {
		if (grid.length == 0) return 0;
		int n = grid.length, m = grid[0].length;
		int res = 0;

        // BFS
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == '1') {
					res++;
					Queue<int[]> queue = new LinkedList<>();
					queue.offer(new int[]{i, j});
					while (!queue.isEmpty()) {
						int[] p = queue.poll();
						int x = p[0], y = p[1];
						if (grid[x][y] != '1') continue;
						grid[x][y] = '0';
						if (x > 0 && grid[x - 1][y] == '1') queue.offer(new int[]{x-1, y});
						if (x < n - 1 && grid[x + 1][y] == '1') queue.offer(new int[]{x+1, y});
						if (y > 0 && grid[x][y-1] == '1') queue.offer(new int[]{x, y-1});
						if (y < m -1 && grid[x][y+1] == '1') queue.offer(new int[]{x, y+1});
					}

				}
			}
		}

		return res;
	}
}
