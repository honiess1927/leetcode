class Solution {
	public int jump(int[] nums) {
		int max = 0;
		int[] f = new int[nums.length];
		for (int i = 0; i < nums.length && max < nums.length - 1; i++) {
			if (nums[i] + i > max) {
				int p = Math.min(nums[i] + i, nums.length - 1);
				while (p > 0 && f[p] == 0) {
					f[p] = f[i] + 1;
					p--;
				}
				max = nums[i] + i;
			}
		}
		return f[nums.length - 1];
	}
}
