import java.util.*;

public class GroupAnagrams {
    /**Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.

     An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

     Example 1:

     Input: strs = ["act","pots","tops","cat","stop","hat"]

     Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
     * */

    public List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> result = new ArrayList<>();

        int[] accessed = new int[strs.length];
        for (int i=0;i<strs.length;i++) {
            if (accessed[i]==0) {
                String comp = strs[i];
                accessed[i]=1;
                List<String> anagrams = new ArrayList<>();
                anagrams.add(comp);
                for (int j =i+1;j<strs.length;j++) {
                    if (accessed[j]==0 && isAnagram(comp, strs[j])) {
                        anagrams.add(strs[j]);
                        accessed[j]=1;
                    }
                }
                result.add(anagrams);
            }

        }
        return result;
    }
    public boolean isAnagram(String s, String t){
        if(s.length()!=t.length()) return false;

        int[] store = new int[26]; // array with all zero
        for (int i=0;i<s.length();i++){
            store[s.charAt(i)-'a']++; // will increase the char count by 1
            store[t.charAt(i)-'a']--; // will decrease the char count by 1
        }

        for(int i:store)
            if (i!=0) return false;

        return true;
    }
}
