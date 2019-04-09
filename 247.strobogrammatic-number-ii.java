class Solution {
	public List<String> findStrobogrammatic(int n) {
		Map<Character, Character> map = new HashMap<>();
		map.put('0', '0');
		map.put('1', '1');
		map.put('6', '9');
		map.put('9', '6');
		map.put('8', '8');
		List<String> res = new LinkedList<>();
		if (n == 1) res.add("0");
		dfs(res, map, 0, n - 1, new char[n]);
		return res;
	}

	private void dfs(List<String> res, Map<Character, Character> map, int l, int r, char[] chs) {
		if (l > r) {
			res.add(new String(chs));
			return;
		}
		for (Map.Entry<Character, Character> entry : map.entrySet()) {
			if (l == 0 && entry.getKey() == '0') continue;
			if (l == r && entry.getKey() != entry.getValue()) continue;
			chs[l] = entry.getKey();
			chs[r] = entry.getValue();
			dfs(res, map, l + 1, r - 1, chs);
		}
	}


}
