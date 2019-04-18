class MyCalendarTwo {
	Map<Integer, Integer> map;

    public MyCalendarTwo() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
    	map.put(start, map.getOrDefault(start, 0) + 1);
    	map.put(end, map.getOrDefault(end, 0) - 1);
    	int cnt = 0;
    	for (Integer val : map.values()) {
    		cnt += val;
    		if (cnt > 2) {
    			map.put(start, map.get(start) - 1);
    			map.put(end, map.get(end) + 1);
    			return false;
    		}
    	}
    	return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
