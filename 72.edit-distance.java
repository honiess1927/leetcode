class Solution {
    public int minDistance(String word1, String word2) {
        char[] s1 = word1.toCharArray(), s2 = word2.toCharArray();
        int[][] f = new int[s1.length + 1][s2.length + 1];
        for (int i = 0; i <= s1.length; i++) f[i][0] = i;
        for (int i = 0; i <= s2.length; i++) f[0][i] = i;
        for (int i = 0; i < s1.length; i++) {
        	for (int j = 0; j < s2.length; j++) {
        		if (s1[i] == s2[j]) f[i + 1][j + 1] = f[i][j];
        		else f[i + 1][j + 1] = Math.min(Math.min(f[i][j + 1], f[i + 1][j]), f[i][j]) + 1;
        	}
        }
        return f[s1.length][s2.length];
    }
}
