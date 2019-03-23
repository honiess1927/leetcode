class Solution {
    public int maxProfit(int[] prices) {
    	if (prices.length < 2) return 0;
    	int cur = Integer.MAX_VALUE, res = 0;
    	for (int price : prices) {
    		if (price > cur) res += price - cur;
    		cur = price;
    	}
        return res;
    }
}
