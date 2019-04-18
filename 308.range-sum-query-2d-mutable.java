class NumMatrix {
	int[][] matrix, sum;
	int m, n;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        if (matrix.length == 0) return;
        n = matrix.length;
        m = matrix[0].length;
        sum = new int[n][m];
        for (int i = 0; i < n; i++) {
        	int tmp = 0;
        	for (int j = 0; j < m; j++) {
        		tmp += matrix[i][j];
        		if (i != 0) sum[i][j] = sum[i-1][j];
        		sum[i][j] += tmp;
        	}
        }
        // for (int i = 0; i < n; i++) {
        // 	System.out.print(Arrays.toString(sum[i]) + "    ");
        // }
    }
    
    public void update(int row, int col, int val) {
        int diff = val - matrix[row][col];
        matrix[row][col] = val;
        for (int i = row; i < n; i++) {
        	for (int j = col; j < m; j++) {
        		sum[i][j] += diff;
        	}
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
    	int a = sum[row2][col2];
    	int b = (row1 > 0 && col1 > 0) ? sum[row1 - 1][col1 - 1] : 0;
    	int c = (row1 > 0) ? sum[row1 - 1][col2] : 0;
    	int d = (col1 > 0) ? sum[row2][col1 - 1] : 0;
        return a + b - c - d;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
