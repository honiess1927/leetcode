class Solution {
	public int totalFruit(int[] tree) {
		int s1 = -1, s2 = -1;
		int res = 0, prev = 0;
		for (int i = 0; i < tree.length; i++) {
			if (s1 == -1) {
				s1 = i;
			} else if (s2 == -1 && tree[i] != tree[s1]) {
				s2 = i;
			} 
			if (tree[s1] != tree[i] && tree[s2] != tree[i]) {
				s1 = prev;
				s2 = i;
			}
			if (tree[i] != tree[prev]) prev = i;
			res = Math.max(res, i - s1 + 1);
			// System.out.println(i + " " + res + " " + tree[s1] + ": " + s1 + " " + tree[s2] + ":" + s2);
		}
		if (s1 != -1) res = Math.max(res, tree.length - s1);
		return res;
	}
}
