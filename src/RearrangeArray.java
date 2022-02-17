import java.util.Arrays;

public class RearrangeArray {

    public static void main(String[] args) {

        long[] arr = new long[]{5,0, 3, 7, 1, 4, 6, 2};
        int remainingSwaps = arr.length;
        for(int i =0;  i<arr.length;i++)
            if(i == arr[i]) remainingSwaps--;

        swap(arr, 0, remainingSwaps);
        for (long i :arr) {
            System.out.println(i);
        }
    }
    static long startIndex = -1;
    static long startValue = -1;

    static void swap(long[] arr, long nextIndex, int remainingSwaps) {

        if (remainingSwaps == 0) return;

        if (startIndex != -1 && arr[(int) nextIndex] == startIndex) {
            long store = arr[(int) nextIndex];
            arr[(int) nextIndex] = startValue;
            startIndex = -1;
            startValue = -1;
            nextIndex = store;
            swap(arr, nextIndex, --remainingSwaps);
            return;
        }
        if (arr[(int) nextIndex] == nextIndex) {
            swap(arr, ++nextIndex, remainingSwaps);
        } else {
            if (startIndex == -1) {
                startIndex = nextIndex;
                startValue = arr[(int) nextIndex];
            }
            long store = arr[(int) nextIndex];
            arr[(int) nextIndex] = arr[(int) store];
            nextIndex = store;
            swap(arr, nextIndex, --remainingSwaps);
        }

    }
}
