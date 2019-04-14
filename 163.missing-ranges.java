class Solution {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> res = new LinkedList<>();
		int l = 0;
		long next = lower;
		while (l < nums.length) {
			int num = nums[l];
			if (num == next) {
				next++;
			} else {
				StringBuilder sb = new StringBuilder();
				sb.append(next);
				if (num != next + 1) sb.append("->").append(num - 1);
				res.add(sb.toString());
				next = (long)num + 1;
			}
			while (l < nums.length && nums[l] == num) l++;
		}
		if (next <= upper) {
			StringBuilder sb = new StringBuilder();
			sb.append(next);
			if (upper != next) sb.append("->").append(upper);
			res.add(sb.toString());
		}
		return res;
	}
}
