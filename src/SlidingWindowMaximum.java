import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    /**
     * You are given an array of integers nums, there is a sliding window of size k which is moving from the
     * very left of the array to the very right. You can only see the k numbers in the window.
     * Each time the sliding window moves right by one position.
     * Return the max sliding window.
     *
     * Example 1:
     * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
     * Output: [3,3,5,5,6,7]
     * Explanation:
     * Window position                Max
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     *
     * Example 2:
     * Input: nums = [1], k = 1
     * Output: [1]
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     * 1 <= k <= nums.length
     * */
    public static void main(String[] args) {
        int[] nums= new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow2(nums,k)));
    }
    public static int[] maxSlidingWindow(int[] nums, int k){
        int[] results = new int[nums.length-k+1];
        int back = 0;
        int maxInd = -1;
        while(back<results.length){
            int front= back+k-1;
            if(maxInd<back){
                maxInd = findMax(nums, back, front);
            }else if(nums[front]>=nums[maxInd]){
                maxInd = front;
            }
            results[back] = nums[maxInd];
            back++;
        }
        return results;
    }
    static int findMax(int[] nums, int start, int end){
        int max = nums[start];
        int ind=start;
        for(int i=start; i<=end;i++){
            if(nums[i]>=max){
                ind = i;
                max = nums[i];
            }
        }
        return ind;
    }


    public static int[] maxSlidingWindow2(int[] nums, int k) {

        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[nums.length -k +1];
        int curr = 0;
        while(curr<k){

            while(!dq.isEmpty() && nums[dq.peekLast()]<= nums[curr]){
                dq.removeLast();
            }
            dq.offerLast(curr);
            curr++;
        }
        ans[0] = nums[dq.peekFirst()];
        int i = 1;
        while(curr<nums.length ){
            while(!dq.isEmpty() && nums[dq.peekLast()]<= nums[curr]){
                dq.removeLast();
            }
            dq.offerLast(curr);

            if(dq.peekFirst()< curr -k +1)
                dq.removeFirst();
            ans[i] = nums[dq.peekFirst()];
            i++;
            curr++;
        }

        return ans;
    }
}
