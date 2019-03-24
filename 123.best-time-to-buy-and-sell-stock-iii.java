class Solution {
    public int maxProfit(int[] prices) {
    	if (prices.length < 2) return 0;
        int[] f = new int[3];
        f[0] = -prices[0];
        f[1] = 0;
        f[2] = -prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
        	int[] g = new int[3];
        	g[0] = Math.max(f[0], -prices[i]);
        	g[1] = Math.max(f[1], f[0] + prices[i]);
        	g[2] = Math.max(f[2], f[1] - prices[i]);
        	// System.out.println(Arrays.toString(g));
        	res = Math.max(res, f[2] + prices[i]);
        	f = g;
        }
        return res;
    }
}
