class Solution {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new LinkedList<>();
		dfs(res, new LinkedList<>(), k, n, 1);
		return res;
	}

	private void dfs(List<List<Integer>> res, LinkedList<Integer> list, int k, int n, int index) { 
		if (k == 0 || n <= 0) {
			if (k == 0 && n == 0) res.add(new LinkedList(list));
			return;
		}
		for (int i = index; i <= 9; i++) {
			list.add(i);
			dfs(res, list, k - 1, n - i, i + 1);
			list.removeLast();
		}
	}
}