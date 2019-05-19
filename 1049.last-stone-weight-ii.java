class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        boolean[] f = new boolean[sum / 2 + 1];
        f[0] = true;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < stones.length; i++) {
            for (int j = f.length - 1; j >= stones[i]; j--) {
                if (f[j - stones[i]]) {
                    f[j] = true;
                    res = Math.min(res, sum - 2 * j);
                }
            }
        }
        return res;
    }
}
