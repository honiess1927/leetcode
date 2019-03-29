class Solution {
    public int preimageSizeFZF(int K) {
        long l = 0, r = 5L * (K + 1);
        while (l < r) {
        	long mid = l + (r - l) / 2;
        	int tz = helper(mid);
        	// System.out.println(mid + ":" + tz);
        	if (tz == K) return 5;
        	if (tz > K) r = mid; else l = mid + 1;
        }
        return 0;
    }

    public int helper(long x) {
    	int res = 0;
    	while (x > 0) {
    		res += x / 5;
    		x = x / 5;
    	}
    	return res;
    }
}
