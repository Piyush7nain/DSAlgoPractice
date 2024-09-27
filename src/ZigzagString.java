import java.util.ArrayList;
import java.util.List;

public class ZigzagString {
    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows
     * like this: (you may want to display this pattern in a fixed font for better legibility)
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"*/
    public String convert(String s, int numRows) {

        List<List<Character>> mat = new ArrayList<>(numRows);
        for(int i = 0; i < numRows; i++)  {
            mat.add(new ArrayList<Character>());
        }
        int dir = 0;//down
        int row = 0;
        char[] chars = s.toCharArray();
        for(char c: chars){
            mat.get(row).add(c);
            if(dir ==0){
                row ++;
                if(row == numRows){
                    row = Math.max(0,row -2);
                    dir=1;
                }
            }else{
                row--;
                if(row ==-1){
                    dir =0;
                    row = Math.min(numRows-1, row + 2);
                }
            }

        }
        StringBuffer sb = new StringBuffer();
        for(List<Character> list : mat){
            for(Character c:list)
                sb.append(c);
        }
        return sb.toString();
    }
}
