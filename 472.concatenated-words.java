class Solution {
	private class Node {
		String word;
		Node[] succ;
		Node() {
			succ = new Node[26];
		}
		Node getSuccNode(char ch) {
			return succ[ch - 'a'];
		}
		Node getOrCreateNode(char ch) {
			if (getSuccNode(ch) == null) succ[ch - 'a'] = new Node();
			return getSuccNode(ch);
		}
	}

	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		Node root = new Node();
		for (String word : words) {
			Node cur = root;
			for (char ch : word.toCharArray()) {
				cur = cur.getOrCreateNode(ch);
			}
			cur.word = word;
		}
		List<String> res = new LinkedList<>();
		for (String word : words) {
			if (word.isEmpty()) continue;
			helper(res, word, 0, root, root);
		}
		return res;
	}

	private boolean helper(List<String> res, String word, int p, Node root, Node baseRoot) {
		if (root == null) return false;
		if (p == word.length()) {
			if (root.word != null && !word.equals(root.word)) {
				res.add(word);
				return true;
			}
			return false;
		}

		if (root.word != null) {
			if (helper(res, word, p + 1, baseRoot.getSuccNode(word.charAt(p)), baseRoot)) return true;
		}
		return helper(res, word, p + 1, root.getSuccNode(word.charAt(p)), baseRoot);
	}
}
