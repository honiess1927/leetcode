class Solution {
	public int smallestDistancePair(int[] nums, int k) {
		Arrays.sort(nums);
		int n = nums.length;
		int l = 0, r = nums[n - 1] - nums[0];
		while (l < r) {
			int mid = l + (r - l) / 2;
        	// count nums <= mid
			int count = 0;
			for (int i = 0; i < n - 1; i++) {
				int ll = i, rr = n - 1;
				while (ll < rr) {
					int mm = ll + (rr - ll) / 2;
        			// print(ll,rr,mm);
					if (nums[mm] - nums[i] > mid) {
						rr = mm;
					} else {
						ll = mm + 1;
					}
				}
				if (nums[ll] - nums[i] <= mid) ll++;
				count += ll - i - 1;
				// print(count);
			}
			// print("|", mid, count);
			if (count >= k) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}
	private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
}
