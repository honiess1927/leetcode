class WordDictionary {
	private class Node{
		boolean end;
		Node[] succ;
		Node() {
			end = false;
			succ = new Node[26];
		}
		Node getSuccNode(char ch) {
			return succ[ch - 'a'];
		}
		Node getOrCreateSuccNode(char ch) {
			if (getSuccNode(ch) == null) succ[ch - 'a'] = new Node();
			return getSuccNode(ch);
		}
	}

	Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cur = root;
        for (char ch : word.toCharArray()) {
        	cur = cur.getOrCreateSuccNode(ch);
        }
        cur.end = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(word, 0, root);
    }

    public boolean helper(String word, int p, Node root) {
    	if (root == null) return false;
    	if (p == word.length()) return root.end;
    	if (word.charAt(p) == '.') {
    		for (int i = 0; i < 26; i++) {
    			if (helper(word, p + 1, root.succ[i])) return true;
    		}
    	} else return helper(word, p + 1, root.getSuccNode(word.charAt(p)));
    	return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
