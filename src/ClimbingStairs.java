public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        //to reach current step, we need to present at either 1 step behind or two step behind

        int prev1 = 2; // 1 step behind, starting at stair two, there are two ways
        int prev2 = 1; // 2 step behind, starting at stair 1, one 1 to reach step 1
        for(int i = 3; i <= n; i++) {
            int cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}
