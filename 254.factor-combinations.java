class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new LinkedList<>();
        if (n == 1) return res;
        dfs(res, new LinkedList<>(), n, 2);
        return res;
    }

    private void dfs(List<List<Integer>> res, LinkedList<Integer> list, int n, int index) {
    	if (n == 1) {
    		// Error out the reslut [n]
    		if (list.size() > 1) res.add(new ArrayList(list));
    		return;
    	}
    	for (int i = index; i <= n; i++) {
    		if (n % i == 0) {
    			list.add(i);
    			dfs(res, list, n / i, i);
    			list.removeLast();
    		}
    	}
    }
}
