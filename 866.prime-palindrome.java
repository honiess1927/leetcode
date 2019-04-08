class Solution {
	/*
	Intuition:
	All palindrome with even digits is multiple of 11.

	We can prove as follow:

	11 % 11 = 0
	1111 % 11 = 0
	111111 % 11 = 0
	11111111 % 11 = 0

	So:
	1001 % 11 = (1111 - 11 * 10) % 11 = 0
	100001 % 11 = (111111 - 1111 * 10) % 11 = 0
	10000001 % 11 = (11111111 - 111111 * 10) % 11 = 0

	For any palindrome with even digits:
	abcddcba % 11
	= (a * 10000001 + b * 100001 * 10 + c * 1001 * 100 + d * 11 * 1000) % 11
	= 0

	All palindrome with even digits is multiple of 11.
	So among them, 11 is the only one prime
	if (8 <= N <= 11) return 11
	*/
    public int primePalindrome(int N) {
        if (N >= 8 && N <= 11) return 11;
        // answer is guaranteed in 2 * 10^8
        // anser < 199999991
        int x = 0;
        for (int i = 0; i < 19999; i++) {
        	String s = String.valueOf(i);
        	String rev = new StringBuilder(s).reverse().substring(1).toString();
        	 x = Integer.parseInt(s + rev);
        	if (x >= N && isPrime(x)) break;
        }
        return x;
    }

    private boolean isPrime(int x) {
    	if (x < 2) return false;
    	if (x % 2 == 0) return x == 2;
    	for (int i = 3; i * i <= x; i+= 2) {
    		if (x % i == 0) return false;
    	}
    	return true;
    }
}
