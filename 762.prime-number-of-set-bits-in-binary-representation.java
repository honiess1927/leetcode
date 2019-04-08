class Solution {
    public int countPrimeSetBits(int L, int R) {
    	int res = 0;
    	for (int i = L; i <= R; i++) {
    		if (isPalinDrome(countSet(i))) res++;
    	}
    	return res;
    }

    public boolean isPalinDrome(int n) {
    	if (n < 2) return false;
    	if (n % 2 == 0) return n == 2;
    	for (int i = 3; i * i <= n; i+= 2) {
    		if (n % i == 0) return false;
    	}
    	return true;
    }

    public int countSet(int n) {
    	int cnt = 0;
    	while (n != 0) {
    		cnt += n & 1;
    		n = n >>> 1;
    	}
    	return cnt;
    }
}
