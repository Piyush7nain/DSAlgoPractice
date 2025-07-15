import java.util.List;

public class FindStringWhichEndInOtherStrings {

    /**
     * For a given arrays of strings, find total number of string which are either equal to one another or
     * either of the string ends in another string
     *
     * eg: "apple", "pineapple". this is a valid pair as pineapple ends with apple
     *
     * */


    static class TrieNode{
        char c;
        TrieNode[] children = new TrieNode[26];
        int visits =0;
    }

    void addElement(TrieNode root, char[] chars){

        for(int i = chars.length-1; i >= 0; i--){
            char c = chars[i];
            if(root.children[c-'a'] == null){
                root.children[c-'a'] = new TrieNode();
            }
            root.children[c-'a'].visits++;
            root = root.children[c-'a'];
        }
    }

    int findElements(TrieNode root, char[] chars){
        for(int i = chars.length-1; i >= 0; i--){
            char c = chars[i];
            if(root.children[c-'a'] == null){
                return 0;
            }
            root = root.children[c-'a'];
        }
        return root.visits-1;
    }

    public int countPairs(String[] words) {
        if(words == null || words.length == 0) return 0;
        TrieNode root = new TrieNode();
        for(String word : words){
            addElement(root, word.toCharArray());
        }
        int count = 0;
        for(String word : words){
            count += findElements(root, word.toCharArray());
        }
        return count;
    }

    public static void main(String[] args) {
        FindStringWhichEndInOtherStrings findStringWhichEndInOtherStrings = new FindStringWhichEndInOtherStrings();
        String[] arr = new String[]{
                "apple", "banana"
        };
        System.out.println(findStringWhichEndInOtherStrings.countPairs(arr));
    }
}
