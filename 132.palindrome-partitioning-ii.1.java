class Solution {
    public int minCut(String s) {
        // Loop through the string to find all palindromic substrings.
        boolean[][] is = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
        	extendPalindrome(s, i, i, is);
        	extendPalindrome(s, i, i + 1, is);
        }

        //DP
        //f[i] = minCut of s.substring(0, i);
        int[] f = new int[s.length()];
        for (int i = 1; i < f.length; i++) {
        	f[i] = Integer.MAX_VALUE;
        	for (int j = 0; j <= i; j++) {
        		if (is[j][i]) {
        			f[i] = (j == 0) ? 0 : Math.min(f[i], f[j - 1] + 1);
        		}
        	}
        }
        return f[s.length() - 1];
    }

    private void extendPalindrome(String s, int l, int r, boolean[][] is) {
    	while (l >= 0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)) {
    		is[l][r] = true;
    		l--;
    		r++;
    	}
    }
}
