import java.util.*;

public class LetterCombinationOfNumber {

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
            return Arrays.asList();
        List<String> ans = new ArrayList<>();
        Map<Integer, List<Character>> map = new HashMap<>();
        initMap(map);
        int len = digits.length();
        char[] chars = digits.toCharArray();
        for(Character c: map.get(chars[0]-'0'))
            ans.add(Character.toString(c));
        for(int i = 1; i<len;i++ ){
            ans = merge(ans, map.get(chars[i]-'0'));
        }

        return ans;
    }

    List<String> merge(List<String> strs, List<Character> chars){
        List<String> temp = new ArrayList<>();
        for(Character c: chars){
            for(String s: strs)
                temp.add(s + c);
        }
        return temp;
    }
    void initMap(Map<Integer, List<Character>> map ){
        map.put(2, Arrays.asList('a','b','c'));
        map.put(3, Arrays.asList('d','e','f'));
        map.put(4, Arrays.asList('g','h','i'));
        map.put(5, Arrays.asList('j','k','l'));
        map.put(6, Arrays.asList('m','n','o'));
        map.put(7, Arrays.asList('p','q','r', 's'));
        map.put(8, Arrays.asList('t','u','v'));
        map.put(9, Arrays.asList('w','x','y','z'));

    }
}
