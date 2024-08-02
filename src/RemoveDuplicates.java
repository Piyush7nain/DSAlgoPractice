public class RemoveDuplicates {
/**
 * Given an integer array nums sorted in non-decreasing order,
 * remove the duplicates in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same.
 * Then return the number of unique elements in nums.
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
 *
 * Change the array nums such that the first k elements of nums contain the unique elements in the order
 * they were present in nums initially. The remaining elements of nums are not important as well as the
 * size of nums.
 * Return k.
 */

    public static int removeDuplicates(int[] nums) {
        if(nums.length==1)
            return 1;
        int uniquePointer =1;
        int uniqueFinder = 1;
        while(uniqueFinder<nums.length){
            while(uniqueFinder<nums.length&& nums[uniqueFinder-1]==nums[uniqueFinder])
                uniqueFinder++;
            if(uniqueFinder>=nums.length || uniquePointer>=nums.length) break;

            nums[uniquePointer] = nums[uniqueFinder];
            uniquePointer++;
            uniqueFinder++;
        }
        return uniquePointer;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1};
        int last = removeDuplicates(arr);
        for(int i=0;i<last;i++)
            System.out.println(arr[i]);
    }
}
