class Solution {
	final int[][] POS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] a = new int[m][n];
        int[] uf = new int[m * n];
        int num = 0;
        List<Integer> res = new LinkedList<>();
        for (int[] pos : positions) {
        	int x = pos[0], y = pos[1];
        	if (a[x][y] != 0) {
        		res.add(num);
        		continue;
        	}
        	a[x][y] = x * n + y + 1;
        	num++;
        	uf[x * n + y] = a[x][y];
        	// print(a);
        	// print(uf);
        	for (int[] p : POS) {
        		int xx = x + p[0], yy = y + p[1];
        		// print(xx, yy);
        		if (xx >= 0 && xx < m && yy >= 0 && yy < n && a[xx][yy] != 0) {
        			int tmp = xx * n + yy;
        			while (uf[tmp]!= tmp + 1) {
        				tmp = uf[tmp] - 1;
        			}
        			if (uf[tmp] != a[x][y]) {
        				uf[tmp] = a[x][y];
        				num--;
        			}
        		}
        	}
        	res.add(num);
        }
        return res;
    }
    private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
}
