class Solution {
	int[][] matrix;
	boolean[][] canFlow;
	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> res = new LinkedList<>();
		if (matrix.length < 1) return res;
		this.matrix = matrix;
		canFlow = new boolean[matrix.length][matrix[0].length];
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) 
			dfs(matrix[i][0], i, 0, visited, false, res);
		for (int j = 0; j < matrix[0].length; j++) 
			dfs(matrix[0][j], 0, j, visited, false, res);
		visited =  new boolean[matrix.length][matrix[0].length];
		// for (int i = 0; i < canFlow.length; i++) 
			// System.out.println(Arrays.toString(canFlow[i]));
		for (int i = 0; i < matrix.length; i++) 
			dfs(matrix[i][matrix[0].length - 1], i, matrix[0].length - 1, visited, true, res);
		for (int j = 0; j < matrix[0].length; j++) 
			dfs(matrix[matrix.length - 1][j], matrix.length - 1, j, visited, true, res);
		return res;
	}

	public void dfs(int prevHeight, int x, int y, boolean[][] visited, boolean addRes, List<int[]> res) {
		if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) return;
		if (visited[x][y]) return;
		if (prevHeight> matrix[x][y]) return;
		visited[x][y] = true;
		if (!addRes) canFlow[x][y] = true;
		else if (canFlow[x][y]) res.add(new int[]{x, y});
		dfs(matrix[x][y], x - 1, y, visited, addRes, res);
		dfs(matrix[x][y], x + 1, y, visited, addRes, res);
		dfs(matrix[x][y], x, y - 1, visited, addRes, res);
		dfs(matrix[x][y], x, y + 1, visited, addRes, res);
	}
}

/**
  Pacific ~   ~   ~   ~   ~
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic
**/
