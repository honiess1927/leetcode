class Solution {
    public int splitArray(int[] nums, int m) {
        long sum = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
        	sum += num;
        	max = Math.max(max, num);
        }
        long l = max, r = sum;
        while (l < r) {
        	long mid = l + (r - l) / 2;
        	int cnt = 0, i = 0;
        	long curSum = 0;
        	while (i < nums.length) {
        		if (curSum + (long)nums[i] <= mid) {
        			curSum += nums[i];
        			i++;
        		} else {
        			curSum = 0;
        			cnt++;
        		}
        	}
        	if (curSum > 0) cnt++;
        	// System.out.println(mid + " " + cnt);
        	if (cnt <= m) {
        		r = mid;
        	} else {
        		l = mid + 1;
        	}
        }
        return (int)l;
    }
}
