class Solution {
	public double champagneTower(int poured, int query_row, int query_glass) {
		double[][] f = new double[query_row + 2][query_row + 3];
		f[0][0] = poured;
		for (int i = 0; i <= query_row; i++) {
			for (int j = 0; j < i + 1; j++) {
				if (f[i][j] > 1) {
					f[i+1][j] += (f[i][j] - 1) / 2.0;
					f[i + 1][j + 1] = (f[i][j] - 1) / 2.0;
					f[i][j] = 1;
				}
			}
		}
		return f[query_row][query_glass];
	}
}
