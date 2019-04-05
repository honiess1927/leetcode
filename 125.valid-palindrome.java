class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0, r = s.length() - 1;
        while (l < r) {
        	while (l < r && !isValid(s.charAt(l))) l++;
        	while (r > l && !isValid(s.charAt(r))) r--;
        	if (s.charAt(l) != s.charAt(r)) return false;
        	l++;
        	r--;
        }
        return true;
    }

    private boolean isValid(char ch) {
    	return (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }
}
