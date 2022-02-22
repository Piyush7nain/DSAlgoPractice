public class MaxSumSubarray {

    /**
     * Find the max possible of any sub-array of a given array
     * */
    public static void main(String[] args) {

        int[] arr = new int[]{-3,-2,-4};
        System.out.println(maxSubarraySum(arr, arr.length));
    }

    /**
     * We move from left to right. With every digit, it can either add to sum of the previous array or can itself me more than the previous array.
     * We need to consider the max of the above to case for each element.
     * */
    static long maxSubarraySum(int arr[], int n) {

        if(n==1)
            return Long.valueOf(arr[0]);

        int current = 1;
        long sum = Long.valueOf(arr[0]);
        long maxSum = Long.valueOf(arr[0]);
        while(current<n){
            sum = Math.max( Long.valueOf(arr[current]), sum + Long.valueOf(arr[current]) );
            maxSum = Math.max(sum,maxSum);
            current++;
        }
        return maxSum;
    }
}
