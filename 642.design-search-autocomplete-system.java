  class AutocompleteSystem {

  	private class Node implements Comparable<Node>{
  		int freq;
  		String word;
  		Node[] succ;

  		Node() {
  			succ = new Node[27];  			
  		}

  		Node getSuccNode(char ch) {
  			if (ch == ' ') return succ[26];
  			return succ[ch - 'a'];
  		}

  		Node getSuccNode(int ch) {
  			return succ[ch];
  		}

  		Node getOrCreateSuccNodes(char ch) {
  			if (getSuccNode(ch) == null) {
  				int index = ch == ' ' ? 26 : ch - 'a';
  				succ[index] = new Node();
  			}
  			return getSuccNode(ch);
  		}

  		@Override
  		public int compareTo(Node other) {
  			if (this.freq != other.freq) return this.freq - other.freq;
  			return other.word.compareTo(this.word);
  		}
  	}

  	Node root;
  	Node cur;
  	StringBuilder sb;

  	public AutocompleteSystem(String[] sentences, int[] times) {
  		root = new Node();
  		cur = root;
  		sb = new StringBuilder();
  		for (int i = 0; i < sentences.length; i++) {
  			Node tmp = root;
  			for (char ch : sentences[i].toCharArray()) {
  				tmp = tmp.getOrCreateSuccNodes(ch);
  			}
  			tmp.word = sentences[i];
  			tmp.freq = times[i];
  		}
  	}

  	public List<String> input(char c) {
  		PriorityQueue<Node> pq = new PriorityQueue<>();
  		if (c != '#') {
  			sb.append(c);
  			if (cur.getSuccNode(c) == null) {
  				cur = cur.getOrCreateSuccNodes(c);
  			} else {
  				cur = cur.getSuccNode(c);
  				dfs(cur, pq);
  			}
  		} else {
  			if (cur.word == null) {
  				cur.word = sb.toString();
  			}
  			cur.freq++;
  			cur = root;
  			sb = new StringBuilder();
  		}
  		LinkedList<String> res = new LinkedList<>();
  		while (!pq.isEmpty()) res.addFirst(pq.poll().word);
  		return res;
  	}

  	public void dfs(Node root, PriorityQueue pq) {
  		if (root == null) return;
  		if (root.word != null) {
  			pq.offer(root);
  			if (pq.size() > 3) pq.poll();
  		}
  		for (int i = 0; i < 27; i++) {
  			dfs(root.getSuccNode(i), pq);
  		}
  	}



  }

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
