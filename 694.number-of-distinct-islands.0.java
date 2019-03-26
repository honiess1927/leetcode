class Solution {
    public int numDistinctIslands(int[][] grid) {
        if (grid.length < 1) return 0;
        Set<String> set = new HashSet<>();
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[][] pos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[0].length; j++) {
        		if (grid[i][j] == 1) {
        			queue.offer(new int[]{0, 0});
        			StringBuilder sb = new StringBuilder();
        			while (!queue.isEmpty()) {
        				int x = queue.peek()[0], y = queue.poll()[1];
        				int xx = x + i, yy = y + j;
        				if (xx < 0 || yy < 0 || xx >= grid.length || yy >= grid[0].length || grid[xx][yy] == 0) continue;
        				grid[xx][yy] = 0;
        				sb.append(x).append(':').append(y).append('|');
        				for (int k = 0; k < 4; k++) {
        					queue.offer(new int[]{x + pos[k][0], y + pos[k][1]});
        				}
        			}
        			set.add(sb.toString());
        			// System.out.println(i + ":" + j + "=" + sb.toString());
        		}
        	}
        }
        // System.out.println(set);
        return set.size();
    }
}
