import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinimumTotalSpaceWasted {

    /**
     * https://leetcode.com/problems/minimum-total-space-wasted-with-k-resizing-operations/description/
     * */

    public int minSpaceWastedKResizing(int[] nums, int k) {
        int[][] dp = new int[nums.length][k + 1];
        return 0;

    }

    public int rec(int[] nums, int k , int lastSize, int currIndex, int[][] dp){

        if(currIndex == nums.length){
            return 0;
        }
        if(k<=0)
        if(dp[currIndex][k] != 0){
            return dp[currIndex][k];
        }
        return 0;
    }
}
