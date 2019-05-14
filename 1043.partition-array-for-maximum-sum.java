class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int[] f = new int[A.length + 1];
        for (int i = 1; i <= A.length; i++) {
        	int max = Integer.MIN_VALUE;
        	for (int j = 1; j <= K && i - j >= 0; j++) {
        		max = Math.max(max, A[i - j]);
        		f[i] = Math.max(f[i], f[i - j] + max * (j));
        	}
        }
        // print(f);
        return f[A.length];
    }
    private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
}
