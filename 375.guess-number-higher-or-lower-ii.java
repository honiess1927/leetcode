class Solution {
	int[][] memo;
	public int getMoneyAmount(int n) {
		memo = new int[n + 1][n + 1];
		return helper(1, n);
	}

	private int helper(int l, int r) {
		if (l >= r) return 0;
		if (memo[l][r] != 0) return memo[l][r];
		memo[l][r] = Integer.MAX_VALUE;
		for (int i = l; i < r; i++) {
			memo[l][r] = Math.min(memo[l][r], i + Math.max(helper(l, i - 1), helper(i + 1, r)));
		}
		// print(l, r, memo[l][r]);
		return memo[l][r];
	}

	private void print(Object... xs) { 
		for (Object x : xs) {
		if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } }
		System.out.print("     ");
	}

}
