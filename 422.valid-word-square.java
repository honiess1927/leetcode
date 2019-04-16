class Solution {
	public boolean validWordSquare(List<String> words) {
		int maxLen = 0;
		for (String word : words) 
			maxLen = Math.max(word.length(), maxLen);
		if (maxLen != words.size()) return false;
		char[][] chs = new char[words.size()][0];
		for (int i = 0; i < words.size(); i++) {
			chs[i] = Arrays.copyOf(words.get(i).toCharArray(), maxLen);
		}
		for (int i = 0; i < chs.length; i++) {
			for (int j = 0; j < i; j++) {
				if (chs[i][j] != chs[j][i]) return false;
			}
		}
		return true;
	}
}
