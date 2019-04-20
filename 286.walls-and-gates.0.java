class Solution {
	final int INF = Integer.MAX_VALUE;
	public void wallsAndGates(int[][] rooms) {
		Queue<int[]> queue = new LinkedList<>();
		int m = rooms.length, n = m == 0 ? 0 : rooms[0].length;
		final int[][] POS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (rooms[i][j] == 0) queue.offer(new int[]{i, j, 0});
			}
		}

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0], y = cur[1], dis = cur[2];
			if (rooms[x][y] == INF) rooms[x][y] = dis;
			for (int[] p : POS) {
				int xx = x + p[0], yy = y + p[1];
				if (xx < 0 || yy < 0 || xx >= m || yy >= n || rooms[xx][yy] != INF) continue;
				queue.offer(new int[]{xx, yy, dis + 1});
			}
		}
	}
}
