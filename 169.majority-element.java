class Solution {
    public int majorityElement(int[] nums) {
        int res = nums[0], count = 0;
        for (int num : nums) {
        	if (num == res) count++;
        	else {
        		if (count == 0) {
        			res = num;
        			count = 1;
        		}
        		count--;
        	}
        }
        return res;
    }
}
