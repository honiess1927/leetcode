class Solution {
	// Lagrange's Four-Square Theorem
	// http://mathworld.wolfram.com/LagrangesFour-SquareTheorem.html
	// Any positive integer can be written as the sum of at most four squares.
	// 4 may be reduced to 3 except for numbers of the form 4^n(8k+7)
	// public int numSquares(int n) {
	// 	if (isSquare(n)) return 1;
	// 	int tmp = n;
	// 	while (tmp % 4 == 0) tmp = tmp / 4;
	// 	if (tmp % 8 == 7) return 4;
	// 	for (int i = 1; i <= (int) Math.sqrt(n); i++) {
	// 		if (isSquare(n - i * i)) return 2;
	// 	}
	// 	return 3;
	// 
	static List<Integer> f;
	static {
		f = new ArrayList<>();
		f.add(0);
	}
	public int numSquares(int n) {
		for (int i = f.size(); i <= n; i++) {
			if (isSquare(i)) {
				f.add(1);
				continue;
			}
			int tmp = Integer.MAX_VALUE;
			for (int j = 1; j <= (int)Math.sqrt(i); j++) {
				tmp = Math.min(f.get(i - j * j) + 1, tmp);
				// print(i, j, tmp);
			}
			// print("       ");
			f.add(tmp);
		}
		print(f);
		return f.get(n);
	}
	private boolean isSquare(int n) {
		int x = (int)Math.sqrt(n);
		return x * x == n;
	}
	private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
}
