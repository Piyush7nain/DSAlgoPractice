import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible {
    //https://leetcode.com/problems/as-far-from-land-as-possible/

    public int maxDistance(int[][] grid) {

        int result = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size && !queue.isEmpty(); i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                for (int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 0) {
                        queue.add(new int[]{newX, newY});
                        grid[newX][newY] = 1;
                    }
                }
            }
            result++;
        }
        return result;
    }

}
