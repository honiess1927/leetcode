class Solution {
    public int pivotIndex(int[] nums) {
    	if (nums.length == 0) return -1;
    	int[] rightsum = new int[nums.length];
    	for (int i = nums.length - 2; i >= 0; i--) {
    		rightsum[i] = nums[i + 1] + rightsum[i + 1];
    	}
    	int sum = 0;
    	for (int i = 0; i < nums.length; i++) {
    		if (sum == rightsum[i]) return i;
    		sum += nums[i];
    	}
    	return -1;
    }
}
