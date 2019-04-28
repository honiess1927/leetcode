class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] f = new int[A.length + 1][B.length + 1];
        for (int i = 1; i <= A.length; i++) {
        	for (int j = 1; j <= B.length; j++) {
        		if (A[i - 1] == B[j - 1]) f[i][j] = f[i - 1][j - 1] + 1;
        		else f[i][j] = Math.max(f[i-1][j], f[i][j - 1]);
        	}
        }
        return f[A.length][B.length];
    }
}
