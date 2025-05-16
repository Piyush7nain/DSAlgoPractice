import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    /**
     * Given two strings s and t of lengths m and n respectively, return the minimum window
     * substring of s such that every character in t (including duplicates) is included in the window.
     *  If there is no such substring, return the empty string "".
     *
     * The testcases will be generated such that the answer is unique.
     *
     * Example 1:
     * Input: s = "ADOBECODEBANC", t = "ABC"
     * Output: "BANC"
     * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
     *
     *  Example 2:
     * Input: s = "a", t = "a"
     * Output: "a"
     * Explanation: The entire string s is the minimum window.
     *
     *  Example 3:
     * Input: s = "a", t = "aa"
     * Output: ""
     * Explanation: Both 'a's from t must be included in the window.
     * Since the largest window of s only has one 'a', return empty string.
     *
     *
     * Constraints:
     *
     * m == s.length
     * n == t.length
     * 1 <= m, n <= 105
     * s and t consist of uppercase and lowercase English letters.
     *
     * */

    public String minWindow(String s, String t) {
        if(s == null || t == null || s.isEmpty() || t.isEmpty()) return "";
        if(s.length()<t.length()) return "";
        int start = 0, end = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int p1 = 0, p2 = 0, min = Integer.MAX_VALUE;
        int match =0;
        while(p1 < s.length() && p2 <= s.length()) {
            if(p2==s.length()&& match!= t.length()) break;
            // move p2 until you find the complete match
            if(match<t.length()){
                if(map.containsKey(s.charAt(p2))) {
                    if(map.get(s.charAt(p2)) >0 ){
                        match++;
                    }
                    map.put(s.charAt(p2), map.get(s.charAt(p2)) - 1);
                }
                p2++;
            }else{

                if(map.containsKey(s.charAt(p1)) ) {
                    // if complete match is found, calculate min and move p1 to next char occ from t.
                    if(match==t.length()){
                        int len = p2 - p1;
                        if(len < min){
                            min = len;
                            start = p1;
                            end =p2;
                        }
                    }
                    map.put(s.charAt(p1), map.get(s.charAt(p1)) + 1);
                    // increase the match only when between p1 and p2 there is missing occurrence of char from t
                    if(map.get(s.charAt(p1)) >0 ){
                        match--;
                    }
                    // move p1 to next occ from t
                    p1++;
                    while(p1<s.length()&& !map.containsKey(s.charAt(p1)) ){
                        p1++;
                    }
                }else p1++;
            }
        }

        return s.substring(start, end);
    }

    boolean isSubString(String s, int[] actArr, int start, int end) {
        if(start >= end) return false;
        int[] compArr = new int[58];
        for(int i=start; i<end; i++) {
            compArr[s.charAt(i)-'A']++;
        }
        for(int i=0; i<actArr.length; i++) {
            if(actArr[i]<compArr[i]) return false;
        }
        return true;
    }
    int moveP2(int p2, String s, char c){
        while(p2<s.length() && s.charAt(p2)!=c) {
            p2++;
        }
        return p2;
    }
    int moveP1(int p1, String s, String t) {
        while(p1<s.length() && t.indexOf(s.charAt(p1))==-1) {
            p1++;
        }
        return p1;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring minWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
    }
}
