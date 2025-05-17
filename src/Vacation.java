import java.util.Arrays;
import java.util.Scanner;

public class Vacation {

    /**
     * https://codeforces.com/problemset/problem/699/C
     * */

    /**
     * ai equals 0, if on the i-th day of vacations the gym is closed and the contest is not carried out;
     * ai equals 1, if on the i-th day of vacations the gym is closed, but the contest is carried out;
     * ai equals 2, if on the i-th day of vacations the gym is open and the contest is not carried out;
     * ai equals 3, if on the i-th day of vacations the gym is open and the contest is carried out.
     * */
    public int vacation2(int N, int[] activities){

        int[] prevDay = new int[3];
        for(int i = 1; i <= activities.length; i++){
            int[] today = new int[3];
            //if decides to rest today
            today[0] = 1 + Math.min(prevDay[0], Math.min(prevDay[1], prevDay[2]));

            // if decides to code
            today[1] = Integer.MAX_VALUE;
            if(activities[i-1] == 1 || activities[i-1] == 3){
                today[1] = Math.min(today[1], prevDay[2]);
                today[1] = Math.min(today[1], prevDay[0]);
            }
            //if decides to go to gym
            today[2] = Integer.MAX_VALUE;
            if(activities[i-1] == 2 || activities[i-1] == 3){
                today[2] = Math.min(today[2], prevDay[1]);
                today[2] = Math.min(today[2], prevDay[0]);
            }
            prevDay = today;
        }

        return Math.min(prevDay[0], Math.min(prevDay[1], prevDay[2]));
    }

    public int vacation(int N, int[] activities){
        int[][] dp = new int[N+1][3];
        for(int i = 1; i <= N; i++){
            Arrays.fill(dp[i], -1);
        }
        return rec(1, 0, activities, dp);
    }

    private int rec(int dayIndex, int lastActivity, int[] activities, int[][] dp){
        if(dayIndex == activities.length+1){
            return 0;
        }
        if(dp[dayIndex][lastActivity] != -1){
//            System.out.println("Found duplicate activity for day " + (dayIndex-1) + ", lastActivity: " + lastActivity);
            return dp[dayIndex][lastActivity];
        }

        int minRest = Integer.MAX_VALUE;

        // Option 0: Rest
        int rest= rec(dayIndex + 1, 0, activities, dp)+1;
        minRest = Math.min(minRest, rest);
        //if decides to contest
        if(activities[dayIndex-1] == 1 || activities[dayIndex-1] == 3){
            if(lastActivity != 1){
                minRest = Math.min(minRest, rec(dayIndex + 1, 1, activities, dp));
            }
        }

        //if decides to go to gym
        if(activities[dayIndex-1] == 2 || activities[dayIndex-1] == 3){
            if(lastActivity != 2){
                minRest = Math.min(minRest, rec(dayIndex + 1, 2, activities, dp));
            }
        }

        dp[dayIndex][lastActivity] = minRest;
        return dp[dayIndex][lastActivity];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] activities = new int[n];
        for (int i = 0; i < n; i++) {
            activities[i] = scanner.nextInt();
        }
        scanner.close();
        Vacation vacation = new Vacation();
//        System.out.println(vacation.vacation(n, activities));
//        int[] activities = new int[]{1,3,2,0};
        System.out.println(vacation.vacation(n,activities));

    }
}
