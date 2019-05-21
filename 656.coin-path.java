class Solution {
    public List<Integer> cheapestJump(int[] A, int B) {
        int n = A.length;
        int[] f = new int[n], path = new int[n];
        LinkedList<Integer> res = new LinkedList<>();
        if (n != 0 && A[n-1] == -1) return res;
        Arrays.fill(f, Integer.MAX_VALUE);
        f[n-1] = A[n-1];
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] == -1) continue;
            for (int j = i + 1; j <= Math.min(i + B, A.length - 1); j++) {
                if (f[j] == Integer.MAX_VALUE) continue;
                if (f[j] + A[i] < f[i]) {
                    f[i] = A[i] + f[j];
                    path[i] = j + 1;
                }
            }
            // print(f, path, "      ");
        }

        int index = 0;
        if (n != 1 && path[index] == 0) return res;
        while (index != n - 1) {
            res.add(index + 1);
            index = path[index] - 1;
        }
        res.add(n);
        return res;
    }

    private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
}
