import java.util.List;

public class ImplementTrie {

    /**
     * https://leetcode.com/problems/implement-trie-prefix-tree/description/
     * */

    TrieNode root;
    public ImplementTrie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode current = root;
        for (int i = 0; i < chars.length; i++) {
            if(current.children[chars[i]-'a'] == null) {
                current.children[chars[i]-'a'] = new TrieNode(chars[i]);
            }
            current = current.children[chars[i]-'a'];
            if(i == chars.length - 1) {
                current.word = word;
            }
        }
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode current = root;
        for (char aChar : chars) {
            if (current.children[aChar - 'a'] == null) {
                return false;
            }
            current = current.children[aChar - 'a'];
        }
        return current.word.equals(word);
    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode current = root;
        for (char aChar : chars) {
            if (current.children[aChar - 'a'] == null) {
                return false;
            }
            current = current.children[aChar - 'a'];
        }
        return true;
    }

    static class TrieNode {
        char c;
        String word = "";
        TrieNode[] children = new TrieNode[26];
        public TrieNode(char c) {
            this.c = c;
        }
        public TrieNode(char c, String word) {
            this.c = c;
            this.word = word;
        }
        public TrieNode(){}
    }

    public static void main(String[] args) {
        ImplementTrie trie = new ImplementTrie();
        trie.insert("apple");
        trie.insert("tree");
        List<Boolean> list =  List.of(
        trie.search("apple"),
        trie.search("app"),
        trie.startsWith("app"),
        trie.search("tree"),
        trie.startsWith("tr"));

        System.out.println(list);
    }
}
