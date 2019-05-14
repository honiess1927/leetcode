 class Solution {
    public int minSteps(int n) {
    	if (n < 2) return 0;
    	int[] f = new int[n + 1];
    	f[0] = 0;
    	f[1] = 0;
    	f[2] = 2;
    	for (int i = 3; i <= n; i++) {
    		f[i] = Integer.MAX_VALUE;
    		for (int j = 1; j < i; j++) {
    			if (i % j == 0) {
    				f[i] = Math.min(f[i], f[j] + i / j);
    			}
    		}
    	}
    	return f[n];
    }
}
