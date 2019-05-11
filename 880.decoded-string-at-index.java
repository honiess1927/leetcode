class Solution {
	public String decodeAtIndex(String S, int K) {
		long l = 0, k = K;
		int i = 0;
		while (l < k) {
			char ch = S.charAt(i);
			if (ch < 'a') {
				l *= (int)(ch - '0');
			} else {
				l++;
			}
			if (l == k) {
				while (S.charAt(i) < 'a') i--;
				return S.substring(i, i + 1);
			}
			i++;
			// print(i, ":", l);
		}
		i--;
		while (k != 0 && k != l) {
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

