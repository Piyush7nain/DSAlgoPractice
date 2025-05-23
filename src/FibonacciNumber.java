public class FibonacciNumber {

    /**
     * https://leetcode.com/problems/fibonacci-number/description/
     * */

    public int fib(int n) {
        if(n == 1) return 1;
        if(n == 0) return 0;
        int prev = 1;
        int prevPrev = 0;
        for(int i = 2; i <= n; i++) {
            int cur = prev + prevPrev;
            prevPrev = prev;
            prev = cur;
        }
        return prev;
    }
}
