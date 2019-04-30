class Solution {
	public boolean isReflected(int[][] points) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		Set<Long> set = new HashSet<>();
		for (int[] p : points) {
			min = Math.min(min, p[0]);
			max = Math.max(max, p[0]);
			set.add((long)p[0] << 32 + p[1]);
		}
		// print(set);
		long sum = min + max;
		// print(sum);
		for (int[] p : points) {
			// print((long)(sum - p[0]) << 32 + p[1]);
			if (!set.contains((long)(sum - p[0]) << 32 + p[1]))
				return false;
		}
		return true;
	}
	private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
}
