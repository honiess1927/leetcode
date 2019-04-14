class Solution {
    public int reversePairs(int[] nums) {
        return sort(nums, 0, nums.length);
    }

    private int sort(int[] num, int l, int r) {
    	if (l + 1 >= r) return 0;
    	int mid = (l + r) / 2;
    	int res = 0;
    	res += sort(num, l, mid);
    	res += sort(num, mid, r);
    	int i = l, j = mid, index = 0;
    	int[] tmp = new int[r - l];
    	while (i < mid && j < r) {
    		if ((long) num[i] > 2L * num[j]) {
    			res += mid - i;
    			j++;
    		} else {
    			i++;
    		}
    	}
    	i = l;
    	j = mid;
    	while (i < mid && j < r) {
    		if (num[i] < num[j]) {
    			tmp[index++] = num[i++];
    		} else {
    			tmp[index++] = num[j++];
    		}
    	}
    	while (i < mid) tmp[index++] = num[i++];
    	while (j < r) tmp[index++] = num[j++];
    	for (i = l; i < r; i++) {
    		num[i] = tmp[i - l];
    	}
    	return res;
    }
}
