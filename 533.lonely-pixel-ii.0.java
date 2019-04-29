class Solution {
    public int findBlackPixel(char[][] picture, int N) {
        int n = picture.length, m = picture[0].length;
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
        	str[i] = new String(picture[i]);
        }
        Arrays.sort(str);
        int[] row = new int[n], col = new int[m];
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		if (str[i].charAt(j) == 'B') {
        			row[i]++;
        			col[j]++;
        		}
        	}
        }
        // print(str);
        int res = 0, i = 0;
        while (i + N - 1 < n) {
        	// print(i);
        	if (row[i] == N) {
        		boolean shouldContinue = false;
        		for (int j = 1; j < N; j++) {
        			if (!str[i].equals(str[i + j])) {
        				shouldContinue = true;
        				break;
        			}
        		}
        		if (shouldContinue) {
        			i++;
        			continue;
        		}
        		for (int j = 0; j < m; j++) {
        			if (str[i].charAt(j) == 'B' && col[j] == N) res += N;
        		}
        		// print(res);
        		i += N;
        	} else {
        		i++;
        	}
        }

        return res;
    }

    private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
}
