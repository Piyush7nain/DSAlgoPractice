import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    /**
     * Given an array of intervals where intervals[i] = [starti, endi],
     * merge all overlapping intervals, and return an array of the non-overlapping
     * intervals that cover all the intervals in the input.
     *
     * Example 1:
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
     *
     *  Example 2:
     * Input: intervals = [[1,4],[4,5]]
     * Output: [[1,5]]
     * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     *
     * Constraints:
     * 1 <= intervals.length <= 104
     * intervals[i].length == 2
     * 0 <= starti <= endi <= 104
     * */

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }
        /*
        * if sort by first index, then for [a, b]
        * a =[a1, a2], b = [b1, b2] & a1<b1
        * then, if b1<a2 then merge else if b1> a2 then not overlapping
        * O(nlog(n))
        * */

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= res.get(res.size() - 1)[1]) {
                int[] merge = new int[2];
                merge[0] = Math.min(intervals[i][0],res.get(res.size()-1)[0]);
                merge[1] = Math.max(intervals[i][1],res.get(res.size()-1)[1]);
                res.set(res.size() - 1, merge);
            }else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{2,6},{1,2},{8,10},{15,18},{9, 16}};
        MergeIntervals m = new MergeIntervals();
        int[][] result = m.merge(intervals);
        System.out.println(Arrays.deepToString(result));
    }
}
