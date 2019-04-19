class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if (n == 0) return new int[]{1};
        digits[n - 1]++;
        for (int i = n - 1; i >= 1; i--) {
        	if (digits[i] == 10) {
        		digits[i - 1]++;
        		digits[i] -= 10;
        	}
        }
        int[] res;
        if (digits[0] == 10) {
        	res = new int[n + 1];
        	res[0] = 1;
        	digits[0] -= 10;
        } else {
        	res = new int[n];
        }
        for (int i = 1; i <= n; i++) {
        	res[res.length - i] = digits[n - i];
        }
        return res;
    }
}
