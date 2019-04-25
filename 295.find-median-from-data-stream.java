class MedianFinder {
	PriorityQueue<Integer> less, more;
	boolean isEven;

    /** initialize your data structure here. */
    public MedianFinder() {
        less = new PriorityQueue<>(Collections.reverseOrder());
        more = new PriorityQueue<>();
        isEven = true;
    }
    
    public void addNum(int num) {
        if (less.isEmpty() || num <= less.peek()) less.offer(num);
        else more.offer(num);
        while (less.size() < more.size()) less.offer(more.poll());
        while (more.size() + 1 < less.size()) more.offer(less.poll());
        isEven = !isEven;
    }
    
    public double findMedian() {
    	// print(less);
    	// print(more);
    	// print(isEven);
        if (isEven) return 0.5 * less.peek() + 0.5 * more.peek();
        else return 1.0 * less.peek();
    }
    private void print(Object x) {System.out.print(x + "    ");}
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
