public class FindIndexOfFirstOccurance {
    /**
     * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
     * or -1 if needle is not part of haystack.
     *
     * Example 1:
     *
     * Input: haystack = "sadbutsad", needle = "sad"
     * Output: 0
     * Explanation: "sad" occurs at index 0 and 6.
     * The first occurrence is at index 0, so we return 0.
     * Example 2:
     *
     * Input: haystack = "leetcode", needle = "leeto"
     * Output: -1
     * Explanation: "leeto" did not occur in "leetcode", so we return -1.
     * */

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        int start = 0;
        int end = 0;
        int n =0;
        while(end<haystack.length()){
            if(haystack.charAt(end)==needle.charAt(n)){
                if(n==0){
                    start = end;
                }
                n++;
                if(n==needle.length()){ return start;}
            }else{
                n=0;
                end = start;
                start++;
            }
            end++;
        }
        return -1;

    }

    public static void main(String[] args) {
        FindIndexOfFirstOccurance findIndexOfFirstOccurance = new FindIndexOfFirstOccurance();
        System.out.println(findIndexOfFirstOccurance.strStr("mississippi", "issip"));
    }
}
