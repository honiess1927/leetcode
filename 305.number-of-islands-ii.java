class Solution {
	final int[][] POS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] uf = new int[m * n];
        int num = 0;
        List<Integer> res = new LinkedList<>();
        for (int[] pos : positions) {
        	int x = pos[0], y = pos[1];
        	if (uf[x * n + y] != 0) {
        		res.add(num);
        		continue;
        	}
        	num++;
        	int val = x * n + y + 1;
        	uf[x * n + y] = val;
        	for (int[] p : POS) {
        		int xx = x + p[0], yy = y + p[1];
        		// print(xx, yy);
        		if (xx >= 0 && xx < m && yy >= 0 && yy < n && uf[xx * n + yy] != 0) {
        			int tmp = xx * n + yy;
        			// here, shift by one, meaning that default root of point 0 is 1: uf[0] = 1
        			// so that when uf[x] != 0 we know that there's island on position x
        			while (uf[tmp]!= tmp + 1) {
        				uf[tmp] = uf[uf[tmp] - 1];
        				tmp = uf[tmp] - 1;
        			}
        			if (uf[tmp] != val) {
        				uf[tmp] = val;
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
