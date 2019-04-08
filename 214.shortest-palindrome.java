class Solution {
    public String shortestPalindrome(String s) {
    	if (s.isEmpty()) return s;
    	int r = s.length() - 1;
    	// find the rightmost r that s.substring(0, r + 1) is a palindrome.
    	// reverse s.substring(r + 1) and insert to the head of s
    	for (; r >= 0; r--) {
    		if (isPalindrome(s, r)) break;
    	}
    	return new StringBuilder(s.substring(r + 1)).reverse().toString() + s;
    }

    public boolean isPalindrome(String s, int r) {
    	int l = 0;
    	while (l < r) {
    		if (s.charAt(l) != s.charAt(r)) return false;
    		l++;
    		r--;
    	}
    	return true;
    }
}
