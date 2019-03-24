class Solution {
	public List<Integer> lexicalOrder(int n) {
		List<Integer> res = new LinkedList<>();
		for (int i = 1; i <= 9; i++) {
			dfs(i, n, res);
		}
		return res;
	}

	public void dfs(int cur, int n, List<Integer> res) {
		if (cur > n) return;
		res.add(cur);
		cur = cur * 10;
		for (int i = 0; i <= 9; i++) {
			dfs(cur + i, n, res);
		}
	}
}
