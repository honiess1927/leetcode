class Solution {
	Map<String, Integer> memo = new HashMap<>();
	public int kSimilarity(String A, String B) {
		return dfs(0, A.toCharArray(), B.toCharArray());
	}

	private int dfs(int i, char[] aa, char[] bb) {
		if (i == aa.length) return 0;
		if (aa[i] == bb[i]) return dfs(i + 1, aa, bb);
		String aas = toString(aa,i);
		int res = memo.getOrDefault(aas, Integer.MAX_VALUE);
		if (res != Integer.MAX_VALUE) return res;
        //aa[j] == bb[i]
		// print(bb[i]);
		// print(Arrays.toString(aa));
		for (int j = i + 1; j < aa.length; j++) {
			if (aa[j] != bb[i] || bb[j] == aa[j]) continue;
			swap(aa, i, j);
			res = Math.min(res, dfs(i + 1, aa, bb));
			swap(aa, j, i);
		}
		memo.put(aas, res + 1);
		return res + 1;
	}

	private String toString(char[] aa, int i) {
		StringBuilder sb = new StringBuilder();
		for (int j = i; j < aa.length; j++) sb.append(aa[j]);
			return sb.toString();
	}

	private void swap(char[] aa, int i, int j) {
		char tmp = aa[i];
		aa[i] = aa[j];
		aa[j] = tmp;
	}
	
	private void print(Object x) { System.out.print(String.valueOf(x) + " "); }
}
