class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = m == 0 ? 0 : heightMap[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> heightMap[a[0]][a[1]] - heightMap[b[0]][b[1]]);
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    visited[i][j] = true;
                    pq.offer(new int[]{i, j});
                }
            }
        }

        final int[][] POS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int res = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1];
            for (int[] p : POS) {
                int xx = x + p[0], yy = y + p[1];
                if (xx < 0 || yy < 0 || xx >= m || yy >= n || visited[xx][yy]) continue;
                if (heightMap[xx][yy] < heightMap[x][y]) {
                    res += heightMap[x][y] - heightMap[xx][yy];
                    heightMap[xx][yy] = heightMap[x][y];
                    // print(xx, yy, ":", res);
                }
                pq.offer(new int[]{xx, yy});
                visited[xx][yy] = true;
            }
        }

        return res;
    }

    private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
}
