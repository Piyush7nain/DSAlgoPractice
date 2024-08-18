import java.util.Arrays;
import java.util.Collections;

public class Search2DMatrix {
/**
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix.
 * This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 *
 * Example 1:
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * Output: true
 *
 * Example 2:
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * Output: false
 *
 *
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matrix[i][j] <= 109
 * All the integers in each row are sorted in ascending order.
 * All the integers in each column are sorted in ascending order.
 * -109 <= target <= 109
 * */
    static boolean found =false;
    static boolean initialize=true;
    static int startRow;
    static int startCol;
    static int endRow;
    static int endCol;
    //Binary search elements on matrix recursively looking for right range of indexes boxing target.
    //Works for rectangle as well as square matrix.
    public static boolean searchMatrix(int[][] matrix, int target){
        if(initialize){
            startRow=0;
            startCol=0;
            endRow=matrix.length-1;
            endCol=matrix[0].length-1;
            found=false;
            initialize=false;
        }
        if(found)
            return true;
        if(startRow>endRow){
            return false;
        }
        if((endRow==startRow)&&(endCol==startCol)){
            if(matrix[startRow][startCol]==target)
                return true;
            else return false;
        }
        int row   =0;
        int col   =1;
        int start =0;
        int end   =1;

        removeRowAndCol(matrix, target, row, start);
        if(found) return true;
        removeRowAndCol(matrix, target, col, start);
        if(found) return true;
        removeRowAndCol(matrix, target, row, end);
        if(found) return true;
        removeRowAndCol(matrix, target, col, end);
        if(found) return true;

        return searchMatrix(matrix, target);

    }
    static void removeRowAndCol(int[][] matrix, int target, int rowCol, int startEnd){

        if(rowCol==0&&startEnd==0){
            //remove all rows with start elements > target
            int start = startRow; int end = endRow;
            while(start<=end){
                int mid = (start+ end)/2;
                int num = matrix[mid][startCol];
                if(num==target){
                    found=true;
                    return;
                }else if(num<target){
                    start = mid+1;
                }else {
                    end = mid-1;
                }
            }
            endRow = end;
        }
        else if(rowCol==0&&startEnd==1){
            //remove all row with ending < target.
            int start = startRow; int end = endRow;
            while(start<=end){
                int mid = (start+ end)/2;
                int num =matrix[mid][endCol];
                if(num==target){
                    found=true;
                    return;
                }else if(num<target){
                    start = mid+1;
                }else {
                    end = mid-1;
                }
            }
            startRow = start;
        }
        else if(rowCol==1&&startEnd==0){
            //remove all cols with start elements > target
            int start = startCol; int end = endCol;
            while(start<=end){
                int mid = (start+ end)/2;
                int num= matrix[startRow][mid];
                if(num==target){
                    found=true;
                    return;
                }else if(num<target){
                    start = mid+1;
                }else {
                    end = mid-1;
                }
            }
            endCol = end;
        }
        else if(rowCol==1&&startEnd==1){
            //remove all rows with end elements < target
            int start = startCol; int end = endCol;
            while(start<=end){
                int mid = (start+ end)/2;
                int num=matrix[endRow][mid];
                if(num==target){
                    found=true;
                    return;
                }else if(num<target){
                    start = mid+1;
                }else {
                    end = mid-1;
                }
            }
            startCol = start;
        }
    }
    // Start from top right. Compare element.
    // if element bigger than target, move left. if Element lesser that target, move done
    // Works for only square matrix
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i =m-1; int j=0;
        while(i>=0 && j <n){
            if(matrix[i][j]==target)
                return true;
            if(matrix[i][j]>target)
                i--;
            else
                j++;
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 14;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.println("Searching for "+matrix[i][j]+ ", found ="+ searchMatrix(matrix, matrix[i][j]));
                initialize=true;
            }
        }
        System.out.println("Searching for "+25+ ", found ="+ searchMatrix(matrix, 25));
        System.out.println("Searching for "+45+ ", found ="+ searchMatrix(matrix, 45));
        System.out.println("Searching for "+-1+ ", found ="+ searchMatrix(matrix, -1));
    }
}
