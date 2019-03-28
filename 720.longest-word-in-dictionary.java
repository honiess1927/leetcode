class Solution {
	private static class Node {
		String word;
		Map<Character, Node> next;
		Node() {
			next = new HashMap<>();
		}
	}
	String res = "";
	public String longestWord(String[] words) {
		Node root = new Node();
		root.word = "z";
		for (String word : words) {
			Node cur = root;
			for (char ch : word.toCharArray()) {
				cur.next.putIfAbsent(ch, new Node());
				cur = cur.next.get(ch);
			}
			cur.word = word;
		}
		dfs(root);
		return res;
	}

	private void dfs(Node node) {
		if (node.word == null) return;
		if (res.length() < node.word.length()) res = node.word;
		else if (res.length() == node.word.length() && res.compareTo(node.word) > 0) res = node.word;
		for (Node next : node.next.values()) dfs(next);
	}
}
