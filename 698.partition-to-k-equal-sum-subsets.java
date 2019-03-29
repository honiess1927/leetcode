class Solution {
	public boolean canPartitionKSubsets(int[] nums, int k) {
		if (k <= 0 || k > nums.length) return false;
		if (k == 1) return true;
		int sum = 0;
		for (int num : nums) sum += num;
		if (sum % k != 0) return false;
		sum = sum / k;
		return canPartition(nums, new boolean[nums.length], sum, 0, k, 0);
	}

	private boolean canPartition(int[] nums, boolean[] visited, int sum, int cur_sum, int groupLeft, int start) {
		if (groupLeft == 0) return true;
		if (cur_sum > sum) return false;
		if (cur_sum == sum) {
			return canPartition(nums, visited, sum, 0, groupLeft - 1, 0);
		} else {
			for (int i = start; i < nums.length; i++) {
				if (!visited[i]) {
					visited[i] = true;
					if (canPartition(nums, visited, sum, cur_sum + nums[i], groupLeft, i + 1)) return true;
					visited[i] = false;
				}
			}
		}
		return false;
	}
}
