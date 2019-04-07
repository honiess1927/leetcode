class Solution {
    public boolean validPalindrome(String s) {
    	return helper(s, 0, s.length() - 1, true);
    }

    public boolean helper (String s, int l, int r, boolean flag) {
    	while (l < r) {
    		if (s.charAt(l) != s.charAt(r)) {
    			if (!flag) return false;
    			return helper(s, l + 1, r, false) || helper(s, l, r - 1, false);
    		} else {
    			l++;
    			r--;
    		}
    	}
    	return true;
    }
}
