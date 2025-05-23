import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {
    public static void main(String[] args) {
        System.out.println(connectSticks (new int[]{25,25,25,26,27,29}));
    }
    public static int connectSticks(int[] sticks) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b-a));
            for(int i: sticks){
                queue.offer(i);
            }

            int cost;
            int sum =0;
            while(queue.size()>1){

                cost = queue.poll() + queue.poll();
                sum+= cost;
                queue.offer(cost);
            }
            return sum;
        }
    }
