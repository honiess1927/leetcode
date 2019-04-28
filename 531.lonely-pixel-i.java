class Solution {
    public int findLonelyPixel(char[][] picture) {
        int n = picture.length, m = picture[0].length;
        int[] row = new int[n], col = new int[m];
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		if (picture[i][j] == 'B') {
        			row[i]++;
        			col[j]++;
        		}
        	}
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
        	if (row[i] == 1) {
        		for (int j = 0; j < m; j++) {
        			if (picture[i][j] == 'B' && col[j] == 1) res++;
        		} 
        	}
        }
        return res;
    }
}
