public class MajorityElement {
/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * */

/**
 * Since we are looking for element which occurs more than half times, we can look at it as every alternate will be that element
 * and there will be one occurrence where the element will occur simultaneously. We can use a counter which will keep inc
 * if we encounter same elements consecutively and decrease if diff elements are found. We switch the major element if
 * counter becomes 0. in the worst possible case, we will have on occurrence of simultaneous major elements, making counter =2
 * and after that if will keep going up and down it alternate between major and other elements.
 * the counter never becomes zero, therefore never switching the major element
 * */
    public static int majorityElement(int[] nums){
        if(nums.length==1)
            return nums[0];

        int major =nums[0];
        int counter=1;
        for(int i=1;i<nums.length;i++) {
            if(counter==0) major=nums[i];
            if(major==nums[i]) counter++;
            else counter--;
        }
        return major;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,2,3,4,2,2,5,2,2,5,3};
        System.out.println(majorityElement(nums));
    }

}
