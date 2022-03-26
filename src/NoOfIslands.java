import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class NoOfIslands {

    public static void main(String[] args) {

        NoOfIslands temp = new NoOfIslands();
        char[][] arr = new char[][]{{'1','1','0','0','0'},
                                    {'1','1','0','0','0'},
                                    {'0','0','1','0','0'},
                                    {'0','0','0','1','1'}};
        System.out.println(temp.numIslands(arr));

    }
    char[][] grid;
    int[][] visited;
    int rowM;
    int colM;

    public int numIslands(char[][] g) {
        int ans=0;
        grid = g;
        rowM = grid.length;
        colM = grid[0].length;
        visited = new int[rowM][colM];
        for(int i=0;i<rowM; i++){
            for(int j = 0; j<colM; j++){
                System.out.println("{"+i+" "+j+"} :: Grid : " +grid[i][j] +" :: Visisted : "+visited[i][j]);
                if(grid[i][j]=='1' && visited[i][j]==0){
                    BFS(i,j);
                    ans++;
                }

            }
        }
        return ans;
    }

    void BFS(int i, int j){

        Queue<Integer[]> queue = new ArrayDeque<>();
        queue.add(new Integer[]{i,j});
        while(!queue.isEmpty()){
            Integer[] curr = queue.poll();
            visited[curr[0]][curr[1]]=1;
            if(hasLeft(curr).length!=0) queue.add(hasLeft(curr));
            if(hasRight(curr).length!=0)queue.add(hasRight(curr));
            if(hasTop(curr).length!=0)queue.add(hasTop(curr));
            if(hasBottom(curr).length!=0)queue.add(hasBottom(curr));
        }
    }
    private boolean rowRange(int i){

        return (i>=0 && i<rowM);
    }

    private boolean colRange(int i){

        return (i>=0 && i<colM);
    }
    private Integer[] hasLeft(Integer[] curr){

        int row = curr[0];
        int col = curr[1]-1;
        if(rowRange(row) && colRange(col) && grid[row][col]=='1' && visited[row][col]==0){
            return new Integer[]{row, col};
        }
        return new Integer[]{};
    }

    private Integer[] hasRight(Integer[] curr){

        int row = curr[0];
        int col = curr[1]+1;
        if(rowRange(row) && colRange(col) && grid[row][col]=='1' && visited[row][col]==0){
            return new Integer[]{row, col};
        }
        return new Integer[]{};
    }
    private Integer[] hasTop(Integer[] curr){

        int row = curr[0]-1;
        int col = curr[1];
        Integer[] arr = new Integer[]{row, col-1};
        if(rowRange(row) && colRange(col) && grid[row][col]=='1' && visited[row][col]==0){
            return arr;
        }
        return new Integer[]{};
    }
    private Integer[] hasBottom(Integer[] curr){

        int row = curr[0]+1;
        int col = curr[1];
        if(rowRange(row) && colRange(col) && grid[row][col]=='1' && visited[row][col]==0){
            return new Integer[]{row, col};
        }
        return new Integer[]{};
    }
}
