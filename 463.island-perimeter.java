class Solution {
	public int islandPerimeter(int[][] grid) {
		int res = 0;
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					queue.offer(new int[]{i, j});
					break;
				}
			}
		}
		int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		while (!queue.isEmpty()) {
			int x = queue.peek()[0], y = queue.poll()[1];
			if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) {
				res++;
				// System.out.print(x + " " + y + "   |   ");
				continue;
			}
			if (grid[x][y] != 1) continue;
			grid[x][y] = 2;
			for (int i = 0; i < 4; i++) {
				queue.offer(new int[]{x + dir[i][0], y + dir[i][1]});
			}
		}
		return res;
	}
}
