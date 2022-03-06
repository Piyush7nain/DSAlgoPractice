public class Knapsack01 {


    /**
     * You are given weights and values of N items, put these items in a knapsack of capacity W
     * to get the maximum total value in the knapsack. Note that we have only one quantity of each item.
     * In other words, given two integer arrays val[0...N-1] and wt[0...N-1] which represent values and weights
     * associated with N items respectively. Also given an integer W which represents knapsack capacity, find out
     * the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
     * You cannot break an item, either pick the complete item or don't pick it (0-1 property).
     * */
    public static void main(String[] args) {

        int[] wt = new int[]{};
        int[] val = new int[]{};
        int n = wt.length;
        int W = 0;
        System.out.println(solution(wt, val, n, W));
    }

    /**
     * The Solution is similar to PartialEqualSubSum. Where we find out if a sum is possible in a given part of array.
     * Here for each element ( going left to right), we find the max possible value between the two cases, i.e. either select the
     * current element and check for max value possible with remaining weight in the array left to the current element or don't select
     * the current element and max value for total weight in the left sub array. For each elem, we run a loop to find out max value for
     * each weight less that the limit so that we can use the value for the next elem.
     * Our answer is the max value for weight limit for last elem.
     * */
    static int solution(int[] wt, int[] val, int n, int W){

        int[] previous = new int[W +1];
        if(n==1){
            if(wt[0] < W) return val[0];
            else return 0;
        }

        int i;
        for(i=0; i<wt[0] && i<= W; i++)
            previous[i] = 0;
        for(i = wt[0]; i<= W; i++)
            previous[i] = val[0];

        int index = 1;
        while(index<n){
            int[] current = new int[W +1];
            for(int j = 0; j<= W; j++){
                if(wt[index]> j){
                    current[j] = previous[j];
                }else{
                    current[j] = Math.max( previous[j], previous[j - wt[index]] + val[index]  );
                }
            }
            previous = current;
            index++;
        }
        return previous[W];
    }

}
