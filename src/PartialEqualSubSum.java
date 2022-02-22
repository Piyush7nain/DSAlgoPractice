import java.util.Arrays;

public class PartialEqualSubSum {

    /**
     * Given an array arr[] of size N, check if it can be partitioned into two parts such that the sum of elements in both parts is the same.
     *
     * */
    static int target;
    static int[][] sumMem;
    public static void main(String[] args) {

        int[] arr = new int[]{1,5,11,5};
        System.out.println(solution(arr, arr.length));
    }

    /**
     * Given an array, and a sum to be found in that array, we can start from left elem and check recursively if
     * the sub-array to right of it either contains the target elem, or contains the remainder sum if the present is elem is included or contains the sum if the elem is not included.
     * i.e f(i, sum) = Math.max(f(i+1, sum-arr[i]) , f(i+1, sum))
     * We save the result in a 2D array where we store for each elem if sum less than or equal to target is present or not.
     * */
    static int solution(int[] arr, int N){
        target = Arrays.stream(arr).sum();
        if(target%2 !=0) return 0;
        target = target/2;
        int maxElem = Integer.MIN_VALUE;
        for(int e:arr){
            maxElem = Math.max(maxElem, e);
            if(maxElem>target){
                return 0;
            }else if(maxElem==target)
                return 1;
        }
        sumMem = new int[N][target+1];
        for(int i=0;i<N;i++)
            Arrays.fill(sumMem[i], -1);
        int ans = 0;
        for(int i = 0; i<N; i++){

            ans = recSum(arr,i, target);
            if(ans == 1)
                break;
        }
        return ans;
    }

    static int recSum(int[] arr, int start, int subSum){
        if(subSum<0) return 0;
        if(sumMem[start][subSum]==1) return 1;
        else if(sumMem[start][subSum]==0) return 0;
        if(sumMem[start][target]==1) return 1;
        else if(sumMem[start][target]==0) return 0;
        if(arr[start] == subSum) return sumMem[start][subSum] = 1;
        if(arr[start] == target) return sumMem[start][target] = 1;

        if(start == arr.length-1){
            return sumMem[start][target] = sumMem[start][subSum] = 0;
        }

        int ans = recSum(arr, start+1, subSum - arr[start]);
        if(ans==1) return sumMem[start][subSum] = ans;
        ans = recSum(arr,start+1, subSum);

        return sumMem[start][subSum] = ans;
    }
}
