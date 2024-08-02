public class RemoveElements {
/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
 * The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 *
 * Consider the number of elements in nums which are not equal to val be k, to get accepted,
 * you need to do the following things:
 *
 * Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 *
 * Example 1:
 *
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2,_,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 2.
 * It does not matter what you leave beyond the returned k (hence they are underscores)
 * */

/**
 * Start probing until you find non-val element. Start a replace counter from front until you find matching elem.
 * Swap both, then continue search until pointer cross each others.
 * */
    public static int removeElement(int[] nums, int val) {
        if(nums.length==0)
            return 0;
        if(nums.length==1){
            if(nums[0]==val)
                return 0;
            else return 1;
        }

        int replace=0;
        int probe=nums.length-1;
        while(probe>=replace){
            while(probe>=replace&&nums[probe]==val){
                probe--;
            }
            while(replace<=probe&&nums[replace]!=val){
                replace++;
            }
            if(probe<=replace) break;
            nums[replace] = nums[probe];
            nums[probe] = val;
            probe--;
            replace++;
        }
        return replace;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        int last =removeElement(nums, val);
        System.out.println("Last:"+last);
        for(int i=0;i<last;i++)
            System.out.println(nums[i]);
    }
}
