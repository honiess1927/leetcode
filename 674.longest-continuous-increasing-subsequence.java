class Solution {
    public int findLengthOfLCIS(int[] nums) {
    	if (nums.length == 0) return 0;
    	int max = 1;
    	int[] f = new int[nums.length];
    	f[0] = 1;
    	for (int i = 1; i < nums.length; i++) {
    		if (nums[i] > nums[i - 1]) {
    			f[i] = f[i-1] + 1;
    		} else f[i] = 1;
    		max = Math.max(max, f[i]);
    	}
    	return max;
    }
}
