public class MedianOfTwoSortedArrays {

    /**
     * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
     * */

    /*
    * search for middle values in both arrays such the a[mid1]  <= b[mid2 +1] and b[mid2] < a[mid1 +1]
    * then the median would be either (a[mid1] + b[mid2])/2 or math.max(a[mid1] , b[mid2])
    * */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int mid = (m + n +1)/2;
        int left = 0;
        int right = m;
        while(left <= right){
            int m1 = (left + right)/2;
            int m2 = mid - m1;
            int aLeft = (m1 <= 0)? Integer.MIN_VALUE : nums1[m1-1];
            int bLeft = (m2 <= 0)? Integer.MIN_VALUE : nums2[m2-1];
            int aRight = (m1 > m)? Integer.MAX_VALUE : nums1[m1];
            int bRight = (m2 > n)? Integer.MAX_VALUE : nums2[m2];
            if( aLeft <= bRight && aRight >= bLeft){
                if( (m + n)%2 == 0){
                    return ( Math.max (aLeft, bLeft) + Math.min(aRight, bRight))/2.0;
                }else{
                    return (double) Math.min(aRight, bRight);
                }
            }else if( aLeft > bRight){
                right = m1 - 1;
            }else{
                left = m1 + 1;
            }
        }
        return 0.0;
    }
}
