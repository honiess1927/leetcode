class Solution {
	public int findNumberOfLIS(int[] nums) {
		if (nums.length == 0) return 0;
		int[] f = new int[nums.length], lens = new int[nums.length];
		int max = 1, count = 0;
		for (int i = 0; i < f.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					if (f[j] + 1 >= f[i]) {
						if (f[j] + 1 == f[i]) lens[i] += lens[j];
						else {
							lens[i] = lens[j];
							f[i] = f[j] + 1;
						}
					}
				}
			}
			if (f[i] == 0) {
				f[i] = 1;
				lens[i] = 1;
			}
			if (f[i] > max) {
				max = f[i];
				count = lens[i];
			} else if (f[i] == max) {
				count += lens[i];
			}
		}
		// System.out.println(Arrays.toString(f));
		// System.out.println(Arrays.toString(lens));

		return count;
	}
}
