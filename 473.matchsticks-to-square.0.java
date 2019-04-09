class Solution {
    public boolean makesquare(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, min = Integer.MAX_VALUE;
        for (int num : nums) {
        	map.put(num, map.getOrDefault(num, 0) + 1);
        	sum += num;
        }
        if (sum % 4 != 0) return false;
        return dfs(map, 4, sum / 4, 0, 0);
    }

    private boolean dfs(Map<Integer, Integer> map, int edges, int target, int curSum, int prev) {
    	if (curSum == target) {
    		edges--;
    		curSum = 0;
    		prev = 0;
    	}
    	if (edges == 0) return true;
    	for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    		if (entry.getKey() >= prev && entry.getValue() > 0 && curSum + entry.getKey() <= target) {
    			entry.setValue(entry.getValue() - 1);
    			if (dfs(map, edges, target, curSum + entry.getKey(), entry.getKey())) return true;
    			entry.setValue(entry.getValue() + 1);
    		}
    	}
    	return false;
    }
}
