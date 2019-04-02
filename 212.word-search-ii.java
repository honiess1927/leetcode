class Solution {
	private class Node {
		String word;
		Node[] succNodes;
		Node() {
			succNodes = new Node[26];
		}
		Node getSuccNode(char ch) {
			return succNodes[ch - 'a'];
		}
		Node getOrCreateSuccNode(char ch) {
			if (getSuccNode(ch) == null) succNodes[ch - 'a'] = new Node();
			return getSuccNode(ch);
		}
	}
	int[][] pos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	public List<String> findWords(char[][] board, String[] words) {
		Set<String> res = new HashSet<>();
		if (board.length == 0) return new LinkedList<>(res);
		Node root = new Node();
		for (String word : words) {
			Node cur = root;
			for (char ch : word.toCharArray()) {
				cur = cur.getOrCreateSuccNode(ch);
			}
			cur.word = word;
		}

		for (int i = 0; i < board.length; i++)   
			for (int j = 0; j < board[i].length; j++) {
				dfs(board, i, j, root, res);
			}

		return new LinkedList<>(res);
	}

	private void dfs(char[][] board, int i, int j, Node root, Set<String> res) {
		if (root == null) return;
		if (root.word != null) res.add(root.word);
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '*') return;
		char original = board[i][j];
		board[i][j] = '*';
		for (int k = 0; k < 4; k++) {
			dfs(board, i + pos[k][0], j + pos[k][1], root.getSuccNode(original), res);
		}
		board[i][j] = original;
	}
}
