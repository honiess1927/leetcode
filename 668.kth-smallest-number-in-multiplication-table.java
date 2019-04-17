class Solution {
    public int findKthNumber(int m, int n, int k) {
    	int l = 1, r = m * n;
    	while (l < r) {
    		int mid = l + (r - l) / 2;
    		if (count(mid, m, n) >= k) r = mid;
    		else l = mid + 1;
    	}
    	return l;
    }

    private int count(int x, int m, int n) {
    	int res = 0;
    	for (int i = 1; i <= m; i++) {
    		res += Math.min(x / i, n);
    	}
    	return res;
    }
}
