class Solution {
	public int combinationSum4(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		dfs(nums, target, map);
		// System.out.println(map);
		return map.get(target);
	}

	public int dfs(int[] nums, int target, Map<Integer, Integer> map) {
		if (map.containsKey(target)) return map.get(target);
		if (target < 0) return 0;
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			res += dfs(nums, target - nums[i], map);
		}
		map.put(target, res);
		return res;
	}
}
