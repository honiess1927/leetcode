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
    public List<Interval> merge(List<Interval> intervals) {
    	List<Interval> res = new LinkedList<>();
    	if (intervals.isEmpty())  return res;
    	Collections.sort(intervals, (a, b) -> a.start - b.start);
    	Interval pivot = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
        	Interval cur = intervals.get(i);
        	if (cur.start <= pivot.end) {
        		pivot.end = Math.max(pivot.end, cur.end);
        	} else {
        		res.add(pivot);
        		pivot = cur;
        	}
        }
        res.add(pivot);
        return res;
    }
}
