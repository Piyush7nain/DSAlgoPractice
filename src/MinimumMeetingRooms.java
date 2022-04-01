import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumMeetingRooms {

    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }
        });

        PriorityQueue<int[]> rooms = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[1]-b[1];
            }
        });

        for(int[] meeting : intervals){

            if(rooms.isEmpty())
                rooms.offer(meeting);
            else{

                if(rooms.peek()[1]<=meeting[0]){
                    rooms.poll();
                }
                rooms.offer(meeting);
            }

        }
        return rooms.size();


    }
}
