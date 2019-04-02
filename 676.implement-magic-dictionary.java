class MagicDictionary {

	private class Node{
		boolean end;
		Node[] succ;
		Node() {
			end = false;
			succ = new Node[26];
		}
	}
	private Node root;

	/** Initialize your data structure here. */
	public MagicDictionary() {
		root = new Node();
	}

	/** Build a dictionary through a list of words */
	public void buildDict(String[] dict) {
		for (String word : dict) {
			Node cur = root;
			for (char ch : word.toCharArray()) {
				int i = ch - 'a';
				if (cur.succ[i] == null) cur.succ[i] = new Node();
				cur = cur.succ[i];
			}
			cur.end = true;
		}
	}

	/** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
	public boolean search(String word) {
		return helper(word, true, 0, root);
	}

	private boolean helper(String word, boolean canChange, int index, Node root) {
		if (root == null) return false;
		if (index == word.length()) {
			return !canChange && root.end;
		}  
		if (canChange) {
			//Change
			for (int i = 0; i < 26; i++) {
				if (helper(word, word.charAt(index) == 'a' + i, index + 1, root.succ[i])) return true;
			}
			return false;
		} else {
			return helper(word, canChange, index + 1, root.succ[word.charAt(index) - 'a']);
		}
	}
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
