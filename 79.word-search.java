class Solution {
    int[][] pos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
    	if (word.isEmpty()) return true;
    	if (board.length == 0) return false;
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[0].length; j++) {
        		if (search(board, i, j, word, 0)) return true;
        	}
        }
        return false;
    }

    public boolean search(char[][] board, int i, int j, String word, int p) {
    	if (p == word.length()) return true;
    	if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(p)) return false;
    	char original = board[i][j];
    	board[i][j] = '*';
    	for (int k = 0; k < 4; k++) {
    		if (search(board, i + pos[k][0], j + pos[k][1], word, p + 1)) return true;
    	}
    	board[i][j] = original;
    	return false;
    }
}
