class Solution {
	public String longestPalindrome(String s) {
		int start = 0, maxLen = 0;
		for (int i = 0; i < s.length(); i++) {
        	//i is the mid point
			int l = i, r = i;
			while (l >= 0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)) {
				if (r - l + 1 > maxLen) {
					start = l;
					maxLen = r - l + 1;
				}
				l--;
				r++;
			}
			l = i;
			r = i + 1;
			while (l >= 0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)) {
				if (r - l + 1 > maxLen) {
					start = l;
					maxLen = r - l + 1;
				}
				l--;
				r++;
			}
		}
		return s.substring(start, start + maxLen);
	}

}
