class Solution {
    public int maxProfit(int[] prices, int fee) {
    	if (prices.length < 2) return 0;
        int[][] f = new int[prices.length][2];
        f[0][0] = 0;
        f[0][1] = -prices[0] - fee;
        for (int i = 1; i < prices.length; i++) {
        	f[i][0] = Math.max(f[i - 1][0], f[i - 1][1] + prices[i]);
        	f[i][1] = Math.max(f[i - 1][1], f[i - 1][0] - prices[i]-fee);
        }
        return f[prices.length - 1][0];
    }
}
