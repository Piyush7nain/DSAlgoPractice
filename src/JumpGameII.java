import java.util.*;

public class JumpGameII {

    /**
     * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
     * Each element nums[i] represents the maximum length of a forward jump from index i. In other words,
     * if you are at nums[i], you can jump to any nums[i + j] where:
     * 0 <= j <= nums[i] and
     * i + j < n
     * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
     *
     * Example 1:
     * Input: nums = [2,3,1,1,4]
     * Output: 2
     * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
     *
     * Example 2:
     * Input: nums = [2,3,0,1,4]
     * Output: 2*/
    public static int jumpGame(int[] nums){
        int[] minSteps = new int[nums.length];
        int i = nums.length-2;
        int MAX = 10000001;
        minSteps[i+1]=0;
        while(i>=0){
            int min = MAX;
            for(int j =i+1;j<=i+nums[i]&&j<nums.length;j++){
                if(minSteps[j]<min)
                    min=minSteps[j];
            }
            minSteps[i]=min+1;
            i--;
        }
        return minSteps[0];
    }


    /*
    * from the current position add 1 step and jump to the index which has the max value with the range from the current index*/
    int ans = 0;

    public int jump(int[] nums) {
        int i = 0;
        while (i < nums.length - 1) {
            i = helper(i, nums[i], nums);

        }
        return ans;
    }

    public int helper(int a, int b, int[] nums) {
        ans++;
        if (a + b >= nums.length - 1) {
            return nums.length;
        }
        int max = Integer.MIN_VALUE;
        int temp = 0;
        for (int i = a; i <= a + b; i++) {
            if (nums[i] + i >= max) {
                temp = i;
                max = nums[i] + i;
            }
        }
        return temp;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{3,3,0,5,4,0,1,0,1};
        System.out.println(jumpGame(nums));
    }
}
