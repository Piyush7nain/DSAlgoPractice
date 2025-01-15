public class IsSubsequence {
    /**
     * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
     *
     * A subsequence of a string is a new string that is formed from the original string by
     * deleting some (can be none) of the characters without disturbing the relative positions of
     * the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
     *
     * Example 1:
     * Input: s = "abc", t = "ahbgdc"
     * Output: true
     *
     *  Example 2:
     * Input: s = "axc", t = "ahbgdc"
     * Output: false
     *
     * Constraints:
     * 0 <= s.length <= 100
     * 0 <= t.length <= 104
     * s and t consist only of lowercase English letters.
     * */
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty() && t.isEmpty()) {
            return true;
        }else if (s.isEmpty() ) {
            return true;
        }else if (t.isEmpty() ) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int c =0;
        int i =0;
        while ( c < s.length() && i< t.length()) {
            if(tArray[i]==sArray[c]) {
                c++;
            }
            i++;
        }
        return c==s.length();
    }

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.isSubsequence("abc", "xbacsbsdcabc"));
    }
}
