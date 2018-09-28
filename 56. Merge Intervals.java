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
        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        int counter = 0;
        Interval pre = null;
        for (Interval i : new ArrayList<>(intervals)) {
            if (counter == 0) {
                pre = i;
                counter++;
                continue;
            }
            if (pre.end >= i.start) {
                if (pre.end <= i.end) {
                    pre.end = i.end;
                }
                intervals.remove(i);
            } else {
                    pre = i;
            }
        }
        return intervals;
    }
}
