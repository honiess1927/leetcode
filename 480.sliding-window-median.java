class Solution {
	public double[] medianSlidingWindow(int[] nums, int k) {
		double[] res = new double[nums.length - k + 1];
		PriorityQueue<Integer> less = new PriorityQueue(Collections.reverseOrder()),
		more = new PriorityQueue();
		for (int i = 0; i < k - 1; i++) 
			less.offer(nums[i]);
		boolean twoValue = k % 2 == 0;
		for (int i = k - 1; i < nums.length; i++) {
			if (!more.isEmpty() && more.peek() < nums[i]) {
				more.offer(nums[i]);
			} else  {
				less.offer(nums[i]);
			}
			while (less.size() < more.size()) {
				less.offer(more.poll());
			}
			while (more.size() + 1 < less.size()) {
				more.offer(less.poll());
			}
			// System.out.println(less + "      " + more);
			res[i - k + 1] = twoValue ? 0.5 * more.peek() + 0.5 * less.peek() : less.peek();
			if (nums[i - k + 1] <= res[i - k + 1]) less.remove(nums[i - k + 1]);
			else more.remove(nums[i - k + 1]);
			// System.out.println(less + "      " + more);

		}
		return res;
	}

}
