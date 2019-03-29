class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
    	int res = 0;
    	int l = 0, r = 0;
    	Map<Character, Integer> map  = new HashMap<>();
    	char[] ss = s.toCharArray();
    	while (r < ss.length) {
    		map.put(ss[r], map.getOrDefault(ss[r], 0) + 1);
    		r++;
    		while (map.size() > k) {
    			map.put(ss[l], map.get(ss[l]) - 1);
    			if (map.get(ss[l]) == 0) map.remove(ss[l]);
    			l++;
    		}
    		res = Math.max(res, r - l);
    	}
    	return res;
        
    }
}
