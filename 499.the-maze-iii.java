class Solution {
    private class Item implements Comparable<Item> {
    	int x, y, dist;
    	String path;
    	Item(int x, int y, int dist, String path) {
    		this.x = x;
    		this.y = y;
    		this.dist = dist;
    		this.path = path;
    	}
    	@Override
    	public int compareTo(Item other) {
    		int res = Integer.compare(dist, other.dist);
    		return res != 0? res : this.path.compareTo(other.path);
    	}
    }

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int n = maze.length, m = n == 0 ? 0 : maze[0].length;
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<Item> pq = new PriorityQueue<>();
        pq.offer(new Item(ball[0], ball[1], 0, ""));
        final int[][] POS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        String[] DIRECT = {"d", "u", "r", "l"};
        while (!pq.isEmpty()) {
        	Item cur = pq.poll();
        	if (cur.x == hole[0] && cur.y == hole[1]) return cur.path;
        	if (visited[cur.x][cur.y]) continue;
        	visited[cur.x][cur.y] = true;
        	for (int i = 0; i < POS.length; i++) {
        		int xx = cur.x + POS[i][0], yy = cur.y + POS[i][1];
        		boolean toHole = false;
        		while (xx >= 0 && xx < n && yy >= 0 && yy < m && maze[xx][yy] == 0) {
        			if (xx == hole[0] && yy == hole[1]) {
        				toHole = true;
        				break;
        			}
        			xx += POS[i][0];
        			yy += POS[i][1];
        		}
        		if (!toHole) {
        			xx -= POS[i][0];;
        			yy -= POS[i][1];
        		}
        		if ((xx != cur.x || yy != cur.y) && !visited[xx][yy]) {
        			pq.offer(new Item(xx, yy, cur.dist + Math.abs(xx - cur.x) + Math.abs(yy - cur.y), cur.path + DIRECT[i]));
        		}
        	}
        }
        return "impossible";
    }

}
