class Solution {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new LinkedList<>();
		Arrays.sort(nums);
		dfs(res, new LinkedList<>(), nums, new boolean[nums.length]);
		return new LinkedList<>(res);
	}

	private void dfs(List<List<Integer>> res, LinkedList<Integer> list, int[] nums, boolean[] visited) {
		if (list.size() == nums.length) {
			res.add(new LinkedList(list));
			return;
		}
		int i = 0;
		while (i < nums.length) {
			if (!visited[i]) {
				list.add(nums[i]);
				visited[i] = true;
				dfs(res, list, nums, visited);
				visited[i] = false;
				list.removeLast();
				i++;
				while (i < nums.length && nums[i] == nums[i - 1]) i++;
			} else i++;
		}
	}

}
