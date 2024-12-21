import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumSizeSubArraySum {
    /**
     * Given an array of positive integers nums and a positive integer target, return the minimal length of a
     * subarray
     *  whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
     *
     * Example 1:
     * Input: target = 7, nums = [2,3,1,2,4,3]
     * Output: 2
     * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
     *
     *  Example 2:
     * Input: target = 4, nums = [1,4,4]
     * Output: 1
     *
     *  Example 3:
     * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
     * Output: 0
     *  */
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int min = nums.length+1;
        Queue<Integer> q = new ArrayDeque<>();
        for (int num : nums) {
            sum = sum + num;
            q.add(num);

            while (!q.isEmpty() && sum >= target) {
                min = Math.min(min, q.size());
                sum -= q.poll();
            }
//            if (sum == target && q.size() <= min) {
//                min = q.size();
//            }
        }
        if(min == nums.length+1){
            return 0;
        }
        return min;
    }
    public int minSubArrayLen2(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int min = nums.length+1;
        int left = 0;
        int right = 0;
        for (right=0;right<nums.length;right++) {
            sum = sum + nums[right];
            while (left<=right && sum >= target) {
                min = Math.min(min, right-left+1);
                sum -= nums[left];
                left++;
            }
        }
        if(min == nums.length+1){
            return 0;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int target = 11;
        System.out.println(new MinimumSizeSubArraySum().minSubArrayLen2(target, nums));
    }
}
