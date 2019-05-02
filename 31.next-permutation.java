class Solution {
    public void nextPermutation(int[] nums) {
        Deque<Integer> list = new LinkedList<>();
        int i = nums.length - 1;
        while (i >= 0) {
        	if (list.isEmpty() || list.peekLast() <= nums[i]) {
        		list.add(nums[i]);
        		i--;
        	} else break;
        }

        // Swap the current with the first element in the list that is bigger than it.
        // The element in the list is ascending, we can even use binary search.
        int index = i + 1;
        if (i >= 0) {
        	int pivot = nums[i];
        	while (list.peek() <= pivot) {
        		nums[index++] = list.poll();
        	}
        	nums[index++] = pivot;
        	nums[i] = list.poll();
        }

        while (!list.isEmpty()) {
        	nums[index++] = list.poll();
        }
    }
    private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
}
