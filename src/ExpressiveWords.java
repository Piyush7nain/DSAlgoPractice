import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ExpressiveWords {

    /**
     * https://leetcode.com/problems/expressive-words/description/
     * */

    public int expressiveWords(String s, String[] words) {
        List<List<Character>> elist = getSplitString(s);
        System.out.println(elist);
        int ans =0;
        for( String word : words) {
            List<List<Character>> temp = getSplitString(word);
            System.out.println(temp);
            boolean can = true;
            if(temp.isEmpty() || temp.size() != elist.size()){
                continue;
            }
            for(int i =0; i< temp.size(); i++){
                List<Character> temp1 = temp.get(i);
                List<Character> temp2 = elist.get(i);
                if(temp1.get(0) != temp2.get(0)){
                    can = false;
                    break;
                }else if( temp1.size() > temp2.size()){
                    can = false;
                    break;
                }else if( temp1.size() < temp2.size() && temp2.size() == 2){
                    can = false;
                    break;
                }
            }
            if(can){
                ans++;
            }
        }
        return ans;
    }

    List<List<Character>> getSplitString(String word){
        List<List<Character>> list = new ArrayList<>();
        if(word.isEmpty()){
            return list;
        }
        List<Character> currChars = new ArrayList<>();
        currChars.add(word.charAt(0));
        for(int i = 1; i < word.length(); i++){
            if(word.charAt(i) == word.charAt(i-1)){
                currChars.add(word.charAt(i));
            }else{
                list.add(currChars);
                currChars = new ArrayList<>();
                currChars.add(word.charAt(i));
            }
        }
        list.add(currChars);
        return list;
    }
    public static void main(String[] args) {
        ExpressiveWords expressiveWords = new ExpressiveWords();
        System.out.println(expressiveWords.expressiveWords("sass", new String[]{"sa"}));
    }
}
