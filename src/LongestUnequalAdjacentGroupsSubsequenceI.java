import java.util.ArrayList;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequenceI {

    /**
     * https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i/description/
     * */

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        result.add(words[0]);
        int prev = groups[0];
        for (int i = 1; i < words.length; i++) {
            int current = groups[i];
            if (prev != current) {
                prev = current;
                result.add(words[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LongestUnequalAdjacentGroupsSubsequenceI obj = new LongestUnequalAdjacentGroupsSubsequenceI();
        System.out.println(
                obj.getLongestSubsequence(
                        new String[]{"a","b","c","d"},
                        new int[] {0,0,1,1}
                )
        );
    }
}
