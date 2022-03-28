import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxEvents {

    /**
     * We sort the array with the earliest starting date first.
     * Then for each entry, we add the end dates of all the events which have dates = starting date, with earliest closing date at top.
     * This top event is then attended on the starting date. All the rest of the events are kept in the queue.
     * We then remove all the dates in the queue which are earlier than the present day.
     * */
    public int maxEvents(int[][] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        Arrays.sort(A, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 0, res = 0, d = 0, n = A.length;// 11 14 22 34 44
        while (!pq.isEmpty() || i < n) {
            if (pq.isEmpty())
                d = A[i][0];//1
            while (i < n && A[i][0] <= d)
                pq.offer(A[i++][1]);//
            pq.poll();//44
            ++res; ++d;// 45
            while (!pq.isEmpty() && pq.peek() < d){
                pq.poll();
            }
        }
        return res;
    }
    public static void main(String[] args) {

        /*
        temp.maxEvents(new int[][]{{1,2},{1,2},{3,3}, {1,5}, {1,5}});*/
        MaxEvents temp = new MaxEvents();
        temp.maxEvents(new int[][]{{1,6},{2,3},{2,4}, {1,5}, {1,4}});
    }
}
