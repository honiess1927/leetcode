class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new LinkedList<>();
		if (matrix.length == 0) return res;
		int startRow = 0, endRow = matrix.length - 1, startCol = 0, endCol = matrix[0].length - 1, totalElement = matrix.length * matrix[0].length;
		while (res.size() < totalElement) {
			if (startRow <= endRow) {
				for (int i = startCol; i <= endCol; i++) 
					res.add(matrix[startRow][i]);
				startRow++;
			}
			if (startCol <= endCol) {
				for (int i = startRow; i <= endRow; i++)
					res.add(matrix[i][endCol]);
				endCol--;
			}
			if (startRow <= endRow) {
				for (int i = endCol; i >= startCol; i--) 
					res.add(matrix[endRow][i]);
				endRow--;
			}
			if (startCol <= endCol) {
				for (int i = endRow; i >= startRow; i--)
					res.add(matrix[i][startCol]);
				startCol++;
			}
		}
		return res;
	}
}
