class Solution {
    public int jump(int[] nums) {
    	if (nums.length == 1) return 0;
    	int max = 0;
    	int[] f = new int[nums.length];
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] + i > max) {
    			int p = Math.min(nums[i] + i, nums.length - 1);
    			if (p == nums.length - 1) return f[i] + 1;
    			while (p > 0 && f[p] == 0) {
    				f[p] = f[i] + 1;
    				p--;
    			}
    		}
    	}
    	return f[nums.length - 1];
    }
}
