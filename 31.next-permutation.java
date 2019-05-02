class Solution {
    public void nextPermutation(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        int i = nums.length - 1;
        while (i >= 0) {
        	if (list.isEmpty() || list.getLast() <= nums[i]) {
        		list.add(nums[i]);
        		i--;
        	} else break;
        }
        if (i >= 0) {
        	ListIterator<Integer> iter = list.listIterator(0);
        	while (iter.next() <= nums[i]);
        	int tmp = nums[i];
        	nums[i] = iter.previous();
        	iter.set(tmp);
        }
        i++;
        Iterator<Integer> iter = list.iterator();
        while (i < nums.length) {
        	nums[i++] = iter.next();
        }
    }
    private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
}
