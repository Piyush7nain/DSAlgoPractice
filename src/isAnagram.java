import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
 *
 * An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
 * Input: s = "racecar", t = "carrace"
 *
 * Output: true
 * */
public class isAnagram {

    public static boolean isAnagram(String s, String t){
        if(s.length()!= t.length())
            return false;

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for(int i =0;i<s.length();i++){
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0)+1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0)+1);
        }
        for(char a: sMap.keySet()){
            if (sMap.get(a)!=tMap.getOrDefault(a, 0))
                return false;
        }
        return true;

    }

    public boolean isAnagramConstantSpace(String s, String t){
        if(s.length()!=t.length()) return false;

        int[] store = new int[26]; // array with all zero
        for (int i=0;i<s.length();i++){
            store[s.charAt(i)-'a']++; // will increase the char count by 1
            store[t.charAt(i)-'a']--; // will decrease the char count by 1
        }

        for(int i:store)
            if (i!=0) return false;

        return true;
    }

}
