class Solution {
	public boolean canPermutePalindrome(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : s.toCharArray()) 
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		boolean flag = s.length() % 2 == 1;
		for (int value : map.values()) {
			if (value % 2 == 1) {
				if (!flag) return false;
				else flag = false;
			}
		}
		return true;
	}
}
