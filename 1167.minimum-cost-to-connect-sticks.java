class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;
        for (int stick : sticks) {
            pq.offer(stick);
        }
        while (pq.size() > 1) {
            int cur = pq.poll() + pq.poll();
            res += cur;
            pq.offer(cur);
        }
        return res;
    }
}
