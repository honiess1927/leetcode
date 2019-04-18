class MyCalendar {
	Map<Integer, Integer> map;

    public MyCalendar() {
    	map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
    	map.put(start, map.getOrDefault(start, 0) + 1);
    	map.put(end, map.getOrDefault(end, 0) - 1);
    	// System.out.println(map);
    	int count = 0;
    	for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    		if (entry.getKey() >= end) break;
    		count += entry.getValue();
    		if (count > 1) {
    			map.put(start, map.get(start) - 1);
    			map.put(end, map.get(end) + 1);
    			return false;
    		}
    	}
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
