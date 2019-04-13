class Solution {
    public String reverseOnlyLetters(String S) {
        char[] s = S.toCharArray();
        int l = 0, r = s.length - 1;
        while (l < r) {
        	while (l < r && !isChar(s[l])) l++;
        	while (l < r && !isChar(s[r])) r--;
        	if (l < r) {
        		char swap = s[l];
        		s[l] = s[r];
        		s[r] = swap;
        		l++;
        		r--;
        	}
        }
        return new String(s);
    }

    private boolean isChar(char ch) {
    	return ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'));
    }
}
