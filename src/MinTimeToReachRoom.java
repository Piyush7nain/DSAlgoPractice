import java.util.Comparator;
import java.util.PriorityQueue;

public class MinTimeToReachRoom {

    /**
     * https://leetcode.com/problems/find-minimum-time-to-reach-last-room-i/
     * */

    int[][] visited;
    int minTime = Integer.MAX_VALUE;
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] rooms;
    public int minTimeToReach(int[][] rooms) {
        if(rooms.length == 0 || rooms[0].length == 0) return 0;
        visited = new int[rooms.length][rooms[0].length];
        this.rooms = rooms;
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        queue.add(new int[]{0, 0, 0});
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            int time = curr[2];
            if(time >= visited[row][col]){
                continue;
            }
            if(time <visited[row][col]){
                visited[row][col] = time;
            }
            if(row == rooms.length - 1 && col == rooms[0].length - 1) {
                return time;
            }

            for(int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if( newRow >=0 && newRow < visited.length && newCol >=0 && newCol < visited[0].length && visited[newRow][newCol] == Integer.MAX_VALUE) {
                    int newTime = Math.max(rooms[newRow][newCol], time) + 1;
                    queue.add(new int[]{newRow, newCol, newTime});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MinTimeToReachRoom room = new MinTimeToReachRoom();
        System.out.println(room.minTimeToReach(new int[][]{
                {80, 182, 86, 187, 186,2,169,149},
                {197, 90, 123,236,  35,13,173,191},
                {218,167, 166, 43, 198,102,166,58},
                {31, 125,   7,  1,  16,35,46,113},
                {81,  72, 129,156, 175,69,151,57},
                {186, 62,  79, 151,66,11,198,242}}));
    }
}
