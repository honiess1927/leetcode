class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
        	map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int cnt = 0;
        boolean plusOne = false;
        for (int value : map.values()) {
        	if (value % 2 == 0) cnt += value;
        	else {
        		cnt += value - 1;
        		plusOne = true;
        	}
        }
        return plusOne ? cnt + 1 : cnt;
    }
}
