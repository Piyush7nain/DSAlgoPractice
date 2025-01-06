public class ReverseWordsInAString {
    /**
     * Given an input string s, reverse the order of the words.
     *
     * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
     *
     * Return a string of the words in reverse order concatenated by a single space.
     *
     * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "the sky is blue"
     * Output: "blue is sky the"
     * Example 2:
     *
     * Input: s = "  hello world  "
     * Output: "world hello"
     * Explanation: Your reversed string should not contain leading or trailing spaces.
     * Example 3:
     *
     * Input: s = "a good   example"
     * Output: "example good a"
     * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 104
     * s contains English letters (upper-case and lower-case), digits, and spaces ' '.
     * There is at least one word in s.
     * */

    // Using Char array. Save each word in String array and concat that array in reverse order
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        int i = 0, j = words.length - 1;
        while (i < j) {
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;
            i++;
            j--;
        }
        for(String word : words) {
            sb.append(word).append(" ");
        }
        return sb.toString().trim();
    }

    // Using String Builder and Linked List
    public String reverseWords2(String s) {

        int i = 0, j = s.length() - 1;
        StringBuilder current = new StringBuilder();
        Node tail = new Node();
        tail.word ="";
        while (i<=j) {
            if(s.charAt(i)!=' ' ) {
                current.append(s.charAt(i));
            }else if(s.charAt(i)==' '&& !current.isEmpty()) {
                current.append(" ");
                Node n = new Node();
                n.word=current.toString();
                n.previous = tail;
                tail = n;
                current.setLength(0);
            }
            i++;
        }
        if(!current.isEmpty()){
            current.append(" ");
            Node n = new Node();
            n.word=current.toString();
            n.previous = tail;
            tail = n;
        }
        StringBuilder result = new StringBuilder();
        while(tail!=null){
            result.append(tail.word);
            tail = tail.previous;
        }
        result.deleteCharAt(result.length()-1);
//        result.append("-");
        return result.toString();
    }

    static class Node{
        String word;
        Node previous;
    }

    public static void main(String[] args) {
        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
        System.out.println(reverseWordsInAString.reverseWords("   a good   example   "));
    }
}
