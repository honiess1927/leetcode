class Solution {
	public String decodeAtIndex(String S, int K) {
		long l = 0, k = K;
		int i = 0;
		// Keep calculating until l > k or reach the end of string
		while (l <= k && i < S.length()) {
			char ch = S.charAt(i);
			if (ch < 'a') {
				l *= (int)(ch - '0');
			} else {
				l++;
			}
			i++;
			// print(i, ":", l);
		}
		i--;
		// Decode
		// k == 0 happends when l = m * someStirng && k = n * someString
		// e.g. S = "ab24", k = 6
		// in this case we should return the last char which is 'b'
		while (k != l && k != 0) {
			char ch = S.charAt(i);
			if (ch < 'a') {
				l /= (int)(ch - '0');
				k = k % l;
			} else l--;
			i--;
			// print(i, ":", k, l);
		}
		while (S.charAt(i) < 'a') i--;
		return S.substring(i, i + 1);
	}
	private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
}



// abc35 3*3*5=45
// 45

// l = 15
// k = 45 % 15 = 0;

// hahahaha (5)

// haha (1)

// ha (1)

