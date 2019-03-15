class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        for (int i = 0; i < A.length && K > 0; i++) {
        	if (A[i] < 0) {
        		K--;
        		A[i] *= -1;
        	} else break;
        }
        Arrays.sort(A);
        if (K > 0 && K % 2 == 1) A[0] *= -1;
        int res = 0;
        for (int a : A) res += a;
        return res;
    }
}
