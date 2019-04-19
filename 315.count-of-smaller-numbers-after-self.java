class Solution {
	int[] nums, index;
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> result = new LinkedList<>();
		if (nums.length == 0) return result;
		int[] res = new int[nums.length];
		this.nums = nums;
		index = new int[nums.length];
		for (int i = 0; i < nums.length; i++) 
			index[i] = i;
		mergeSort(res, 0, nums.length);
		for (int x : res) result.add(x);
			return result;
	}

	private void mergeSort(int[] res, int l, int r) {
		// System.out.println(l + ":" + r);
		if (l == r - 1) return;
		int[] tmp = new int[nums.length];
		int numTmp = 0;
		int mid = l + (r - l) / 2;
		mergeSort(res, l, mid);
		mergeSort(res, mid, r);
		// System.out.println(Arrays.toString(index));
		int i = l, j = mid;
		while (i < mid || j < r) {
			// System.out.println(i + "  " + j);
			if (i == mid ||(j != r && get(j) < get(i))) {
				tmp[numTmp++] = index[j++];
			} else {
				res[index[i]] += j - mid;
				tmp[numTmp++] = index[i++];
			}
		}
		for (i = l; i < r; i++) {
			index[i] = tmp[i - l];
		}
	}

	private int get(int i) {
		return nums[index[i]];
	}
}
