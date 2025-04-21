import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordSearchII {
    /**
     * https://leetcode.com/problems/word-search-ii/description/
     */
    TrieNode root;
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        if (board == null || board.length == 0 || board[0].length == 0) {
            return new ArrayList<>();
        }
        buildTrie(words);
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(root.children.get(board[i][j]) != null) {
                    dfs(board, visited, i, j, root.children.get(board[i][j]), res);
                }
            }
        }
        return new ArrayList<>(res);
    }

    void dfs(char[][] board, boolean[][] visited, int i, int j, TrieNode root, Set<String> res) {
        if(i<0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 ){
            return;
        }
        if(visited[i][j]){
            return;
        }
        if(root.c != board[i][j]){
            return;
        }
        if(root.isWord){
            res.add(root.word);
        }
        visited[i][j] = true;
        for(Map.Entry<Character, TrieNode> child : root.children.entrySet()) {
            char c = child.getKey();
            TrieNode childNode = child.getValue();
            for(int[] dir : dir) {
                int x = i + dir[0];
                int y = j + dir[1];
                dfs(board,visited, x, y, childNode, res);
            }
        }
        visited[i][j] = false;
    }
    void buildTrie(String[] words) {
        root = new TrieNode();
        for (String word : words) {
            char[] chars = word.toCharArray();
            TrieNode cur = root;
            for (int i = 0; i < chars.length; i++) {
                int finalI = i;
                cur.children.computeIfAbsent(chars[i], k -> new TrieNode(chars[finalI]));
                cur = cur.children.get(chars[i]);
                if(i == chars.length - 1) {
                    cur.isWord = true;
                    cur.word = word;
                }
            }
        }
    }
    static class TrieNode {
        char c;
        boolean isWord;
        String word;
        Map<Character, TrieNode> children = new HashMap<>();
        public TrieNode() {}
        public TrieNode(char c) {
            this.c = c;
        }
        public TrieNode(char c, boolean isWord) {
            this.c = c;
        }
    }

    public static void main(String[] args) {
        WordSearchII wordSearchII = new WordSearchII();
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        List<String> res = wordSearchII.findWords(board, words);
        System.out.println(res);
    }
}
