class Trie {
    private class Node {
        boolean end;
        Node[] succ;
        Node() {
            end = false;
            succ = new Node[26];
        }
        Node getSucc(char ch) {
            return succ[ch - 'a'];
        }
        Node getOrNewSucc(char ch) {
            if (getSucc(ch) == null) succ[ch - 'a'] = new Node();
            return getSucc(ch);
        }
    }

    private Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;
        for (char ch : word.toCharArray()) cur = cur.getOrNewSucc(ch);
        cur.end = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = getNode(word);
        return node != null && node.end;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }

    private Node getNode(String word) {
        Node cur = root;
        for (char ch : word.toCharArray()) {
            cur = cur.getSucc(ch);
            if (cur == null) return null;
        }
        return cur;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
