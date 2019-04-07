class Solution {
	public List<String> generatePalindromes(String s) {
		int oddCount = 0;
		Map<Character, Integer> map = new HashMap<>();
		Set<Character> oddSet = new HashSet<>();
		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			if (map.get(ch) % 2 == 1) {
				oddCount++;
				oddSet.add(ch);
			}
			else {
				oddCount--;
				oddSet.remove(ch);
			}
		}
		List<String> res = new LinkedList<>();
		if (oddCount > 1 || (oddCount == 1 && s.length() % 2 == 0)) return res;
		char[] ch = new char[s.length()];
		if (oddCount == 1) {
			char midChar = oddSet.iterator().next();
			ch[ch.length / 2] = midChar;
			map.put(midChar, map.get(midChar) - 1);
			if (map.get(midChar) == 0) map.remove(midChar);
		}

		dfs(res, 0, s.length() - 1, map, ch);
		return res;
	}

	private void dfs(List<String> res, int l, int r, Map<Character, Integer> map, char[] chs) {
		if (l >= r) {
			res.add(new String(chs));
			return;
		}
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 0) continue;
			chs[l] = entry.getKey();
			chs[r] = entry.getKey();
			entry.setValue(entry.getValue() - 2);
			dfs(res, l + 1, r - 1, map, chs);
			entry.setValue(entry.getValue() + 2);
		}
	}
}
