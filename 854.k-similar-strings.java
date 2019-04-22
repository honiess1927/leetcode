class Solution {
	Map<String, Integer> memo = new HashMap<>();
	public int kSimilarity(String A, String B) {
		char[] aa = A.toCharArray(), bb = B.toCharArray();
		Map<Character, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < aa.length; i++) {
			char ch = aa[i];
			map.putIfAbsent(ch, new HashSet<>());
			map.get(ch).add(i);
		}
		return dfs(map, 0, aa, bb);
	}

	private int dfs(Map<Character, Set<Integer>> map, int i, char[] aa, char[] bb) {
		if (i == aa.length) return 0;
		if (aa[i] == bb[i]) return dfs(map, i + 1, aa, bb);
		Set<Integer> index = new HashSet<>(map.get(bb[i]));
		String aas = toString(aa,i);
		int res = memo.getOrDefault(aas, Integer.MAX_VALUE);
		if (res != Integer.MAX_VALUE) return res;
        //aa[j] == bb[i]
		// print(bb[i]);
		// print(Arrays.toString(aa));
		for (int j : index) {
			if (j < i || bb[j] == aa[j]) continue;
			swap(aa, i, j, map);
			res = Math.min(res, dfs(map, i + 1, aa, bb));
			swap(aa, j, i, map);
		}
		memo.put(aas, res + 1);
		return res + 1;
	}

	private String toString(char[] aa, int i) {
		StringBuilder sb = new StringBuilder();
		for (int j = i; j < aa.length; j++) sb.append(aa[j]);
			return sb.toString();
	}

	private void swap(char[] aa, int i, int j, Map<Character, Set<Integer>> map) {
		map.get(aa[i]).remove(i);
		map.get(aa[i]).add(j);
		map.get(aa[j]).remove(j);
		map.get(aa[j]).add(i);
		char tmp = aa[j];
		aa[j] = aa[i];
		aa[i] = tmp;
	}
	private void print(Object x) { System.out.print(String.valueOf(x) + " "); }
}
