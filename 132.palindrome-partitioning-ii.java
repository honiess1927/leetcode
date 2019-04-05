class Solution {
	HashMap<String, Integer> map;
    public int minCut(String s) {
    	map = new HashMap<>();
        return minCutHelper(s, 0) - 1;
    }

    public int minCutHelper(String s, int cut) {
    	if (s.isEmpty()) return cut;
    	if (map.containsKey(s)) return cut + map.get(s);
    	int res = Integer.MAX_VALUE;
    	for (int i = 0; i < s.length(); i++) {
    		if (isPalindrome(s, i)) {
    			res = Math.min(res, minCutHelper(s.substring(i + 1), cut + 1));
    		}
    	}
    	map.put(s, res - cut);
    	// System.out.println(map);

    	return res;
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

/// abcdcbaeeeabcd
