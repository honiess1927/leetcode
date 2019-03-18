class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
    	Map<String, Integer> map = new HashMap<>();
    	for (int i = 0; i < list1.length; i++) {
    		map.put(list1[i], i);
    	}
    	int min = Integer.MAX_VALUE;
    	List<String> res = new LinkedList<>();;
    	for (int i = 0; i < list2.length; i++) {
    		if (i > min) break;
    		if (!map.containsKey(list2[i])) continue;
    		int sum = map.get(list2[i]) + i;
    		if (sum <= min) {
    			if (sum < min) res.clear();
    			min = sum;
    			res.add(list2[i]);
    		}
    	}
    	return res.toArray(new String[0]);
    }
}
