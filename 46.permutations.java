class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(res, new LinkedList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void dfs(List<List<Integer>> res, LinkedList<Integer> list, int[] nums, boolean[] visited) {
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
