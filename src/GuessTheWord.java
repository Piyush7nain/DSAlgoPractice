import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class GuessTheWord {

    /**
     * https://leetcode.com/problems/guess-the-word/description/
     * */
    public void findSecretWord(String[] wordsToGuess, Master master) {

        Random random = new Random();
        List<String> candidates = new ArrayList<>(List.of(wordsToGuess));
        int match = 0;
        while(match !=6){
            String guessWord = candidates.get(random.nextInt(candidates.size()));
            match = master.guess(guessWord);
            System.out.println("For word " + guessWord + " match : " +match);
            List<String> newCandidates = new ArrayList<>();
            for (String candidate : candidates) {
                if(stringMatch(candidate, guessWord) == match){
                    newCandidates.add(candidate);
                }
            }
            candidates = newCandidates;
        }

    }


    int stringMatch(String a, String b) {
        int match = 0;
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == b.charAt(i)) {
                match += 1;
            }
        }
        return match;
    }

    public static void main(String[] args) {
        GuessTheWord gw = new GuessTheWord();
        gw.findSecretWord(new String[]{"gaxckt","trlccr","jxwhkz","ycbfps","peayuf","yiejjw","ldzccp","nqsjoa","qrjasy","pcldos","acrtag","buyeia","ubmtpj","drtclz","zqderp","snywek","caoztp","ibpghw","evtkhl","bhpfla","ymqhxk","qkvipb","tvmued","rvbass","axeasm","qolsjg","roswcb","vdjgxx","bugbyv","zipjpc","tamszl","osdifo","dvxlxm","iwmyfb","wmnwhe","hslnop","nkrfwn","puvgve","rqsqpq","jwoswl","tittgf","evqsqe","aishiv","pmwovj","sorbte","hbaczn","coifed","hrctvp","vkytbw","dizcxz","arabol","uywurk","ppywdo","resfls","tmoliy","etriev","oanvlx","wcsnzy","loufkw","onnwcy","novblw","mtxgwe","rgrdbt","ckolob","kxnflb","phonmg","egcdab","cykndr","lkzobv","ifwmwp","jqmbib","mypnvf","lnrgnj","clijwa","kiioqr","syzebr","rqsmhg","sczjmz","hsdjfp","mjcgvm","ajotcx","olgnfv","mjyjxj","wzgbmg","lpcnbj","yjjlwn","blrogv","bdplzs","oxblph","twejel","rupapy","euwrrz","apiqzu","ydcroj","ldvzgq","zailgu","xgqpsr","wxdyho","alrplq","brklfk"}
                , new Master("hbaczn"));
    }

    static class Master {
        String secretWord ;
        public Master(String word) {
            this.secretWord = word;
        }
        int guess(String word){
            GuessTheWord gw = new GuessTheWord();
            return  gw.stringMatch(word, secretWord);
        };
    }
}
