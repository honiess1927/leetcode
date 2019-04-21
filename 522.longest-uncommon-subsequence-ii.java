class Solution {
	public int findLUSlength(String[] strs) {
		int n = strs.length;
		int[] cnt = new int[n];    
		int res = -1;
		for (int i = 0; i < n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				if (i == j) cnt[j] = strs[i].length();
				else cnt[j] = helper(strs[i], strs[j]);
				min = Math.min(min, cnt[j]);
			}
			res = Math.max(res, min);
		}    
		// print(cnt);
		return res;
	}

	private int helper(String a, String b) {
		if (a.length() > b.length()) return a.length();
		if (dfs(a, b, 0, 0)) return -1;
		return a.length();
	}

	private boolean dfs(String a, String b, int i, int j) {
		if (i == a.length()) return true;
		if (j == b.length()) return false;
		if (a.charAt(i) != b.charAt(j)) return dfs(a, b, i, j + 1);
		return dfs(a, b, i + 1, j + 1);
	}

	private void print(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(Arrays.toString(a[i]) + "     ");
		}
	}

	//build up a matrix like:
	/*
		ab 	abd 	abd
	ab 	2	-1		-1
	abd 3	3		-1
	abd 3	-1 		3
	*/
	// Find the max value of the min value of each line.
}
