public class SearchInRotatedSortedArray {

    /**
     * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
     * */

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return mid;
            }else if( nums[start] <= nums[mid]) {
                // left half is sorted
                if(nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                // right half is sorted
                if(nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();
        System.out.println(search.search(new int[]{6,7,8,9,0,1,2,3,4,5}, 9));
    }
}
