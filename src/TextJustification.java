import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    /**
     * Given an array of strings words and a width maxWidth, format the text such that each line has
     * exactly maxWidth characters and is fully (left and right) justified.
     *
     * You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
     * Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
     *
     * Extra spaces between words should be distributed as evenly as possible.
     *If the number of spaces on a line does not divide evenly between words,
     * the empty slots on the left will be assigned more spaces than the slots on the right.
     *
     * For the last line of text, it should be left-justified, and no extra space is inserted between words.
     *
     * Note:
     * A word is defined as a character sequence consisting of non-space characters only.
     * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
     * The input array words contains at least one word.
     *
     *
     * Example 1:
     *
     * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
     * Output:
     * [
     *    "This    is    an",
     *    "example  of text",
     *    "justification.  "
     * ]
     * Example 2:
     *
     * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
     * Output:
     * [
     *   "What   must   be",
     *   "acknowledgment  ",
     *   "shall be        "
     * ]
     * Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
     * Note that the second line is also left-justified because it contains only one word.
     * Example 3:
     *
     * Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
     * Output:
     * [
     *   "Science  is  what we",
     *   "understand      well",
     *   "enough to explain to",
     *   "a  computer.  Art is",
     *   "everything  else  we",
     *   "do                  "
     * ]
     *
     *
     * Constraints:
     *
     * 1 <= words.length <= 300
     * 1 <= words[i].length <= 20
     * words[i] consists of only English letters and symbols.
     * 1 <= maxWidth <= 100
     * words[i].length <= maxWidth
     * */

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<List<String>> sets = new ArrayList<>();
        int currentSize = 0;
        List<String> currentWords = new ArrayList<>();
        for (String word : words) {
            if(currentSize + word.length() < maxWidth) {
                currentWords.add(word);
                //account for atleast one space after each word
                currentSize += word.length()+1;
            }else{
                sets.add(currentWords);
                currentWords = new ArrayList<>();
                currentWords.add(word);
                currentSize =word.length()+1;
            }
        }
        sets.add(currentWords);
        for(int i = 0 ; i < sets.size()-1 ; i++) {
            result.add(justify(sets.get(i), maxWidth));
        }
        result.add(justifyLast(sets.get(sets.size()-1), maxWidth));
        return result;
    }

    private String justifyLast(List<String> words, int maxWidth) {
        StringBuilder result = new StringBuilder();
        int size =0;
        for(String word : words) {
            result.append(word);
            result.append(" ");
            size+=word.length()+1;
        }
        result.deleteCharAt(result.length()-1);
        for(int i = 0 ; i <= maxWidth - size ; i++) {
            result.append(" ");
        }
        return result.toString();
    }
    private String justify(List<String> set, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        //calculate number of space between each word
        int spaces = Math.max(1,set.size()-1);
        int chars = 0;
        for(String word : set) {
            chars += word.length();
        }
        int totalSpaces = maxWidth - chars;
        int[] sLen = new int[spaces];
        for(int i = 0; i < totalSpaces; i++) {
            sLen[(spaces+i)%spaces]++;
        }
        for(int i = 0; i < set.size(); i++) {
            sb.append(set.get(i));
            if(i<sLen.length) {
                for(int j = 0; j < sLen[i]; j++) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        TextJustification textJustification = new TextJustification();
        System.out.println(
                textJustification
                        .fullJustify(
                                new String[]{"This", "is", "an", "example", "of", "text", "justification."}
                                , 16));
    }
}
