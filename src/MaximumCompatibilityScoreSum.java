import java.util.Arrays;

public class MaximumCompatibilityScoreSum {

    /**
     * https://leetcode.com/problems/maximum-compatibility-score-sum/description/
     * */
    int maxCompatibilityScore =0;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int ans = 0;
        int[][] compatibilities = new int[students.length][mentors.length];
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < mentors.length; j++) {
                compatibilities[i][j] = compatibility(students[i], mentors[j]);
            }
        }

        /*for(int i = 0; i < students.length; i++){
            int[] mentorTaken = new int[students.length];
            backTrack(0, 0, compatibilities, mentorTaken);
            return maxCompatibilityScore;
        }*/

        int[] dp = new int[1 << students.length];
        Arrays.fill(dp, -1);
        return backTrackBitMap(0, 0, dp, compatibilities);

    }

    int backTrackBitMap(int state, int index, int[] dp,  int[][] compatibilities){
        if(index == compatibilities.length){
            return 0;
        }

        if(dp[state] != -1){
            return dp[state];
        }
        int max = 0;

        for(int i = 0; i < compatibilities.length; i++){
            if(((state >> i) & 1)!=1){
                max = Math.max(max, compatibilities[index][i] + backTrackBitMap(state | 1<<i, index + 1, dp, compatibilities));
            }
        }
        dp[state] = max;
        return max;
    }
    void backTrack(int currentScore, int index, int[][] compatibilities, int[] mentorTaken) {
        if(index == compatibilities.length){
            maxCompatibilityScore = Math.max(maxCompatibilityScore, currentScore);
            return;
        }
        int[] compatibility = compatibilities[index];
        for(int i = 0; i < compatibility.length; i++){
            if(mentorTaken[i] == 0){
                mentorTaken[i] = 1;
                backTrack(currentScore + compatibility[i], index +1, compatibilities, mentorTaken);
                mentorTaken[i] = 0;
            }
        }
    }
    int compatibility(int[] student, int[] mentor){
        int sum = 0;
        for(int i=0; i<student.length; i++){
            sum += student[i]==mentor[i]?1:0;
        }
        return sum;
    }

    public static void main(String[] args) {
        MaximumCompatibilityScoreSum maximumCompatibilityScoreSum = new MaximumCompatibilityScoreSum();
        int[][] students = new int[][]{{1,1,0},{1,0,1},{0,0,1}};
        int[][] mentors = new int[][]{{1,0,0},{0,0,1},{1,1,0}};
        System.out.println(maximumCompatibilityScoreSum.maxCompatibilitySum(students, mentors));
    }
}
