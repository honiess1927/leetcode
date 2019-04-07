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
		int l, r;
		if (oddCount == 1) {
			char midChar = oddSet.iterator().next();
			ch[ch.length / 2] = midChar;
			map.put(midChar, map.get(midChar) - 1);
			if (map.get(midChar) == 0) map.remove(midChar);
			l = ch.length / 2 - 1;
			r = l + 2;
		} else {
			r = ch.length / 2;
			l = r - 1;
		}

		List<Map.Entry<Character, Integer>> list = new ArrayList<>();
		list.addAll(map.entrySet());

		dfs(res, l, r, list, ch);
		return res;
	}

	private void dfs(List<String> res, int l, int r, List<Map.Entry<Character, Integer>> list, char[] chs) {
		if (l < 0) {
			res.add(new String(chs));
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			Map.Entry<Character, Integer> entry = list.get(i);
			if (entry.getValue() == 0) continue;
			chs[l] = entry.getKey();
			chs[r] = entry.getKey();
			entry.setValue(entry.getValue() - 2);
			if (entry.getValue() == 0) 
				dfs(res, l - 1, r + 1, list, chs);
			else 
				dfs(res, l - 1, r + 1, list, chs);
			entry.setValue(entry.getValue() + 2);
		}
	}
}
