class Solution {
    public int longestLine(int[][] M) {
        int n = M.length, m = n == 0 ? 0 : M[0].length;
        int[][][] a = new int[n][m][4];
        int res = 0;
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		if (M[i][j] == 1) {
        			a[i][j][0] = i > 0 ? a[i - 1][j][0] + 1 : 1;
        			a[i][j][1] = j > 0 ? a[i][j - 1][1] + 1 : 1;
        			a[i][j][2] = i > 0 && j > 0 ? a[i-1][j-1][2] + 1 : 1;
        			a[i][j][3] = i > 0 && j < m - 1 ? a[i - 1][j + 1][3] + 1 : 1;
        			res = max(res, a[i][j]);
        		}
        	}
        }
        return res;
    }

    private int max(int a, int[] b) {
    	int max = a;
    	for (int num : b) {
    		max = Math.max(max, num);
    	}
    	return max;
    }
}
