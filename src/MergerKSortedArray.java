import java.util.ArrayList;

public class MergerKSortedArray {

    public static void main(String[] args) {

        int[][] arr = {{27, 41, 51, 100}, {120, 307, 690, 3000}, {30, 31, 83, 100}, {3, 24, 36, 68}};
        ArrayList<Integer> arrayList = MergerKSortedArraySolution.mergeKArrays(arr, 4);
        MergerKSortedArraySolution.print(arrayList.stream().mapToInt(i -> i).toArray());
    }

}

class MergerKSortedArraySolution {

    public static void print(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        int[] heap = new int[K * K];
        int lastIndex = 0;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++)
                lastIndex = heapInsert(heap, arr[i][j], lastIndex);
        }
        print(heap);
        ArrayList<Integer> retArr = new ArrayList<Integer>();
        for (int i = 0; i < K * K; i++) {
            lastIndex--;
            retArr.add(heapDeleteMin(heap, lastIndex));

        }

        return retArr;
    }

    static int heapDeleteMin(int[] heap, int lastIndex) {
        int ret = heap[0];
        heap[0] = heap[lastIndex];
        lastIndex--;
        heapify(heap, 0, lastIndex);
        return ret;
    }

    static void heapify(int[] arr, int index, int lastIndex) {

        if (leftChild(index) > lastIndex) return;
        else if (rigthChild(index) > lastIndex) {
            if (arr[leftChild(index)] < arr[index]) {
                int temp = arr[index];
                arr[index] = arr[leftChild(index)];
                arr[leftChild(index)] = temp;
                heapify(arr, leftChild(index), lastIndex);
            }
        } else {
            int exchange = switchIndex(arr, index);
            if (arr[exchange] < arr[index]) {
                int temp = arr[index];
                arr[index] = arr[exchange];
                arr[exchange] = temp;
                heapify(arr, exchange, lastIndex);
            }
        }

    }

    static int switchIndex(int[] arr, int i) {

        int rigthChild = arr[rigthChild(i)];
        int leftChild = arr[leftChild(i)];
        if (rigthChild < leftChild) return rigthChild(i);
        else return leftChild(i);

    }

    static int rigthChild(int i) {
        return (i * 2 + 2);
    }

    static int leftChild(int i) {
        return (i * 2 + 1);
    }

    static int heapInsert(int[] heap, int e, int lastIndex) {
        heap[lastIndex] = e;
        bubbleUp(heap, lastIndex);
        return ++lastIndex;
    }

    static void bubbleUp(int[] arr, int index) {
        int parent = (index - 1) / 2;
        if (arr[parent] > arr[index]) {
            int temp = arr[parent];
            arr[parent] = arr[index];
            arr[index] = temp;
            bubbleUp(arr, parent);
        }
    }
}
