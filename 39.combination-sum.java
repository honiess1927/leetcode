class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> res = new LinkedList<>();
    	dfs(res, new LinkedList<>(), candidates, target, 0, 0);
    	return res;
    }

    private void dfs(List<List<Integer>> res, LinkedList<Integer> list, int[] nums, int target, int curSum, int index) {
    	if (curSum == target) {
    		res.add(copyList(list));
    		return;
    	}
    	if (curSum > target) return;
    	for (int i = index; i < nums.length; i++) {
    		list.add(nums[i]);
    		dfs(res, list, nums, target, curSum + nums[i], i);
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
