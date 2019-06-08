class Solution {
    final int[][] POS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maxKilledEnemies(char[][] grid) {
        int n = grid.length, m = n == 0 ? 0 : grid[0].length, res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '0') {
                    int cnt = 0;
                    for (int[] p : POS) {
                        int x = i + p[0], y = j + p[1];
                        while (x >= 0 && y >= 0 && x < n && y < m && grid[x][y] != 'W') {
                            if (grid[x][y] == 'E') cnt++;
                            x += p[0];
                            y += p[1];
                        }
                    }
                    res = Math.max(res, cnt);
                }
            }
        }
        return res;
    }

    // Solution 1: light house way.
    // public int maxKilledEnemies(char[][] grid) {
    //     int n = grid.length, m = n == 0? 0 : grid[0].length;
    //     int[][] res = new int[n][m];
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < m; j++) {
    //             if (grid[i][j] == 'E') {
    //                 for (int[] p : POS) {
    //                     int x = i + p[0], y = j + p[1];
    //                     while (x >= 0 && y >= 0 && x < n && y < m && grid[x][y] != 'W') {
    //                         res[x][y]++;
    //                         x += p[0];
    //                         y += p[1];
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //
    //     int max = 0;
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < m; j++) {
    //             if (grid[i][j] == '0') max = Math.max(max, res[i][j]);
    //         }
    //     }
    //
    //     return max;
    // }
}
