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
        int res = Integer.MIN_VALUE;
        int x = 0;
        int y = 0;
        int cMax = 0;
        int cMin = 0;
        while(x<=y && y<arr.length) {
            if(x > cMin){
                cMin = x;
            }else if(x > cMax){
                cMax = x;
            }
            if(arr[y] < arr[cMin] ){
                cMin = y;
            }else if( arr[y] > arr[cMax]){
                cMax = y;
            }
            int diff = Math.abs(arr[cMax] - arr[cMin]);
            if(diff > limit) {
                x++;
            }else{
                res = Math.max(res, Math.abs(y-x +1));
                System.out.println("Current res between " + arr[x]+" and " + arr[y]);
                y++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongContSubArrDiffLTGLimit c = new LongContSubArrDiffLTGLimit();
        System.out.println(c.longestSubarray(new int[]{7,40,10,10,40,39,96,21,54,73,33,17,2,72,5,76,28,73,59,22,100,91,80,66,5,49,26,45,13,27,74,87,56,76,25,64,14,86,50,38,65,64,3,42,79,52,37,3,21,26,42,73,18,44,55,28,35,87}, 63));
    }

}
