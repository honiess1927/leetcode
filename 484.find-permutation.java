class Solution {
	public int[] findPermutation(String s) {
		int[] res = new int[s.length() + 1];
		int index = 0, start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'D') {
				end++;
			} else {
				for (int j = end; j >= start; j--) {
					res[index++] = j + 1;
				}
				start = end + 1;
				end = start;
			}
		}
		for (int j = end; j >= start; j--) {
			res[index++] = j + 1;
		}
		return res;
	}
	private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
}
