import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumMeetingRooms {

    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);

        PriorityQueue<int[]> rooms = new PriorityQueue<>((a, b) -> a[1]-b[1]);

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
