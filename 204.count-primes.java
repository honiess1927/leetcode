class Solution {

    // public int countPrimes(int n) {
    // 	if (n <= 2) return 0;
    //     int cnt = 1;
    //     for (int i = 3; i < n; i+=2) {
    //     	if (isPrime(i)) cnt++;
    //     }
    //     return cnt;
    // }

    // private boolean isPrime(int n) {
    // 	if (n % 2 == 0) return n == 2;
    // 	for (int i = 3; i <= n / i; i += 2) {
    // 		if (n % i == 0) return false;
    // 	}
    // 	return true;
    // }

    public int countPrimes(int n) {
    	if (n <= 2) return 0;
    	boolean[] flag = new boolean[n];
    	int res = 1, upper = (int)Math.sqrt(n);
    	for (int i = 3; i < n; i+= 2) {
    		if (!flag[i]) res++;
    		if (res > upper) continue;
    		for (int j = 3; j * res < n; j+=2) {
    			flag[j * res] = true;
    		}
    	}
    	return res;
    }
}
