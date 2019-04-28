class Solution {
	// private class Node{
	// 	Node[] next;
	// 	boolean isEnd;
	// 	Node() {
	// 		next = new Node[26];
	// 		isEnd = false;
	// 	}
	// 	Node getNext(char ch) {
	// 		return next[ch - 'a'];
	// 	}
	// 	Node getOrCreateNext(char ch) {
	// 		if (getNext(ch) == null) {
	// 			next[ch - 'a'] = new Node();
	// 		}
	// 		return getNext(ch);
	// 	}
	// 	void end() {
	// 		isEnd = true;
	// 	}
	// }
	// Map<String, Boolean> map = new HashMap<>();
 //    public boolean wordBreak(String s, List<String> wordDict) {
 //    	Node root = new Node();
 //        for (String word : wordDict) {
 //        	Node cur = root;
 //        	for (char ch : word.toCharArray()) {
 //        		cur = cur.getOrCreateNext(ch);
 //        	}
 //        	cur.end();
 //        }
 //        return dfs(root, root, s);
 //    }

 //    private boolean dfs(Node realRoot, Node root, String s) {
 //    	print(s);
 //    	if (root == null) return false;
 //    	if (s.isEmpty()) return root.isEnd;
 //    	String next = s.substring(1);
 //    	if (map.containsKey(next)) return map.get(next);
 //    	boolean res = false;
 //    	if (dfs(realRoot, root.getNext(s.charAt(0)), next)) return true;
 //    	if (!res && root.isEnd && dfs(realRoot, realRoot.getNext(s.charAt(0)), next)) {
 //    		res = true; 
 //    		map.put()
 //    	print(map);
 //    	return res;
 //    }
 //    private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}

	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> set = new HashSet<>();
		for (String word : wordDict) 
			set.add(word);
		boolean[] f = new boolean[s.length() + 1];
		f[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (f[j] && set.contains(s.substring(j, i))) {
					f[i] = true;
				} 
			}
		}
		return f[s.length()];
	}
}
