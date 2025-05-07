public class MinimumPathSum {

    /**
     * https://leetcode.com/problems/minimum-path-sum/description/
     * */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for(int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
        for(int i = 1; i < m; i++) {
            int[] crr = new int[n];
            crr[0] = grid[i][0] + dp[0];
            for(int j = 1; j < n; j++) {
                crr[j] = Math.min(crr[j - 1], dp[j]) + grid[i][j];
            }
            dp = crr;
        }
        return dp[n - 1];
    }


}
