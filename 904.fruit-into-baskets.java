class Solution {
	public int totalFruit(int[] tree) {
		int fruit1 = -1, fruit2 = -1;
		int start1 = -1, start2 = -1;
		int res = 0, prev = 0;
		for (int i = 0; i < tree.length; i++) {
			if (fruit1 == -1) {
				fruit1 = tree[i];
				start1 = i;
			} else if (fruit2 == -1 && tree[i] != fruit1) {
				fruit2 = tree[i];
				start2 = i;
			} 
			if (fruit1 != tree[i] && fruit2 != tree[i]) {
				fruit1 = tree[prev];
				start1 = prev;
				fruit2 = tree[i];
				start2 = i;
			}
			if (tree[i] != tree[prev]) prev = i;
			res = Math.max(res, i - start1 + 1);
			// System.out.println(i + " " + res + " " + fruit1 + ": " + start1 + " " + fruit2 + ":" + start2);
		}
		if (start1 != -1) res = Math.max(res, tree.length - start1);
		return res;
	}
}
