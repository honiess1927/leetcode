class Solution {
    public String reverseStr(String s, int k) {
    	int start = 0;
        char[] ss = s.toCharArray();
        while (start < s.length()) {
        	int i = start, j = Math.min(s.length() - 1, i + k - 1);
        	while (i < j) {
        		char swap = ss[i];
        		ss[i] = ss[j];
        		ss[j] = swap;
        		i++;
        		j--;
        	}
        	start += 2 * k;
        }
        return new String(ss);
    }
}
