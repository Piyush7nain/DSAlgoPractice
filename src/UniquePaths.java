public class UniquePaths {
    /**
     * https://leetcode.com/problems/unique-paths/description/
     * */


    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;
        for (int i = m-1; i >=0 ; i--) {
            for(int j = n-1; j >=0; j--) {
                if(i == m-1 && j == n-1) {
                    dp[i][j] = 1;
                }else{
                    int down = i +1 > m-1 ? 0 : dp[i+1][j];
                    int right = j+1 > n-1 ? 0 : dp[i][j+1];
                    dp[i][j] = down + right;
                }

            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3, 2));
    }
}
