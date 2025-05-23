public class MaxPoints {

    /**
     * https://leetcode.com/problems/maximum-number-of-points-with-cost/description/
     * */


    public long maxPoints(int[][] points) {
        long[] prev = new long[points[0].length];
        long currMax = Long.MIN_VALUE;
        for (int i = 0; i < points[0].length; i++) {
            prev[i] = points[0][i];
            currMax = Math.max(currMax, prev[i]);
        }
        for (int i = 1; i < points.length; i++) {
            long[] cur = new long[points[i].length];

            for(int j = 0; j < points[i].length; j++) {
                long max = Long.MIN_VALUE;
                for (int k = 0; k < prev.length; k++) {
                    max = Math.max(max, prev[k] - Math.abs(k- j));
                }
                cur[j] = max + points[i][j];
                currMax = Math.max(currMax, cur[j]);
            }
            prev = cur;
        }
        return currMax;
    }
    public static void main(String[] args) {
        MaxPoints maxPoints = new MaxPoints();
        int[][] points = new int[][]{{1}};
        System.out.println(maxPoints.maxPoints(points));
    }
}
