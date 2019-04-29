class Solution {
    public int findBlackPixel(char[][] picture, int N) {
    	int n = picture.length, m = picture[0].length;
        List<Set<Integer>> col = new ArrayList<>();
        for (int i = 0; i < m; i++) col.add(new HashSet<>());
        int[] row = new int[n];
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		if (picture[i][j] == 'B') {
        			row[i]++;
        			col.get(j).add(i);
        		}
        	}
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
        	if (row[i] == N) {
        		for (int j = 0; j < m; j++) {
        			if (picture[i][j] == 'B' && col.get(j).size() == N) {
        				boolean flag = false;
        				for (int rowNum : col.get(j)) {
        					if (rowNum != i && !Arrays.equals(picture[i], picture[rowNum])) {
        						flag = true;
        						break;
        					}
        					row[rowNum] = -1;
        				}
        				if (!flag) res += N;
        			}
        		}
        	}
        }
        return res;
    }
}
