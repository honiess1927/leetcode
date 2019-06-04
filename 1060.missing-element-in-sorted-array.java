class Solution {
    public int missingElement(int[] nums, int k) {
        return helper(nums, 0, nums.length - 1, k);
    }

    private int helper(int[] nums, int l, int r, int k) {
        // print(l, r, k);
        if (r <= l + 1) {
            int res = nums[l] + k;
            if (res > nums[r] && l != r) return res + 1;
            else return res;
        }
        int mid = l + (r - l) / 2;
        // print("mid", mid, "num[mid]", nums[mid]);
        int numMiss = (nums[mid] - nums[l]) - (mid - l);
        // print("numMiss ", numMiss);
        if (numMiss >= k) {
            return helper(nums, l, mid, k);
        } else {
            return helper(nums, mid, r, k - numMiss);
        }
    }
private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
    // 0,1,2
    // 9 - 4 = 5
    // 4,7,9 (5,6,8)

    //
}
