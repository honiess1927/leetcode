class Solution {
    public int maxProfit(int[] prices) {
    	if (prices.length < 2) return 0;
    	int min = Integer.MAX_VALUE, res = 0;
    	for (int price :prices) {
    		if (price < min) min = price;
    		else res = Math.max(price - min, res);
    	}
        return res;
    }
}
