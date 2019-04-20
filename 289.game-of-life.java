class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length, m = n == 0? 0 : board[0].length;
        final int[][] POS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		int cntLive = 0;
        		for (int[] p : POS) {
        			int x = i + p[0], y = j + p[1];
        			if (x >= 0 && y >= 0 && x < n && y < m) {
        				cntLive += board[x][y] % 2;
        			}
        		}
        		if (board[i][j] == 1) {
        			if (cntLive != 2 && cntLive != 3) board[i][j] = 3;
        		} else {
        			if (cntLive == 3) board[i][j] = 2;
        		}
        	}
        }

        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		if (board[i][j] == 3) board[i][j] = 0;
        		else if (board[i][j] == 2) board[i][j] = 1;
        	}
        }
    }
}
