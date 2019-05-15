class Solution {
    public int subarraySum(int[] nums, int k) {
    	Map<Integer, Integer> map = new HashMap<>();
    	int sum = 0, res = 0;
    	map.put(0, 1);
    	for (int num : nums) {
    		sum += num;
    		res += map.getOrDefault(sum - k, 0);
    		map.put(sum, map.getOrDefault(sum, 0) + 1);
    		// print(sum, res, map);
    	}
    	return res;
    }
    private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
}
