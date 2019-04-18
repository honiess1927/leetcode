class MyCalendar {
	List<int[]> list;

    public MyCalendar() {
        list = new LinkedList<>();
    }
    
    public boolean book(int start, int end) {
    	for (int[] a : list) {
    		if (Math.max(start, a[0]) < Math.min(end, a[1])) return false;
    	}
    	list.add(new int[]{start, end});
    	return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
