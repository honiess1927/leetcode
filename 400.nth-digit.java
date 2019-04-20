class Solution {
    public int findNthDigit(int n) {
        int x = 1, y = 9, base = 1;
        while ((int)Math.ceil(1.0 * n / y) > x) {
        	n-= x * y;
        	x++;
        	y*=10;
        	base*=10;
        }
        n--;
        // System.out.println(n + ":" + x + ":" + base);
        int rank = n / x;
        int numDigits = n % x;
        System.out.println(numDigits);
        return Integer.parseInt(String.valueOf(base + rank).substring(numDigits, numDigits + 1));
    }
}
