import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWords {

    //https://leetcode.com/problems/concatenated-words/description/

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, Comparator.comparing(s -> s.length()));
        List<String> result = new ArrayList<>();
        int minUniqueLength = words[0].length();
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        System.out.println(words.length);
        for(int i = 1; i < words.length; i++) {
            if(words[i].length() >= 2*minUniqueLength) {
                StringBuilder sb = new StringBuilder();
                boolean concatenated = isConcatenated(words[i], set, 0, new Boolean[words[i].length()]);
                if(concatenated){
                    result.add(words[i]);
                }
            }
            set.add(words[i]);
        }
        return result;
    }
    private boolean isConcatenated(String word, Set<String> set, int startIndex, Boolean[] memo){
        if(set.contains(word.substring(startIndex))){
            memo[startIndex] = true;
//            set.add(word.substring(startIndex));
            return true;
        }
        if(memo[startIndex]!= null){
            return memo[startIndex];
        }
        for(int i = startIndex; i <= word.length(); i++) {
            String sub = word.substring(startIndex, i);
            if(set.contains(sub)){
               if( isConcatenated(word, set, i, memo)){
//                   set.add(word.substring(i));
                   memo[startIndex] = true;
                   return true;
               }
           }
        }
        memo[startIndex] = false;
        return false;
    }

    public static void main(String[] args) {
        ConcatenatedWords concatenatedWords = new ConcatenatedWords();
        System.out.println(concatenatedWords.findAllConcatenatedWordsInADict(
                new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"}
        ));
    }
}
