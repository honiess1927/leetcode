/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
	private static class TimeStamp implements Comparable<TimeStamp> {
		int ts;
		boolean isStart;
		TimeStamp(int ts, boolean isStart) {
			this.ts = ts;
			this.isStart = isStart;
		}
		@Override
		public int compareTo(TimeStamp other) {
			if (this.ts != other.ts) return this.ts - other.ts;
			else if (this.isStart) return -1;
			else return 1;
		}
	}
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<TimeStamp> pq = new PriorityQueue<>();
        for (List<Interval> list : schedule) {
        	for (Interval interval : list) {
        		pq.offer(new TimeStamp(interval.start, true));
        		pq.offer(new TimeStamp(interval.end, false));
        	}
        }
        int cnt = 0, prev = -1;
        List<Interval> res = new LinkedList<>();
        while (!pq.isEmpty()) {
        	TimeStamp ts = pq.poll();
        	if (ts.isStart) {
        		cnt++;
        		if (cnt == 1 && prev != -1) res.add(new Interval(prev, ts.ts));
        	} else {
        		cnt--;
        		if (cnt == 0) prev = ts.ts;
        	}
        }
        return res;
    }
}
