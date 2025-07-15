import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    //https://leetcode.com/problems/rotting-oranges/description/

    public int orangesRotting(int[][] grid) {
        var visited = grid;
        int ans = 0;
        int fresh =0;
        Queue<Integer[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Integer[]{i, j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if(fresh == 0){
            return 0;
        }
        if(queue.isEmpty()){
            return -1;
        }
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;
            for (int i = 0; i < size && !queue.isEmpty(); i++) {
                Integer[] location = queue.poll();
                for (int[] direction : directions) {
                    int x = location[0] + direction[0];
                    int y = location[1] + direction[1];
                    if( x >=0 && x < grid.length && y >=0 && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.add(new Integer[]{x, y});
                        fresh--;
                        if(fresh == 0){
                            return ans;
                        }
                    }
                }

            }
        }
        return -1;
    }
}
