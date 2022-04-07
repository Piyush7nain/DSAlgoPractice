public class WordSearch {

    char[][] chars;
    boolean[][] visited;

    public static void main(String[] args) {
        char[][] arr = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        WordSearch temp = new WordSearch();
        temp.exist(arr, word);
    }
    public boolean exist(char[][] board, String word) {
        chars = board;
        visited = new boolean[chars.length][chars[0].length];
        int curr = 0;
        for(int i =0;i<chars.length;i++){
            for(int j = 0; j<chars[0].length;j++){
                if(backTrack(i, j, curr, word))
                    return true;
            }
        }
        return false;

    }

    boolean backTrack(int i, int j, int curr, String word){
        if(curr == word.length())
            return true;
        if( i<0 || i>=chars.length || j<0 || j>=chars[0].length)
            return false;
        if(!visited[i][j] && chars[i][j]== word.charAt(curr)){
            System.out.println(chars[i][j]);
            visited[i][j]=true;
            if( backTrack(i, j+1, curr+1, word))
                return true;
            else if(backTrack(i, j-1, curr+1, word))
                return true;
            else if(backTrack(i+1, j, curr+1, word))
                return true;
            else if(backTrack(i-1, j, curr+1, word))
                return true;
            visited[i][j] = false;
        }

        return false;

    }
}
