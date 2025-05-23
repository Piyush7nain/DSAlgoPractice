public class MaximumRepeatingSubstring {

    /**
     * https://leetcode.com/problems/maximum-repeating-substring/description/
     * */

    public int maxRepeating(String sequence, String word) {
        int[] counts = new int[sequence.length()];
        char[] chars = sequence.toCharArray();
        char[] words = word.toCharArray();
        int last = sequence.length() - 1;
        int max = 0;
        while(last >= 0) {
            if(stringMatch(chars, words, last)) {
                if(last + words.length >= chars.length) {
                    counts[last] = 1;
                }else{
                    counts[last] = counts[last + words.length] + 1;
                }
            }
            max = Math.max(max, counts[last]);
            last--;
        }
        return max;
    }
    boolean stringMatch(char[] chars, char[] words, int start) {
        boolean found = true;
        int w = 0;
        if(start + words.length >= chars.length) {
            found = false;
        }
        while(found && start <chars.length && w < words.length) {
            if(chars[start] != words[w]) {
                found = false;
            }
            start++;
            w++;
        }
        return found;
    }
    public static void main(String[] args) {
        MaximumRepeatingSubstring mrs = new MaximumRepeatingSubstring();
        System.out.println(mrs.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
    }
}
