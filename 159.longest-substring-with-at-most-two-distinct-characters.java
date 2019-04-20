class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() <= 2) return s.length();
        char a = s.charAt(0), b = a;
        int start = 0, la = 0, lb = -1, res = 0, i = 0;
        while (i < s.length()) {
        	if (s.charAt(i) == a) {
        		la = i++;
        	} else if (lb == -1) {
        		b = s.charAt(i);
        		lb = i++;
        	} else if (b == s.charAt(i)) {
        		lb = i++;
        	} else {
        		res = Math.max(res, i - start);
        		if (la > lb) {
        			start = lb + 1;
        			lb = -1;
        		} else {
        			start = la + 1;
        			la = lb;
        			a = b;
        			lb = -1;
        		}
        	}
        }
        return Math.max(res, s.length() - start);
    }
}
