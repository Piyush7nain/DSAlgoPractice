public class NextPermutation {

    /**
     * https://leetcode.com/problems/next-permutation/description/
     * */

    /* first find from the right which is smaller than its right element. Then find the element to its right which is
    bigger than this element.
     Swap the two elements. and then reverse the array from the right index of the swapped element.
     [1,2,4,3,0]
     crr =  2 { element 4}
     swap with 2.
     [1,3,4,2,0]
     [1,3,0,2,4]
    */
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i+1]) i--;
        if(i >= 0) {
            int j = nums.length - 1;
            while(j > i && nums[j] <= nums[i]) j--;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            reverse(nums, i+1);
        }
        else{
            reverse(nums, 0);
        }

    }
    private void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }


}
