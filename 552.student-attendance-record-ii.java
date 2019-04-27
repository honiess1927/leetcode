class Solution {
    public int checkRecord(int n) {
    	final int MOD = 1000000000 + 7;
        int[] prev = new int[]{1, 1, 1, 0, 0, 0}, cur = new int[6];
        for (int i = 1; i < n; i++) {
        	cur[0] = ((prev[0] + prev[2]) % MOD + prev[4]) % MOD;
        	cur[1] = (((cur[0] + prev[1]) % MOD + prev[3]) % MOD + prev[5]) % MOD;
        	cur[2] = prev[0];
        	cur[3] = prev[1];
        	cur[4] = prev[2];
        	cur[5] = prev[3];
        	int[] tmp = prev;
        	prev = cur;
        	cur = tmp;
        	// print(cur);
        }
        int res = 0;
        for (int num : prev) res = (res + num) % MOD;
        return res;
    }

private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
}
