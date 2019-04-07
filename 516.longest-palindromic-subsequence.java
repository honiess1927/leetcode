class Solution {
	// Brute Force, this solution died.
	// int maxLen = 0;
 //    public int longestPalindromeSubseq(String s) {
 //        dfs(s, 0, new StringBuilder());
 //        return maxLen;
 //    }

 //    private void dfs(String s, int i, StringBuilder sb) {
 //    	if (i == s.length()) {
 //    		return;
 //    	}
 //    	sb.append(s.charAt(i));
 //    	if (isPalindrome(sb)) maxLen = Math.max(sb.length(), maxLen);
 //    	dfs(s, i + 1, sb);
 //    	sb.deleteCharAt(sb.length() - 1);
 //    	dfs(s, i + 1, sb);
 //    }

 //    private boolean isPalindrome(StringBuilder sb) {
 //    	int l = 0, r = sb.length() - 1;
 //    	while (l < r) {
 //    		if (sb.charAt(l) != sb.charAt(r)) return false;
 //    		l++;
 //    		r--;
 //    	}
 //    	return true;
 //    }
	public int longestPalindromeSubseq(String s) {
		int[][] f = new int[s.length()][s.length()];
		for (int i = 0; i < f.length; i++) f[i][i] = 1;
		for (int i = 1; i < s.length(); i++) {
			for (int l = 0; l + i < s.length(); l++) {
				int r = l + i;
				if (s.charAt(l) == s.charAt(r)) {
					f[l][r] = f[l + 1][r - 1] + 2;
					// System.out.print(l + ":" + r + "=" + f[l][r] + "    ");
				} else {
					f[l][r] = Math.max(f[l + 1][r], f[l][r - 1]);
				}
			}
		}
		return f[0][s.length() - 1];
	}
}
