class Solution {
	public String longestPalindrome(String s) {
		int maxLen = 0, start = 0;
		int[][] f = new int[s.length()][s.length()];
		for (int len = 0; len < s.length(); len++) {
			for (int l = 0; l + len < s.length(); l++) {
				int r = l + len;
				if (s.charAt(l) == s.charAt(r)) {
					if (r - l < 2) f[l][r] = r - l + 1;
					else if (f[l + 1][r - 1] != 0) {
						f[l][r] = f[l + 1][r - 1] + 2;
					}
					if (f[l][r] > maxLen) {
						maxLen = f[l][r];
						start = l;
					}
				}
			}
		}
		return s.substring(start, start + maxLen);
	}
}
