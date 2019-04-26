class MovingAverage {
	int size;
	Queue<Integer> queue;
	double sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        queue = new LinkedList<>();
        sum = 0.0;
    }
    
    public double next(int val) {
        queue.offer(val);
        sum += val;
        if (queue.size() > size) sum -= queue.poll();
        return sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
