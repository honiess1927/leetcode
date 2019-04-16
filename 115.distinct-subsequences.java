class Solution {
	// int res = 0;
 //    public int numDistinct(String s, String t) {
 //        dfs(t, 0, s, 0);
 //        return res;
 //    }

 //    public void dfs(String s, int si, String t, int ti) {
 //    	// Find one match, add to res.
 //    	if (si == s.length()) {
 //    		res++;
 //    		return;
 //    	}
 //    	// Impossible to match, return.
 //    	if (t.length() - ti < s.length() - si) return;
 //    	if (s.charAt(si) == t.charAt(ti)) {
 //    		//Match this.
 //    		dfs(s, si + 1, t, ti + 1);
 //    	}
 //    	// Not match this.
 //    	dfs(s, si, t, ti + 1);
 //    }

	public int numDistinct(String t, String s) {
		int[][] f = new int[t.length() + 1][s.length() + 1];
		//f[i][j] how many dinstinct sequences = s.substring(0, j) are in t.substring(0, i)
		f[0][0] = 1;
		for (int i = 1; i <= t.length(); i++) {
			f[i][0] = 1;
			for (int j = 1; j <= s.length(); j++) {
				if (s.charAt(j - 1) == t.charAt(i - 1)) f[i][j] = f[i - 1][j - 1] + f[i - 1][j];
				else f[i][j] = f[i - 1][j];
			}
		}
		return f[t.length()][s.length()];
	}
}
