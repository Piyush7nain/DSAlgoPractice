import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SubStringWithConcatinationOfWords {
    /**
     * You are given a string s and an array of strings words. All the strings of words are of the same length.
     * A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.
     * For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab"
     * are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any
     * permutation of words.
     * Return an array of the starting indices of all the concatenated substrings in s.
     * You can return the answer in any order.
     *
     * Example 1:
     * Input: s = "barfoothefoobarman", words = ["foo","bar"]
     * Output: [0,9]
     * Explanation:
     * The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
     * The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
     *
     * Example 2:
     * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
     * Output: []
     * Explanation:
     * There is no concatenated substring.
     *
     * Example 3:
     * Input: s = "barfoofoobarthemanfoobarman", words = ["bar","foo","the"]
     * Output: [6,9,12]
     * Explanation:
     * The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
     * The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
     * The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].*/
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        int[] charMap = new int[26];
        int matchLength = 0;
        for (String word : words) {
            for(char c : word.toCharArray()) {
                charMap[c - 'a']++;
                matchLength++;
            }
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        String charMapString = Arrays.toString(charMap);
        int sLen = s.length();
        int left = 0;
        int right = 0;
        int[] charMatchMap = new int[26];
        while(right < sLen) {
            if(charMap[s.charAt(right)-'a'] == 0) {
                right++;
                left =right;
                charMatchMap= new int[26];
                continue;
            }
            charMatchMap[s.charAt(right)-'a']++;
            if(right-left+1 < matchLength){
                right++;
            } else{
                String matchString = s.substring(left, right+1);
                if(set.contains(matchString)
                        || ( charMapString.equals(Arrays.toString(charMatchMap)) && matchEachWord(s, words, new HashMap<>(map), left))){
                    result.add(left);
                    set.add(matchString);
                }
                right++;
                charMatchMap[s.charAt(left)-'a']--;
                left++;
            }
        }
        return result;
    }
    boolean matchEachWord(String s, String[] words, Map<String, Integer> map, int left){
        int start = left;
        int end = left + words[0].length();
        int wordMatches =0;
        for(int i = 0; i < words.length; i++){
            String word = s.substring(start, end);
            if(map.containsKey(word)&&map.get(word)>0){
                wordMatches++;
                map.put(word, map.get(word)-1);
                start += word.length();
                end += word.length();
            }else return false;
        }
        if(wordMatches == words.length){return true;}
        else{return false;}
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        SubStringWithConcatinationOfWords cls = new SubStringWithConcatinationOfWords();
        System.out.println(cls.findSubstring(s, words));
    }
}
