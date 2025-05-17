public class DivisorGame {

    /**
     * https://leetcode.com/problems/divisor-game/description/
     * */

    int[] dp;
    public boolean divisorGame(int N) {
        if(dp==null){
            dp = new int[N+1];
        }
        if(N==1) return false;
        if(dp[N]!=0) return dp[N]==1;
        boolean ans= false;
        for(int i=1;i<N;i++) {
            if(N%i==0 && !ans) {
                ans = ans || !divisorGame(N-i);
            }
        }
        if(ans) dp[N]=1;
        else dp[N]=-1;
        return ans;
    }

    public static void main(String[] args) {
        DivisorGame game = new DivisorGame();
        System.out.println(game.divisorGame(196));
    }
}
