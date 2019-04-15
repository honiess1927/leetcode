class Solution {
	public int wordsTyping(String[] sentence, int rows, int cols) {
		int[] f = new int[rows + 1];
		int rowUse = 1, colLeft = cols + 1, times = 0;
		while (colLeft - 1 >= sentence[0].length()) {
			for (String sent : sentence) {
				if (colLeft - 1 >= sent.length()) colLeft -= (sent.length() + 1);
				else {
					rowUse++;
					colLeft = (cols - sent.length());
				}
			}
			if (rowUse > rows) {
				return times;
			}
			f[rowUse] = ++times;
		}
		for (int i = 1; i < rowUse; i++) {
			f[i] = Math.max(f[i], f[i - 1]);
		}
		// System.out.println(rowUse + " " + Arrays.toString(f));
		return rows / rowUse * f[rowUse] + f[rows % rowUse];
	}
}
