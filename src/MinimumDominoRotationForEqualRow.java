import java.util.Arrays;

public class MinimumDominoRotationForEqualRow {

    /**
     * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/description/
     * */

    public int minDominoRotations(int[] tops, int[] bottoms) {
        if(tops.length == 0 || bottoms.length == 0) return -1;
        if(tops.length == 1 || bottoms.length == 1) return 0;
        int t1 = startSwaps(tops, bottoms, tops[0], 0);
        int t2 = startSwaps(tops, bottoms, bottoms[0], 1);
        int b1 = startSwaps(bottoms, tops, bottoms[0], 0);
        int b2 = startSwaps(bottoms, tops, tops[0], 1);

        int ans =  Math.min(t1, Math.min(t2, Math.min(b2, b1)));
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;

    }

    int startSwaps(int[] t, int[] b, int startValue, int swaps){
        int n = t.length;
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++) {
            if(t[i] == startValue) {
                continue;
            }else if(b[i] == startValue){
                swaps += 1;
            }else{
                return ans;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        MinimumDominoRotationForEqualRow minimumDominoRotationForEqualRow = new MinimumDominoRotationForEqualRow();
        System.out.println(minimumDominoRotationForEqualRow.minDominoRotations(
                new int[]{6,1,2,4,2,2},
                new int[]{5,2,6,2,3,2}
        ));
    }
}
