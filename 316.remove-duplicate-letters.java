class Solution {
	public String removeDuplicateLetters(String s) {
		char[] ss = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		Set<Character> set = new HashSet<>();
		for (char ch : ss) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
        // System.out.println(map);
		Stack<Character> stack = new Stack<>();
		for (char ch : ss) {
			if (set.contains(ch)) {
				map.put(ch, map.get(ch) - 1);
				continue;
			}
			while (!stack.isEmpty() && stack.peek() > ch && map.get(stack.peek()) > 1) {
				char tmp = stack.pop();
				map.put(tmp, map.get(tmp) - 1);
				set.remove(tmp);
			}
			stack.push(ch);
			set.add(ch);
		}
		List<Character> list = new LinkedList<>(stack);
        // System.out.println(list);
		StringBuilder sb = new StringBuilder();
		for (char ch : list) {
			sb.append(ch);
		}
		return sb.toString();

	}
}
