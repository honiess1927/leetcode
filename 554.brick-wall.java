class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (List<Integer> list : wall) {
        	int sum = 0;
        	for (int brick : list) {
        		sum += brick;
        		map.put(sum, map.getOrDefault(sum, 0) + 1);
        	}
        	map.put(sum, map.get(sum) - 1);
        }

        for (int count : map.values()) {
        	max = Math.max(count, max);
        }

        return wall.size() - max;
    }
}
