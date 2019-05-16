class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] f = new int[n][n];
        for (int l = 1; l <= n; l++) {
        	for (int i = 0; i + l <= n; i++) {
        		int j = i + l - 1;
        		for (int k = i; k <= j; k++) {
        			f[i][j] = Math.max(f[i][j], calc(nums, f, i, k, j));
        			// print(i,j,k,":", f[i][j]);
        		}
        	}
        }
        return n == 0 ? 0 : f[0][n - 1];
    }

    private int calc(int[] nums, int[][] f, int i, int k, int j) {
    	int lsum = k == 0? 0 : f[i][k - 1];
    	int rsum = k == nums.length - 1 ? 0 : f[k + 1][j];
    	int left = i == 0 ? 1 : nums[i - 1];
    	int right = j == nums.length - 1 ? 1 : nums[j + 1];
    	return left * nums[k] * right + lsum + rsum;
    }
    private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
}
