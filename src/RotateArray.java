import java.util.Arrays;

public class RotateArray {
/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * */
    public static void reverseArray(int[] arr, int start, int end){

        while(end>=start){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end]= temp;
            start++;
            end--;
        }
    }
    public static void rotateArray(int[] nums, int k){

        k = k%nums.length;

        reverseArray(nums,0,(nums.length-1-k));
        reverseArray(nums, nums.length-k, nums.length-1);
        reverseArray(nums, 0, nums.length-1);

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(nums));
        rotateArray(nums, 6);
        System.out.println(Arrays.toString(nums));
    }
}
