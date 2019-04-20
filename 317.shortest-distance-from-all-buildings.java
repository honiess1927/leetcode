class Solution {
	public int shortestDistance(int[][] grid) {
		Queue<int[]> queue = new LinkedList<>();
		int m = grid.length, n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					queue.offer(new int[]{queue.size(), i, j, 0});
					grid[i][j] = 2;
				}
			}
		}
		int numBuilding = queue.size();
		int[][][] visited = new int[numBuilding][m][n];
		int[][] pos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		int min = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int i = cur[0], x = cur[1], y = cur[2], dis = cur[3];
			if (visited[i][x][y] > 0) continue;
			visited[i][x][y] = dis;
			grid[x][y]--;
			if (grid[x][y] == -numBuilding) {
				//System.out.println(x + ":" + y + " ");
				int res = 0;
				for (int j = 0; j < numBuilding; j++) {
					res += visited[j][x][y];
					//System.out.println(visited[j][x][y]);
				}
				min = Math.min(min, res);
				//return res;
			}
			for (int[] p : pos) {
				int xx = x + p[0], yy = y + p[1];
				if (xx >= 0 && yy >= 0 && xx < m && yy < n && grid[xx][yy] <= 0)
					queue.offer(new int[]{i, xx, yy, dis + 1});
			}
		}
		return min == Integer.MAX_VALUE? -1 : min;
	}
}
