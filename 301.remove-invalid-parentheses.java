class Solution {
	Set<String> res = new HashSet<>();
	int maxLen;
    public List<String> removeInvalidParentheses(String s) {
    	dfs(s.toCharArray(), 0, 0, new StringBuilder());
    	return new LinkedList(res);
    }

    public void dfs(char[] s, int at, int left, StringBuilder sb) {
    	if (left < 0) return;
    	if (sb.length() + s.length - at < maxLen) return;
    	if (at == s.length) {
    		if (left != 0 || sb.length() < maxLen) return;
    		if (sb.length() > maxLen) {
    			res.clear();
    			maxLen = sb.length();
    		}
    		res.add(sb.toString());
    		return;
    	}
    	// No keep this.
    	dfs(s, at + 1, left, sb);
    	sb.append(s[at]);
    	if (s[at] == '(') {
    		dfs(s, at + 1, left + 1, sb);
    	} else if (s[at] == ')') {
    		dfs(s, at + 1, left - 1, sb);
    	} else {
    		dfs(s, at + 1, left, sb);
    	}
    	sb.deleteCharAt(sb.length() - 1);
    }
}
