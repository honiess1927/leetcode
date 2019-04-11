class Solution {
	public boolean isConvex(List<List<Integer>> points) {
        // Corss product all positive or all negative.
		if (points.size() < 3) return false;
		points.add(points.get(0));
		points.add(points.get(1));
		boolean isPositive = false, isNegative = false;
		for (int i = 2; i < points.size(); i++) {
			int[] a = getVector(points.get(i - 1), points.get(i));
			int[] b = getVector(points.get(i - 1), points.get(i - 2));
			int cp = crossProduct(a, b);
			if (cp > 0) isPositive = true;
			else if (cp < 0) isNegative = true;
			// System.out.println(cp);
			if (isNegative && isPositive) return false;
		}
		return true;
	}

	private int[] getVector(List<Integer> a, List<Integer> b) {
		int[] vector = new int[2];
		vector[0] = b.get(0) - a.get(0);
		vector[1] = b.get(1) - a.get(1);
		return vector;
	}

	//计算向量叉积
	private int crossProduct(int[] a, int[] b) {
		return a[0] * b[1] - b[0] * a[1];
	}
}
