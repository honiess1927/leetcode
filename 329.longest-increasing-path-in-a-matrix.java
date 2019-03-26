class Solution {
	int[][] res;
	public int longestIncreasingPath(int[][] matrix) {
		if (matrix.length < 1) return 0;
		int n = matrix.length, m = matrix[0].length;
		res = new int[n][m];
		int longest = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (res[i][j] == 0) {
					dfs(matrix, i, j, matrix[i][j] - 1);
				}
				longest = Math.max(longest, res[i][j]);
			}
		}
		return longest;
	}

	private int dfs(int[][] matrix, int i, int j, int prev) {
		if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) return 0;
		if (prev >= matrix[i][j]) return 0;
		if (res[i][j] != 0) return res[i][j];
		int longest = 0;
		longest = Math.max(dfs(matrix, i + 1, j, matrix[i][j]), longest);
		longest = Math.max(dfs(matrix, i - 1, j, matrix[i][j]), longest);
		longest = Math.max(dfs(matrix, i, j + 1, matrix[i][j]), longest);
		longest = Math.max(dfs(matrix, i, j - 1, matrix[i][j]), longest);
		res[i][j] = ++longest;
		return longest;
	}
}
