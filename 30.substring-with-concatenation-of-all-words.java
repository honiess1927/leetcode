class Solution {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new LinkedList<>();
		if (s.isEmpty() || words.length == 0) return res;
		Map<String, Integer> wordCount = new HashMap<>();
		for (String word : words) {
			wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
		}
		int len = words[0].length();
		for (int k = 0; k < len; k++) {
			int start = k, end = start;
			Map<String, Integer> map = copyMap(wordCount);
			while (end + len <= s.length()) {
				String next = s.substring(end, end + len);
				if (map.containsKey(next)) {
					map.put(next, map.get(next) - 1);
					if (map.get(next) == 0) map.remove(next);
					if (map.isEmpty()) {
						res.add(start);
						addToMap(s, start, len, map);
						start += len;
					}
					end += len;
				} else {
					addToMap(s, start, len, map);
					start += len;
				}
			}
		}
		return res;
	}

	private void addToMap(String s, int start, int len, Map<String, Integer> map) {
		String toAdd = s.substring(start, start + len);
		map.put(toAdd, map.getOrDefault(toAdd, 0) + 1);
	}

	private Map<String, Integer> copyMap(Map<String, Integer> map) {
		Map<String, Integer> newMap = new HashMap<>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			newMap.put(entry.getKey(), entry.getValue());
		}
		return newMap;
	}
}
