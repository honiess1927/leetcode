class Solution {
    public void wallsAndGates(int[][] rooms) {
        final int INF = Integer.MAX_VALUE;
        final int[][] POS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < rooms.length; i++) {
        	for (int j = 0; j < rooms[i].length; j++) {
        		if (rooms[i][j] != INF) continue;
        		Queue<int[]> queue = new LinkedList<>();
        		queue.offer(new int[]{i, j, 0});
        		boolean[][] visited = new boolean[rooms.length][rooms[i].length];
        		while (!queue.isEmpty()) {
        			int[] cur = queue.poll();
        			int x = cur[0], y = cur[1], dis = cur[2];
        			if (x < 0 || y < 0 || x >= rooms.length || y >= rooms[i].length || visited[x][y] || rooms[x][y] == -1) continue;
        			visited[x][y] = true;
        			if (rooms[x][y] == 0) {
        				rooms[i][j] = Math.min(dis, rooms[i][j]);
        				break;
        			} else if (rooms[x][y] != INF) {
        				rooms[i][j] = Math.min(rooms[i][j], dis + rooms[x][y]);
        				continue;
        			}
        			for (int[] p : POS) {
        				queue.offer(new int[]{x + p[0], y + p[1], dis + 1});
        			}
        		}
        	}
        }
    }
}
