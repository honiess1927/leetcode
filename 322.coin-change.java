class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        f[0] = 0;
        for (int i = 1; i <= amount; i++) {
        	f[i] = f[i] == 0 ? Integer.MAX_VALUE : f[i];
        	for (int coin : coins) {
        		int prev = i - coin;
        		if (prev >= 0 && f[prev] != Integer.MAX_VALUE) {
        			f[i] = Math.min(f[i], f[prev] + 1);
        		}
        	}
        }
        // System.out.println(Arrays.toString(f));
        return f[amount] == Integer.MAX_VALUE ? -1 : f[amount];
    }
}
