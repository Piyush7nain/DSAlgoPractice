public class MergeSortedArray {
    /**
     * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
     * representing the number of elements in nums1 and nums2 respectively.
     *
     * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
     *
     * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
     * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should
     * be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
     * Example 1:
     *
     * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * Output: [1,2,2,3,5,6]
     * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
     * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
     * */

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,4,4,5,5,7,9,0,0,0};
        int[] nums2 = new int[]{4,5,20};

        merge2(nums1,nums1.length, nums2, nums2.length);

        for(int a: nums1)
            System.out.println(a);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        /** swaps the larger element between current element in first array with the first element in second array
         * then the swapped element is placed in the right place in the second array and pointer of first array is increased
         * this is done till all elements in first array are traversed, then second array is merged.
         * */

        int firstPointer  = 0;
        int secondPointer = 0;
        m = m-n;
        if(m==0) {
            for(int i= 0;i<n;i++)
                nums1[i] = nums2[i];
            return;
        }
        if(n==0) return;

        while(secondPointer<n && firstPointer<m){
            if (nums1[firstPointer]>nums2[secondPointer]){
                int temp = nums1[firstPointer];
                nums1[firstPointer] = nums2[secondPointer];
                nums2[secondPointer]= temp;
                for(int j = secondPointer; j<n-1;j++){
                    if(nums2[j]> nums2[j+1]){
                        temp = nums2[j];
                        nums2[j] = nums2[j+1];
                        nums2[j+1] = temp;
                    } else break;
                }
            }
            firstPointer++;
        }
        secondPointer =0;
        firstPointer = m;
        while(secondPointer<n){
            nums1[firstPointer+ secondPointer] = nums2[secondPointer];
            secondPointer++;
        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n){
        m = m-n;
        int end = m+n-1;
        int firstpointer = m-1;
        int secondpointer = n-1;

        while(firstpointer>=0&&secondpointer>=0){
            if(nums1[firstpointer]>nums2[secondpointer]){
                nums1[end] = nums1[firstpointer];
                firstpointer--;
            }else{
                nums1[end] = nums2[secondpointer];
                secondpointer--;
            }
            end--;
        }


        while(secondpointer>=0){
            nums1[end] = nums2[secondpointer];
            secondpointer--;
            end--;
        }

    }

}
