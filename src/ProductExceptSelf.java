import java.util.Arrays;

public class ProductExceptSelf {
    /**
     * Given an integer array nums, return an array answer such that answer[i] is equal to
     * the product of all the elements of nums except nums[i].
     *
     * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     * You must write an algorithm that runs in O(n) time and without using the division operation.
     *
     * Example 1:
     * Input: nums = [1,2,3,4]
     * Output: [24,12,8,6]
     *
     * Example 2:
     * Input: nums = [-1,1,0,-3,3]
     * Output: [0,0,9,0,0]
     *
     * Constraints:
     *
     * 2 <= nums.length <= 105
     * -30 <= nums[i] <= 30
     * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     * */
    public static int[] productExceptSelf(int[] nums){
        int[] result = new int[nums.length];
        int[] backward = new int[nums.length+1];
        backward[nums.length]=1;
        for(int i=1;i<nums.length;i++){
            backward[backward.length-i-1] = backward[backward.length - i]*nums[nums.length - i];
        }
        int current = 0;
        int mul = 1;
        while(current<nums.length){
            int pr = current+1;
            result[current]= backward[pr]*mul;
            mul= mul*nums[current];
            current++;
        }

        return result;
    }

    //Constant space
    public int[] productExceptSelf2(int[] nums) {
        int n=nums.length;
        int[] result=new int[n];
        int previous=1;
        int after=1;
        for(int i=0;i<n;i++){
            result[i]=previous;
            previous=nums[i]*previous;
        }
        for(int i=n-1;i>=0;i--){
            result[i]=result[i]*after;
            after=after*nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,-1,0,3,-3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
