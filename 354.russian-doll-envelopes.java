class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
        	if (a[0] == b[0]) return a[1] - b[1];
        	else return a[0] - b[0];
        });
        int[] f = new int[envelopes.length];
        int max = 0;
        for (int i = 0; i < f.length; i++) {
        	f[i] = 1;
        	for (int j = 0; j < i; j++) {
        		if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
        			f[i] = Math.max(f[i], f[j] + 1);
        		}
        	}
        	max = Math.max(f[i], max);
        }
        return max;
    }
}
