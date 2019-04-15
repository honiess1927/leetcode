class ValidWordAbbr {
	Map<String, Map<Integer, Integer>> map;
	Set<String> set;
	public ValidWordAbbr(String[] dictionary) {
		map = new HashMap<>();
		set = new HashSet<>();
		for (String word : dictionary) {
			if (set.contains(word)) continue;
			set.add(word);
			String key = word.length() <= 2 ? word : "" + word.charAt(0) + word.charAt(word.length() - 1);
			map.putIfAbsent(key, new HashMap<>());
			map.get(key).put(word.length() - 2, map.get(key).getOrDefault(word.length() - 2, 0) + 1);
		}
	}

	public boolean isUnique(String word) {
		String key = word.length() <= 2 ? word : "" + word.charAt(0) + word.charAt(word.length() - 1);
		if (set.contains(word)) return map.get(key).get(word.length() - 2) == 1;
		return !map.containsKey(key) || !map.get(key).containsKey(word.length() - 2);
	}
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
