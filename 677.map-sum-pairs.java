class MapSum {

	private class Node {
		Node[] nodes;
		int val;
		Node(int val) {
			nodes = new Node[26];
			this.val = val;
		}
	}
	Node root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node(0);
    }
    
    public void insert(String key, int val) {
    	Node cur = root;
        for (char ch : key.toCharArray()) {
        	if (cur.nodes[ch - 'a'] == null) cur.nodes[ch - 'a'] = new Node(0);
        	cur = cur.nodes[ch - 'a']; 
        }
        cur.val = val;
    }
    
    public int sum(String prefix) {
        Node cur = root;
        int sum = 0;
        for (char ch : prefix.toCharArray()) {
        	if (cur == null) break;
        	cur = cur.nodes[ch - 'a'];
        }
        return helper(cur);
    }

    private int helper(Node node) {
    	if (node == null) return 0;
    	int res = node.val;
    	for (int i = 0; i < 26; i++) {
    		res += helper(node.nodes[i]);
    	}
    	return res;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
