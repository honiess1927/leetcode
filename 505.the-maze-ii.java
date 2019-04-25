class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
    	final int[][] POS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        // [0] = x, [1] = y, [2] = dist
        int n = maze.length, m = maze.length == 0? 0 : maze[0].length;
        boolean[][] visited = new boolean[n][m];
        pq.offer(new int[]{start[0], start[1], 0});
        while (!pq.isEmpty()) {
        	int[] cur = pq.poll();
        	// print(Arrays.toString(cur));
        	int x = cur[0], y = cur[1], dist = cur[2];
        	if (x == destination[0] && y == destination[1]) return dist;
        	if (visited[x][y]) continue;
        	visited[x][y] = true;
        	for (int[] p : POS) {
        		int xx = x + p[0], yy = y + p[1];
        		while (xx >= 0 && xx < n && yy >= 0 && yy < m && maze[xx][yy] == 0) {
        			xx += p[0];
        			yy += p[1];
        		}
        		xx -= p[0];
        		yy -= p[1];
        		if ((xx != x || yy != y) && !visited[xx][yy]) pq.offer(new int[]{xx, yy, dist + Math.abs(xx - x) + Math.abs(yy - y)});
        	}
        }
        return -1;
    }
    private void print(Object x) {System.out.print(x + " ");}
}
