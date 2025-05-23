import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {

    /**
     * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word.
     * Return all such possible sentences in any order.
     *
     * Note that the same word in the dictionary may be reused multiple times in the segmentation.
     *
     * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
     * Output: ["cats and dog","cat sand dog"]
     * */

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String word: wordDict)
            set.add(word);

        List<String> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();

        search(set, 0, s.toCharArray(), curr, ans);
        return ans;
    }

    void search(Set<String> set, int start, char[] carr, List<String> curr, List<String> ans){
        if(start>= carr.length){
            if(curr.size()>0){
                ans.add(String.join(" ", curr));
            }
            return;
        }
        int j = start;
        StringBuilder sb = new StringBuilder();
        while(j<carr.length){
            sb.append(carr[j]);
            if(set.contains(sb.toString())){
                curr.add(sb.toString());
                search(set, j+1, carr, curr, ans);
                curr.remove(curr.size()-1);
            }
            j++;
        }
    }
}
