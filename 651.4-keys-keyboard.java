class Solution {
    public int maxA(int N) {
        int[] f = new int[N + 1];
        for (int i = 1; i <= N; i++) {
        	f[i] = i;
        	for (int j = 1; j <= i - 3; j++) f[i] = Math.max(f[i], f[j] * (i - j - 1));
        }
    // print(f);
    return f[N];
    }
    private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
}
