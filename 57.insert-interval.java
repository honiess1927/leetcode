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
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		int i = 0;
		List<Interval> res = new LinkedList<>();
		while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
			res.add(intervals.get(i));
			i++;
		}
		if (i == intervals.size()) {
			res.add(newInterval);
			return res;
		}

		if (newInterval.end >= intervals.get(i).start) {
			newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
			newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
			i++;
		}

		while (i < intervals.size() && newInterval.end >= intervals.get(i).start) {
			newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
			i++;
		}

		res.add(newInterval);

		for (; i < intervals.size(); i++) 
			res.add(intervals.get(i));
		return res;
	}
}
