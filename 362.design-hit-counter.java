class HitCounter {
    TreeMap<Integer, Integer> map;
    int totalhit;
    /** Initialize your data structure here. */
    public HitCounter() {
        map = new TreeMap<>();
        map.put(0, 0);
        totalhit = 0;
    }

    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        map.put(timestamp, ++totalhit);
    }

    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        return map.floorEntry(timestamp).getValue() - map.floorEntry(Math.max(0, timestamp - 300)).getValue();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
