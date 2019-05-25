class Solution {
    public double new21Game(int N, int K, int W) {
        if (K > N) return 0;
        if (K == 0) return 1.0;
        if (N == 0) return 0.0;
        double[] f = new double[K];
        f[0] = 1.0;
        double res = 0, prob = 1.0 / W;
        for (int k = 0; k < K; k++) {
            for (int i = 1; i <= W; i++) {
                int j = i + k;
                if (j < K) f[j] += f[k] * prob;
                else {
                    res += Math.min((W - i + 1), (N - j + 1)) * prob * f[k];
                    break;
                }
            }
            // print(f);
        }
        return res;
    }
    private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((double[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
}


// 0   1   2   3   4   5   6   7
// 1   1   1   1   1
// 1   1   2   2   2   1
// 1   1   2   4   4   3   2
//
// 11 2
//
// 0   1   2   3
// 1   1   1   1
// 1   1   2   2   1
