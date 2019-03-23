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
		@Override public int compareTo(TimeStamp other) {
			if (this.ts != other.ts) return this.ts - other.ts;
			else if (this.isStart) return 1;
			return -1;
		}
	}
    public int minMeetingRooms(Interval[] intervals) {
    	List<TimeStamp> list = new LinkedList<>();
    	for (Interval interval : intervals) {
    		list.add(new TimeStamp(interval.start, true));
    		list.add(new TimeStamp(interval.end, false));
    	}
    	Collections.sort(list);
    	int res = 0, cur = 0;
    	for (TimeStamp ts: list) {
    		if (ts.isStart) {
    			cur++;
    			res = Math.max(cur, res);
    		} else {
    			cur--;
    		}
    	}
    	return res;
    }
}
