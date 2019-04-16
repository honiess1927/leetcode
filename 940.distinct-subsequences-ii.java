class Solution {
	public int distinctSubseqII(String s) {
    	// s should have 2^s.length() - 1 non-enpty subsequence
    	// similar to 730.
		int MOD = 1000000000 + 7;
		Map<Character, Integer> prevIndex = new HashMap<>();
		prevIndex.put(s.charAt(0), 1);
		int sum = 1;
		for (int i = 1; i < s.length(); i++) {
			char ch = s.charAt(i);
			int cur = sum + 1;
			cur = Math.floorMod(cur - prevIndex.getOrDefault(ch, 0), MOD);
			prevIndex.put(ch, sum + 1);
			sum = (sum + cur) % MOD;
		}
		return sum;
	}
}
