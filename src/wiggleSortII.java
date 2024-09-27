import java.util.Arrays;

public class wiggleSortII {
    /**
     * Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
     * You may assume the input array always has a valid answer.
     *
     * Example 1:
     * Input: nums = [1,5,1,1,6,4]
     * Output: [1,6,1,5,1,4]
     * Explanation: [1,4,1,5,1,6] is also accepted.
     *
     * Example 2:
     * Input: nums = [1,3,2,2,3,1]
     * Output: [2,3,1,3,1,2]
     *
     *
     * Constraints:
     * 1 <= nums.length <= 5 * 104
     * 0 <= nums[i] <= 5000
     * It is guaranteed that there will be an answer for the given input nums.
     *
     * Follow Up: Can you do it in O(n) time and/or in-place with O(1) extra space?
     * */
    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int pivot;
        if(nums.length%2==0){
            pivot = (nums.length/2)-1;
        }else{
            pivot = nums.length/2;
        }
        int[] newArr = new int[nums.length];
        int start =0;
        int ind = 0;
        while(start<=pivot){
            newArr[ind] = nums[start];
            ind++;
            newArr[ind] = nums[start+pivot+1];
            ind++;
            start++;
        }

        nums = newArr;
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,2,3,3,4};
        System.out.println(Arrays.toString(nums));
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
