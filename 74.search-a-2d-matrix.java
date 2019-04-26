class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		int n = matrix.length, m = n == 0? 0 : matrix[0].length;
		if (n == 0) return false;
		int i = n - 1, j = 0;
		while (i >= 0 && j < m) {
			if (matrix[i][j] == target) return true;
			if (target > matrix[i][j]) j++;
			else i--;
		}        
		return false;
	}
}
