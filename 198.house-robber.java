class Solution {
    public int rob(int[] nums) {
        int[] f = new int[3];
        for (int i = 0; i < nums.length; i++) {
        	f[(i + 2) % 3] = Math.max(nums[i] + f[i % 3], f[(i + 1) % 3]);
        }
        return f[(nums.length + 1) % 3];
    }
}
