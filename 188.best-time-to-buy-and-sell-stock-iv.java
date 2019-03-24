class Solution {
	public int maxProfit(int k, int[] prices) {
		if (prices.length < 2 || k == 0) return 0;
		int res = 0;
		if (k >= prices.length + 1 / 2) {
			for (int i = 1; i < prices.length; i++) {
				if (prices[i] > prices[i - 1]) res += prices[i] - prices[i - 1];
			}
			return res;
		}
		int[] f = new int[2 * k];
		for (int i = 0; i < k; i++) {
			f[2 * i + 1] = -prices[0];
		}
		// System.out.println(Arrays.toString(f));

		for (int i = 1; i < prices.length; i++) {
			res = Math.max(res, f[2 * k - 1] + prices[i]);
			for (int j = 2 * k - 1; j > 0; j--) {
				if (j % 2 == 0) f[j] = Math.max(f[j], f[j - 1] + prices[i]);
				else f[j] = Math.max(f[j], f[j - 1] - prices[i]);
			}
		}
		return res;
	}
}
