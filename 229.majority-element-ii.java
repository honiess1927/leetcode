class Solution {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new LinkedList<>();
		if (nums.length == 0) return result;
		int[] can = new int[2], count = new int[2];
		for (int num : nums) {
			if (count[0] == 0) {
				can[0] = num;
				count[0]++;
			} else if (num == can[0]) count[0]++;
			else if (count[1] == 0) {
				can[1] = num;
				count[1]++;
			} else if (num == can[1]) {
				count[1]++;
				if (count[1] > count[0]) {
					int swap = can[0];
					can[0] = can[1];
					can[1] = swap;

					swap = count[0];
					count[0] = count[1];
					count[1] = swap;
				}
			} else {
				count[0]--;
				count[1]--;
			}
		}
		for (int i = 0; i < 2; i++) {
			int cnt = 0;
			if (count[i] > 0) {
				for (int num : nums) {
					if (can[i] == num) cnt++;
				}
			}
			if (cnt > nums.length / 3) result.add(can[i]);
		}
		return result;
	}
}
