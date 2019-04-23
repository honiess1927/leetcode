class Solution {
	boolean[][] visited;
    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
    	visited = new boolean[maze.length][maze.length == 0? 0: maze[0].length];
    	return helper(maze, start, dest);
    }

    private boolean helper(int[][] maze, int[] start, int[] dest) {
    	// print(Arrays.toString(start));
    	int x = start[0], y = start[1];
    	if (x == dest[0] && y == dest[1]) return true;
        if (visited[x][y]) return false;
        visited[x][y] = true;
        int i = x, j = y;
        while (i + 1 < maze.length && maze[i + 1][j] == 0) i++;
        if (i != x && helper(maze, new int[]{i, j}, dest)) return true;
        i = x; j = y;
        while (i - 1 >= 0 && maze[i - 1][j] == 0) i--;
        if (i != x && helper(maze, new int[]{i, j}, dest)) return true;
        i = x; j = y;
        while (j - 1 >= 0 && maze[i][j - 1] == 0) j--;
        if (j != y && helper(maze, new int[]{i, j}, dest)) return true;
        i = x; j = y;
        while (j + 1 < maze[0].length && maze[i][j + 1] == 0) j++;
        if (j != y && helper(maze, new int[]{i, j}, dest)) return true;
        return false;
    }

    private void print(Object x) {System.out.print(x + " ");}
}
