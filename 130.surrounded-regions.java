class Solution {
    public void solve(char[][] board) {
    	if (board.length == 0) return;
    	for (int i = 0; i < board.length; i++) {
    		dfs(board, i, 0, 'N');
    		dfs(board, i, board[0].length - 1, 'N');
    	}
    	for (int j = 0; j < board[0].length - 1; j++) {
    		dfs(board, 0, j, 'N');
    		dfs(board, board.length - 1, j, 'N');
    	}
        for (int i = 1; i < board.length - 1; i++) {
        	for (int j = 1; j < board[0].length - 1; j++) {
        		dfs(board, i, j, 'Y');
        	}
        }

        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[0].length; j++) {
        		if (board[i][j] == 'N') board[i][j] = 'O';
        		else if (board[i][j] == 'Y') board[i][j] = 'X';
        	}
        }
    }

    private void dfs(char[][] board, int i, int j, char mark) {
    	if (board[i][j] != 'O') return;
    	board[i][j] = mark;
    	if (i > 0) dfs(board, i-1, j, mark);
    	if (j > 0) dfs(board, i, j-1, mark);
    	if (i < board.length - 1) dfs(board, i+1, j, mark);
    	if (j < board[0].length - 1) dfs(board, i, j+1, mark);
    }
}
