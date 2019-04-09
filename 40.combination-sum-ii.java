class Solution {
	Map<Integer, Integer> map = new HashMap<>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		for (int num : candidates) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		List<List<Integer>> res = new LinkedList<>();
		dfs(res, new LinkedList<>(), target, 0, 0);
		return res;
	}

	private void dfs(List<List<Integer>> res, LinkedList<Integer> list, int target, int curSum, int prev) {
		if (curSum == target) {
			res.add(copyList(list));
			return;
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getKey() < prev || entry.getValue() == 0 || curSum + entry.getKey() > target) continue;
			list.add(entry.getKey());
			entry.setValue(entry.getValue() - 1);
			dfs(res, list, target, curSum + entry.getKey(), entry.getKey());
			list.removeLast();
			entry.setValue(entry.getValue() + 1);
		}
	}

	private List<Integer> copyList(LinkedList<Integer> list) {
		List<Integer> newList = new LinkedList<>();
		for (int num : list) {
			newList.add(num);
		}
		return newList;
	}
}
