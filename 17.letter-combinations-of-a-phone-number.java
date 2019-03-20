class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
    	if (digits.isEmpty()) return res;
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        bfs(res, map, new StringBuilder(), digits, 0);
        return res;
    }

    private void bfs(List<String> res, Map<Character, List<Character>> map, StringBuilder sb, String digits, int cur) {
    	if (cur == digits.length()) {
    		res.add(sb.toString());
    		return;
    	}
    	for (char ch : map.get(digits.charAt(cur))) {
    		sb.append(ch);
    		bfs(res, map, sb, digits, cur + 1);
    		sb.deleteCharAt(sb.length() - 1);
    	}
    }
}
