class Solution {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new LinkedList<>();
		dfs(res, new LinkedList<>(), k, n, 1);
		return res;
	}

	public void dfs(List<List<Integer>> res, LinkedList<Integer> list, int k, int n, int next) {
		if (list.size() == k) {
			res.add(copyList(list));
			return;
		}
		for (int i = next; i <= n; i++) {
			list.add(i);
			dfs(res, list, k, n, i + 1);
			list.removeLast();
		}
	}

	private List<Integer> copyList(List<Integer> list) {
		List<Integer> newList = new LinkedList<>();
		for (int num : list) {
			newList.add(num);
		}
		return newList;
	}
}
