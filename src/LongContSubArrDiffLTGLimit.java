import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class LongContSubArrDiffLTGLimit {

    /**
     * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/
     *
     * Example 2:
     * Input: nums = [10,1,2,4,7,2], limit = 5
     * Output: 4
     * Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute diff is |2-7| = 5 <= 5.
     *
     * */

    public int longestSubarray(int[] arr, int limit) {
        if(arr == null || arr.length == 0) {
            return 0;
        }
        int left = 0;
        int ans=  0;
        LinkedList<Integer> inc = new LinkedList<>();
        LinkedList<Integer> dec = new LinkedList<>();
        for(int i = 0; i < arr.length; i++) {
            int crr = arr[i];
            while(!inc.isEmpty() && crr < inc.getLast()) {
                inc.removeLast();
            }
            inc.add(crr);
            while(!dec.isEmpty() && crr > dec.getLast()) {
                dec.removeLast();
            }
            dec.add(crr);
            while( dec.getFirst() - inc.getFirst() > limit ) {
                if(arr[left] == dec.peekFirst()) {
                    dec.removeFirst();
                }
                if(arr[left] == inc.peekFirst()) {
                    inc.removeFirst();
                }
                left++;
            }
            ans = Math.max(ans,i - left + 1 );
        }
        return ans;
    }

    public static void main(String[] args) {
        LongContSubArrDiffLTGLimit c = new LongContSubArrDiffLTGLimit();
        System.out.println(c.longestSubarray(new int[]{7,40,10,10,40,39,96,21,54,73,33,17,2,72,5,76,28,73,59,22,100,91,80,66,5,49,26,45,13,27,74,87,56,76,25,64,14,86,50,38,65,64,3,42,79,52,37,3,21,26,42,73,18,44,55,28,35,87}, 63));
    }

}
