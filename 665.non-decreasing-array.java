class Solution {
	public boolean checkPossibility(int[] a) {
        // int first = -1, second = -1;
        // for (int i = 1; i < nums.length; i++) {
        // 	if (nums[i] > nums[i - 1]) {
        // 		if (first == -1) first = i - 1;
        // 		else if (second == -1) second = i;
        // 		else return false;
        // 	}
        // }
        // if (first == -1 && second == -1) return false;
        // if (second == -1) second = first + 1;
        // int swap = nums[first];
        // nums[first] = nums[second];
        // nums[second] = swap;
        // // System.out.println(Arrays.toString(nums));
        // boolean res = true;
        // if (first > 0) res = res && (nums[first - 1] >= nums[first]);
        // res = res && nums[first] >= nums[first + 1];
        // res = res && nums[second - 1] >= nums[second];
        // if (second < nums.length - 1) res = res && (nums[second] >= nums[second + 1]);
        // return res;
        boolean flag = false;
        for (int i = 1; i < a.length; i++) {
        	if (a[i - 1] > a[i]) {
        		if (i == 1 || (i + 1 < a.length && a[i + 1] < a[i - 1])) a[i - 1] = a[i];
        		else a[i] = a[i - 1];
        		break;
        	}
        }
        for (int i = 1; i < a.length; i++) {
        	if (a[i - 1] > a[i]) return false;
        }
        return true;
	}
}
