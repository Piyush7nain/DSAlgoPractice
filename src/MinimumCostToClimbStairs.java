public class MinimumCostToClimbStairs {
    /**
     * https://leetcode.com/problems/min-cost-climbing-stairs/
     * */

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n == 0) return 0;
        if(n == 1) return 0;
        int minCost = Integer.MAX_VALUE;
        int prevPrevCost = cost[0];
        int prevCost = cost[1];
        for(int i = 2; i < n; i++) {
            minCost = Math.min(prevCost, prevPrevCost) + cost[i];
            prevPrevCost = prevCost;
            prevCost = minCost;
        }
        return Math.min(prevCost, prevPrevCost);
    }

    public static void main(String[] args) {
        MinimumCostToClimbStairs minCostToClimbStairs = new MinimumCostToClimbStairs();
        System.out.println(
                minCostToClimbStairs.minCostClimbingStairs(new int[]{
                        1,100,1,1,1,100,1,1,100,1
                })
        );
    }
}
