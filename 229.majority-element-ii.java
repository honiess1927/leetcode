class Solution {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new LinkedList<>();
		if (nums.length == 0) return result;
		int res = nums[0], count = 0;
		int counter = 0;
		for (int num : nums) {
			if (num == res) count++;
			else {
				if (count == 0) {
					res = num;
					count++;
				} else {
					if (counter == 1) {
						count--;
						counter = 0;
					} else {
						counter++;
					}
				}
			}
		}
		count = 0;
		for (int num : nums) {
			if (num == res) count++;
		}
		if (count > nums.length / 3) result.add(res);
		int i = 0;
		while (i < nums.length && nums[i] == res) i++;
		if (i >= nums.length) return result;
		int newRes = nums[i];
		count = 0;
		for (; i < nums.length; i++) {
			int num = nums[i];
			if (num == res) continue;
			if (num == newRes) count++;
			else {
				if (count == 0) {
					newRes = num;
					count++;
				} else count--;
			}
		}
		count = 0;
		for (int num : nums) {
			if (num == newRes) count++;
		}
		if (count > nums.length / 3) result.add(newRes);
		return result;
	}
}
