class Solution {
    public int earliestAcq(int[][] logs, int N) {
        int[] uf = new int[N];
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < N; i++) uf[i] = i;
        for (int[] log : logs) {
            int root1 = log[1];
            while (root1 != uf[root1]) root1 = uf[root1];
            int root2 = log[2];
            while (root2 != uf[root2]) root2 = uf[root2];
            if (root1 != root2) {
                uf[root2] = root1;
                N--;
            }
            if (N == 1) return log[0];
        }
        return -1;
    }
}
