class Solution {
    public int arrangeCoins(int n) {
        // n >= [a * (a - 1)] / 2
        // a * (a - 1) <= 2 * n
        // (a - 1) * (a - 1) < a * (a - 1) <= 2 * n
        // a - 1 < sqrt(2 * n)
        // a < sqrt(2 * n) + 1

        int l = 0, r = (int) (Math.sqrt(n) * Math.sqrt(2));
        while (l < r) {
        	int mid = l + (r - l + 1) / 2;
        	// System.out.println(l + ":" + r + "      ");
        	int product = mid % 2 == 0? mid / 2 * (mid + 1) : (mid + 1) / 2 * mid;
        	// System.out.println(product);
        	if (product <= n) {
        		l = mid;
        	} else {
        		r = mid - 1;
        	}
        }
        return l;
    }
}
