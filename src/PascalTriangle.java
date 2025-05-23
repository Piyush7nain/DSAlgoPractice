import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    /**
     * https://leetcode.com/problems/pascals-triangle/description/
     * */

    public List<List<Integer>> generate(int numRows) {
        if(numRows == 0) return new ArrayList<List<Integer>>();
        if(numRows == 1){
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> row = new ArrayList<>();
            row.add(1);
            ans.add(row);
            return ans;
        }
        List<List<Integer>> prev = generate(numRows -1);
        List<Integer> row = new ArrayList<>();
        row.add(1);
        List<Integer> prevRow = prev.get(prev.size()-1);
        for(int i = 1; i < numRows-1; i++){
            row.add(prevRow.get(i-1) + prevRow.get(i));
        }
        row.add(1);
        prev.add(row);
        return prev;
    }

    public List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0){
            return new ArrayList<>(List.of(1));
        }
        List<Integer> row = getRow(rowIndex-1);
        List<Integer> newRow = new ArrayList<>();
        newRow.add(1);
        int i = 1;
        while(i <= rowIndex-1){
            newRow.add(row.get(i-1) + row.get(i));
            i++;
        }
        newRow.add(1);
        return newRow;
    }

    public static void main(String[] args) {
        PascalTriangle pt = new PascalTriangle();
        System.out.println(pt.generate(5));
        System.out.println(pt.getRow(3));
    }
}
