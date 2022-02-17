public class KlargestNumbers {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        Solution sol = new Solution();
        sol.printArray(sol.kLargest(arr, arr.length, 3));
    }
}
class Solution{

    int[] kLargest ( int[] arr, int n, int k){
        int[] retArr = new int[k];
        buildHeap(arr);
        for (int i = 1; i <= k; i++)
            retArr[i-1] = deleteMin(arr, n - i);
        return retArr;
    }

    int deleteMin ( int[] arr, int lastIndex){

        int ret = arr[0];
        arr[0] = arr[lastIndex];
        lastIndex--;
        heapify(arr, 0, lastIndex);
        return ret;
    }

    void buildHeap ( int[] arr){
        for (int i = (arr.length - 1) / 2; i >= 0; i--)
            heapify(arr, i, arr.length - 1);
        printArray(arr);
    }
    void printArray ( int[] arr){
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
    void heapify ( int[] arr, int i, int lastIndex){
        if (getLeftChild(i) > lastIndex) return;

        else if (getRightChild(i) > lastIndex) {
            if (arr[getLeftChild(i)] > arr[i]) {
                int temp = arr[i];
                arr[i] = arr[getLeftChild(i)];
                arr[getLeftChild(i)] = temp;
                heapify(arr, getLeftChild(i), lastIndex);
            }
        } else {
            int index = getSwitchIndex(arr, i);
            if (arr[index] > arr[i]) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                heapify(arr, index, lastIndex);
            }
        }
    }
    int getSwitchIndex ( int[] arr, int i){
        int ret = i;
        int leftChild = arr[getLeftChild(i)];
        int rigthChild = arr[getRightChild(i)];

        if (leftChild >= rigthChild)
            ret = getLeftChild(i);
        else
            ret = getRightChild(i);
        return ret;
    }
    int getParent ( int i){
        return i / 2;
    }
    int getLeftChild ( int i){
        return (2 * i + 1);
    }
    int getRightChild ( int i){
        return (2 * i + 2);
    }
}
