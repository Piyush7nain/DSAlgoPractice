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

    public static void main(String[] args) {
        PascalTriangle pt = new PascalTriangle();
        System.out.println(pt.generate(5));
    }
}
