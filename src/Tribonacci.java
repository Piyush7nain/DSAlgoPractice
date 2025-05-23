public class Tribonacci {

    /**
     * https://leetcode.com/problems/n-th-tribonacci-number/description/
     * */

    public int tribonacci(int n) {
        int prev = 0;
        int prev1 = 1;
        int prev2 = 1;
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        for(int i=3; i<=n; i++) {
            int cur = prev + prev1 + prev2;
            prev = prev1;
            prev1 = prev2;
            prev2 = cur;
        }
        return prev2;
    }
}
