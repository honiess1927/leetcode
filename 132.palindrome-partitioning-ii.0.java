class Solution {
	// DP
    public int minCut(String s) {
    	if (s.isEmpty()) return 0;
    	int[] f = new int[s.length()];
    	//aab 0,1,2
    	//i = 1 j = 0
        for (int i = 1; i < s.length(); i++) {
        	f[i] = Integer.MAX_VALUE;
        	for (int j = 0; j <= i; j++) {
        		if (isPalinDrome(s, j, i)) f[i] = j == 0? 0 : Math.min( f[j - 1] + 1, f[i]);
        	}
        }
        return f[s.length() - 1];
    }

    private boolean isPalinDrome(String s, int start, int end) {
    	while (start < end) {
    		if (s.charAt(start) != s.charAt(end)) 
    			return false;
    		start++;
    		end--;
    	}
    	return true;
    }
}
