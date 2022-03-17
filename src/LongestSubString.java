import java.util.HashMap;
import java.util.Map;

//Given a string s, find the length of the longest substring without repeating characters.
public class LongestSubString {

    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty())
            return 0;
        int maxL =0 ;
        int back = 0; int front = back;
        Map<Character, Integer> set = new HashMap<>();
        int len = s.length();
        while(front<len){
            if(set.containsKey(s.charAt(front))){
                back = Math.max(back, set.get(s.charAt(front)));
            }
            maxL = Math.max(maxL, front -back +1);
            set.put(s.charAt(front), front+1);
            front++;
        }
        return maxL;
    }
}
