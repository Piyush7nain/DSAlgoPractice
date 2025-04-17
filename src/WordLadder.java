import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 0;
        }
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Set<Character> charSet = new HashSet<>();
        int steps = 1;
        for(String word : wordSet){
            for(char c : word.toCharArray()){
                charSet.add(c);
            }
        }
        if(!wordSet.contains(endWord)){
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int currLen = 1;
        while(!queue.isEmpty()){
            if(currLen ==0){
                currLen = queue.size();
            }
            String word = queue.poll();
            currLen--;
            for(int i=0; i<word.length(); i++){
                char[] cArr = word.toCharArray();
                char ch = cArr[i];
                for(char c: charSet){
                    cArr[i] = c;
                    String newWord = new String(cArr);
                    if(newWord.equals(endWord) && wordSet.contains(newWord)){
                        return steps+1;
                    }
                    if(wordSet.contains(newWord)&& !visited.contains(newWord)){
                        queue.offer(newWord);
                        visited.add(newWord);
                    }
                    cArr[i] = ch;
                }
            }
            if(currLen ==0){
                steps++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        List<String> wordList = new ArrayList<>(List.of(new String[]{"hot", "dot", "dog", "lot", "log", "cog","rog","dig", "tig","tag"}));
        System.out.println(wordLadder.ladderLength("hit", "tag", wordList));

    }
}
