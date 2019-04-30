class Solution {
	public List<List<Integer>> permuteUnique(int[] nums) {
		Set<List<Integer>> res = new HashSet<>();
		dfs(res, new LinkedList<>(), nums, new boolean[nums.length]);
		return new LinkedList<>(res);
	}

	private void dfs(Set<List<Integer>> res, LinkedList<Integer> list, int[] nums, boolean[] visited) {
		if (list.size() == nums.length) {
			res.add(new LinkedList(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				list.add(nums[i]);
				visited[i] = true;
				dfs(res, list, nums, visited);
				visited[i] = false;
				list.removeLast();
			}
		}
	}

}
