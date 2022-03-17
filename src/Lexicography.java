import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Lexicography {


    public static void main(String[] args) {
        //System.out.println(lexicographicOrderOfString("bca"));
       /* System.out.println(
                lexicographicOrderOfString(nextLexicographicString("string")) -lexicographicOrderOfString("string")
        );*/
        System.out.println(
               lexicographicOrderOfString("inj") -lexicographicOrderOfString("jin")
        );
        //System.out.println(nextLexicographicString("string"));

    }

    static String nextLexicographicString(String str){

        TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
        char[] chars = str.toCharArray();
        map.put(chars[chars.length-1], chars.length-1);
        for(int i = chars.length -2; i>=0;i--){
            char c = chars[i];
            Map.Entry<Character, Integer> ceiling = map.ceilingEntry(c);
            if(ceiling!=null){


            }
        }
        return String.copyValueOf(chars);
    }
    static void shiftRight(char[] chars, int ind){

        if (chars.length - 1 - ind >= 0) System.arraycopy(chars, ind, chars, ind + 1, chars.length - 1 - ind);

    }
    static int lexicographicOrderOfString(String str){

        int len = str.length();
        int fact = factorial(len);
        int[] indexes = new int[256];
        int mul = fact;
        fillIndexes(indexes, str.toCharArray());
        int sum = 1;
        for(int i =0 ; i< len;i++){
            mul = mul/(len-i);
            int ind = indexes[str.charAt(i)-1];
            sum+= ind*mul;
            updateCount(indexes, str.charAt(i));
        }
        return sum;
    }

    private static void fillIndexes(int[] indexes, char[] chars){

        for(char c : chars)
            indexes[c] +=1;
        for(int i = 1; i < indexes.length;i++)
            indexes[i] += indexes[i-1];

    }
    static void updateCount(int[] count, char ch)
    {
        int i;
        for (i = ch; i < count.length; ++i)
            --count[i];
    }
    private static int factorial(int len) {
        if(len ==0)
            return 1;
        return len*factorial(len-1);
    }

}
