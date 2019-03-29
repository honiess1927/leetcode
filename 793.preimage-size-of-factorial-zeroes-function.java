class Solution {
	public int preimageSizeFZF(int K) {
		int original = -1;
		int[] counter = new int[100];
		while (original < K) {
			// System.out.print(original + "  ");
			original += 6;
			int ind = 0;
			counter[0]++;
			while (counter[ind] == 5 && original < K) {
				// System.out.print(original + "  ");
				original++;
				counter[ind] = 0;
				counter[++ind]++;
			}
		}
        // System.out.println(original);
		return original == K ? 0 : 5;
	}
}

//124 0000000000000000000000000000
//125 0000000000000000000000000000000
