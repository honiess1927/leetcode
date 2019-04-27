class Solution {
	public boolean checkRecord(String s) {
		char[] ss = s.toCharArray();
		int numA = 0;
		for (int i = 0; i < ss.length; i++) {
			if (ss[i] == 'A') {
				numA++;
				if (numA > 1) return false;
			} else if (ss[i] == 'L' && i > 1 && ss[i - 1] == 'L' && ss[i - 2] == 'L') return false;
		}
		return true;
	}
}
