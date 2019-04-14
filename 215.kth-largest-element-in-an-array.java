class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findK(nums, 0, nums.length, k - 1);
    }

    private int findK(int[] nums, int l, int r, int k) {
    	if (l + 1 >= r) return nums[l];
    	int pivot = nums[l];
    	int[] tmp = new int[r - l];
    	int ll = l, rr = r - 1;
    	for (int i = l + 1; i < r; i++) {
    		if (nums[i] >= pivot) tmp[ll++ - l] = nums[i];
    		else tmp[rr-- - l] = nums[i];
    	}
    	tmp[ll - l] = pivot;
    	for (int i = l; i < r; i++) {
    		nums[i] = tmp[i - l];
    	}
    	// System.out.print(l + " " + r + " " + ll + " " + Arrays.toString(nums) + "     ");
    	int rank = ll - l;
    	if (rank == k) return pivot;
    	if (rank < k) return findK(nums, ll + 1, r, k - rank - 1);
    	return findK(nums, l, ll, k);
    }
}
