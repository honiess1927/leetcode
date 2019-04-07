class Solution {
	private static final int MOD = 1000000007;

	public int countPalindromicSubsequences(String S) {
		// System.out.println(Math.floorMod(Integer.MAX_VALUE + 1, MOD));
		// System.out.println(Integer.MAX_VALUE % MOD + 1);
		int[][] f = new int[S.length()][S.length()];
		for (int i = 0; i < f.length; i++) f[i][i] = 1;
			for (int len = 1; len < S.length(); len++) {
				for (int l = 0; l + len < S.length(); l++) {
					int r = l + len;
					if (S.charAt(l) == S.charAt(r)) {
						int lx = l + 1, rx = r - 1;
						while (S.charAt(lx) != S.charAt(l) && lx <= rx) lx++;
						while (S.charAt(rx) != S.charAt(r)) rx--;
						if (lx > rx) {
						//No same chararacter as s.charAt(l) within (l, r);
						//2 is two new subsequence, say s.charAt(l) = 'a'
						// the two new subs are "aa" and "a"
							f[l][r] = 2 * f[l + 1][r - 1] + 2;
						} else if (lx == rx) {
						// Only one 'a' within (l, r)
						// Only one new subsequence can be add ('aa');
						// because "a" already exists.
							f[l][r] = 2 * f[l + 1][r - 1] + 1;
						} else {
						// More than one 'a' within (l, r)
						// "a" && "aa" already exists, no need to add new
						// plus all subs within (lx, rx) should not be counted twice because they're already surrounded by two 'a's
							f[l][r] = 2 * f[l + 1][r - 1] - f[lx + 1][rx - 1];
						}
					} else {
						f[l][r] = f[l + 1][r] + f[l][r - 1] - f[l + 1][r - 1];
					}
					// Why floorMod here:
					// Say for: f[l][r] = f[l + 1][r] + f[l][r - 1] - f[l + 1][r - 1];
					// if f[l+1][r] = (MOD + 1)% MOD = 1
					// f[l][r-1] = (MOD + 2) % MOD = 2
					// f[l+1][r - 1] = 5;
					// f[l][r] = 1 + 2 - 5 = - 2
					// but in fact f[l][r] should equals to 
					// (MOD + 1 + MOD + 2) - 5 = (2MOD - 2) % MOD = MOD - 2
					// Math.floorMod(-2, MOD) gives the right value: MOD - 2;
					f[l][r] = Math.floorMod(f[l][r], MOD);
				}
			}
			return f[0][S.length() - 1];
		}
	}
