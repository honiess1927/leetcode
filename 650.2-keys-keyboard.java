 class Solution {
    public int minSteps(int n) {
    	int[] f = new int[n + 1];
    	for (int i = 2; i <= n; i++) {
    		f[i] = Integer.MAX_VALUE;
    		for (int j = i - 1; j >= 0; j--) {
    			if (i % j == 0) {
    				f[i] = f[j] + i / j;
    				break;
    			}
    		}
    	}
    	return f[n];
    }
}
