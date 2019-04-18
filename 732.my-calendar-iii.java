class MyCalendarThree {
	Map<Integer, Integer> map;
    public MyCalendarThree() {
        map = new TreeMap<>();
    }
    
    public int book(int start, int end) {
    	map.put(start, map.getOrDefault(start, 0) + 1);
    	map.put(end, map.getOrDefault(end, 0) - 1);
    	int cnt = 0, max = 0;
    	for (Integer val : map.values()) {
    		cnt += val;
    		max = Math.max(max, cnt);
    	}
    	return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
