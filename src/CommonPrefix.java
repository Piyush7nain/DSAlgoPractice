public class CommonPrefix {

/*  Write a function to find the longest common prefix string amongst an array of strings.
    If there is no common prefix, return an empty string "".
    Example 1:
    Input: strs = ["flower","flow","flight"]
    Output: "fl"*/


    public String longestCommonPrefix(String[] strs) {

        String commonStr = strs[0];
        int shortest = strs[0].length();
        for(int i = 1; i < strs.length; i++) {
            if(strs[i].length() < shortest) {
                shortest = strs[i].length();
                commonStr = strs[i];
            }
        }
        for(int i = 0; i<strs.length;i++){
            commonStr = common(commonStr.toCharArray(), strs[i].toCharArray());
            if(commonStr.isEmpty())
                return "";

        }
        return commonStr;

    }

    String common(char[] s1, char[] s2){
        StringBuilder sb = new StringBuilder();
        int l1 = s1.length;
        int l2 = s2.length;
        for(int i=0 ; i<l1 && i<l2; i++){

            if(s1[i]==s2[i])
                sb.append(s1[i]);
            else break;
        }

        return sb.toString();
    }
}
