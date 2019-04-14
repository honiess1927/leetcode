class Solution {
	public int findPaths(int m, int n, int N, int I, int J) {
		int[][][] f = new int[m + 2][n + 2][N + 1];
		int MOD = 1000000000 + 7;
		for (int i = 0; i < n + 2; i++) {
			f[0][i][0] = 1;
			f[m + 1][i][0] = 1;
		}
		for (int i = 0; i < m + 2; i++) {
			f[i][0][0] = 1;
			f[i][n + 1][0] = 1;
		}
		int[][] pos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i < m + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					for (int p = 0; p < 4; p++) {
						f[i][j][k] += f[i + pos[p][0]][j + pos[p][1]][k - 1];
						f[i][j][k] %= MOD;
					}

				}
			}
			// for (int i = 0; i <= m + 1; i++) {
			// 	for (int j = 0; j <= n + 1; j++) {
			// 		System.out.print(f[i][j][k]);
			// 	}
			// 	System.out.print("\t");
			// }
		}
		int res = 0;
		for (int i = 1; i <= N; i++) {
			res += f[I + 1][J + 1][i];
			res %= MOD;
		}
		return res;
	}
}
