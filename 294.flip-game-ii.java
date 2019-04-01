class Solution {
	Set<String> set = new HashSet<>();
    public boolean canWin(String s) {
    	if (set.contains(s)) return false;
        for (int i = 0; i < s.length() - 1; i++) {
        	if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
        		String next = s.substring(0, i) + "--" + s.substring(i + 2);
        		if (!canWin(next)) return true;
        	}
        }
        set.add(s);
        return false;
    }
}
