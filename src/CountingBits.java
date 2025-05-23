import java.util.Arrays;

public class CountingBits {

    /**
     * https://leetcode.com/problems/counting-bits/
     * */
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        int lastTwoPower = 1;
        for (int i = 1; i <= n; i++) {
            if(lastTwoPower*2 == i){
                lastTwoPower = i;
            }
            result[i] = 1 + result[i - lastTwoPower];
        }
        return result;
    }

    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();
        System.out.println(Arrays.toString(countingBits.countBits(5)));
    }
}

