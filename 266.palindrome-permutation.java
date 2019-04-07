class Solution {
	public boolean canPermutePalindrome(String s) {

		// Solution 1: use a map to store all values;
		// Map<Character, Integer> map = new HashMap<>();
		// for (char ch : s.toCharArray()) 
		// 	map.put(ch, map.getOrDefault(ch, 0) + 1);
		// boolean flag = s.length() % 2 == 1;
		// for (int value : map.values()) {
		// 	if (value2 % 2 == 1) {
		// 		if (!flag) return false;
		// 		else flag = false;
		// 	}
		// }
		// return true;

		// Solution 2: no second time traverse.
		int oddCount = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			if (map.get(ch) % 2 == 1) oddCount++;
			else oddCount--;
		}
		return s.length() % 2 == 1 ? oddCount == 1 : oddCount == 0;
	}
}
