import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class KClosestPoints {
    public static void main(String[] args) {
        kClosest(new int[][]{{3,3},{5,-1},{-2,4}}, 2);
    }
    public static int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Double[]> pq = new PriorityQueue<>(new Comparator<Double[]>(){
            @Override
            public int compare(Double[] a, Double[] b){
                return a[1].compareTo(b[1]);
            }
        });
        for(int i =0; i<points.length; i++){
            Double distance = Math.sqrt( points[i][0]*points[i][0] + points[i][1]*points[i][1]);
            Double[] point = new Double[]{Double.valueOf(i), distance};
            pq.offer(point);
        }
        int[][] ans = new int[k][2];
        for(int i =0;i<k;i++){
            ans[i] = points[pq.poll()[0].intValue()];
        }
        return ans;
    }
}
